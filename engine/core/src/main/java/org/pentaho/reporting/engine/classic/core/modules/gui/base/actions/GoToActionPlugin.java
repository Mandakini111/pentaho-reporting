/*! ******************************************************************************
 *
 * Pentaho Community Edition
 *
 * Copyright (C) 2024 by Hitachi Vantara, LLC : http://www.pentaho.com
 *
 * Use of this software is governed by the Business Source License included
 * in the LICENSE.TXT file.
 *
 * Change Date: 2028-08-13
 ******************************************************************************/

package org.pentaho.reporting.engine.classic.core.modules.gui.base.actions;

import java.util.Locale;

import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.pentaho.reporting.engine.classic.core.modules.gui.base.PreviewPane;
import org.pentaho.reporting.engine.classic.core.modules.gui.base.SwingPreviewModule;
import org.pentaho.reporting.engine.classic.core.modules.gui.base.internal.NumericInputDialog;
import org.pentaho.reporting.engine.classic.core.modules.gui.commonswing.AbstractActionPlugin;
import org.pentaho.reporting.engine.classic.core.modules.gui.commonswing.SwingGuiContext;
import org.pentaho.reporting.libraries.base.util.ObjectUtilities;
import org.pentaho.reporting.libraries.base.util.ResourceBundleSupport;

/**
 * Creation-Date: 16.11.2006, 16:34:55
 *
 * @author Thomas Morgner
 */
public class GoToActionPlugin extends AbstractActionPlugin implements ControlActionPlugin {
  private static final Log logger = LogFactory.getLog( GoToActionPlugin.class );
  private ResourceBundleSupport resources;

  private PaginatedUpdateListener updateListener;

  public GoToActionPlugin() {
    updateListener = new PaginatedUpdateListener( this );
  }

  public void deinitialize( final SwingGuiContext swingGuiContext ) {
    super.deinitialize( swingGuiContext );
    swingGuiContext.getEventSource().removePropertyChangeListener( updateListener );
  }

  public boolean initialize( final SwingGuiContext context ) {
    super.initialize( context );
    resources =
        new ResourceBundleSupport( context.getLocale(), SwingPreviewModule.BUNDLE_NAME, ObjectUtilities
            .getClassLoader( SwingPreviewModule.class ) );

    context.getEventSource().addPropertyChangeListener( updateListener );
    setEnabled( context.getEventSource().isPaginated() );
    return true;
  }

  protected String getConfigurationPrefix() {
    return "org.pentaho.reporting.engine.classic.core.modules.gui.base.go-to."; //$NON-NLS-1$
  }

  /**
   * Returns the display name for the export action.
   *
   * @return The display name.
   */
  public String getDisplayName() {
    return resources.getString( "action.gotopage.name" ); //$NON-NLS-1$
  }

  /**
   * Returns the short description for the export action.
   *
   * @return The short description.
   */
  public String getShortDescription() {
    return resources.getString( "action.gotopage.description" ); //$NON-NLS-1$
  }

  /**
   * Returns the small icon for the export action.
   *
   * @return The icon.
   */
  public Icon getSmallIcon() {
    final Locale locale = getContext().getLocale();
    return getIconTheme().getSmallIcon( locale, "action.gotopage.small-icon" ); //$NON-NLS-1$
  }

  /**
   * Returns the large icon for the export action.
   *
   * @return The icon.
   */
  public Icon getLargeIcon() {
    final Locale locale = getContext().getLocale();
    return getIconTheme().getLargeIcon( locale, "action.gotopage.icon" ); //$NON-NLS-1$
  }

  /**
   * Returns the accelerator key for the export action.
   *
   * @return The accelerator key.
   */
  public KeyStroke getAcceleratorKey() {
    return resources.getOptionalKeyStroke( "action.gotopage.accelerator" ); //$NON-NLS-1$
  }

  /**
   * Returns the mnemonic key code.
   *
   * @return The code.
   */
  public Integer getMnemonicKey() {
    return resources.getOptionalMnemonic( "action.gotopage.mnemonic" ); //$NON-NLS-1$
  }

  public boolean configure( final PreviewPane reportPane ) {
    final Integer result =
        NumericInputDialog.showInputDialog( getContext().getWindow(), JOptionPane.QUESTION_MESSAGE, resources
            .getString( "dialog.gotopage.title" ), //$NON-NLS-1$
            resources.getString( "dialog.gotopage.message" ), //$NON-NLS-1$
            1, reportPane.getNumberOfPages(), reportPane.getPageNumber(), true );
    if ( result == null ) {
      return false;
    }
    try {
      final int page = result.intValue();
      if ( page > 0 && page <= reportPane.getNumberOfPages() ) {
        reportPane.setPageNumber( page );
      }
    } catch ( Exception ex ) {
      GoToActionPlugin.logger.info( resources.getString( "GoToActionPlugin.INFO_EXCEPTION_SWALLOWED" ) ); //$NON-NLS-1$
    }
    return false;
  }

}
