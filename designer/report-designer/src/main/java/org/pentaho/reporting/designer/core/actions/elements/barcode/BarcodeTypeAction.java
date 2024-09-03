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

package org.pentaho.reporting.designer.core.actions.elements.barcode;

import org.pentaho.reporting.designer.core.actions.AbstractElementSelectionAction;
import org.pentaho.reporting.designer.core.actions.ActionMessages;
import org.pentaho.reporting.designer.core.actions.ToggleStateAction;
import org.pentaho.reporting.designer.core.editor.ReportDocumentContext;
import org.pentaho.reporting.designer.core.model.selection.DocumentContextSelectionModel;
import org.pentaho.reporting.designer.core.util.undo.AttributeEditUndoEntry;
import org.pentaho.reporting.designer.core.util.undo.CompoundUndoEntry;
import org.pentaho.reporting.designer.core.util.undo.UndoEntry;
import org.pentaho.reporting.engine.classic.core.Element;
import org.pentaho.reporting.engine.classic.core.designtime.ReportModelEventFilter;
import org.pentaho.reporting.engine.classic.core.designtime.ReportModelEventFilterFactory;
import org.pentaho.reporting.engine.classic.core.event.ReportModelEvent;
import org.pentaho.reporting.engine.classic.extensions.modules.sbarcodes.SimpleBarcodesAttributeNames;
import org.pentaho.reporting.engine.classic.extensions.modules.sbarcodes.SimpleBarcodesType;
import org.pentaho.reporting.libraries.base.util.ObjectUtilities;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class BarcodeTypeAction extends AbstractElementSelectionAction implements ToggleStateAction {
  private ReportModelEventFilter eventFilter;
  private String type;

  public BarcodeTypeAction( final String type ) {
    this.type = type;
    putValue( Action.SELECTED_KEY, Boolean.FALSE );
    putValue( Action.NAME, type );
    putValue( Action.SHORT_DESCRIPTION, ActionMessages.getString( "BarcodeTypeAction.Description", type ) );
    putValue( Action.MNEMONIC_KEY, ActionMessages.getOptionalMnemonic( "BarcodeTypeAction.Mnemonic" ) );
    putValue( Action.ACCELERATOR_KEY, ActionMessages.getOptionalKeyStroke( "BarcodeTypeAction.Accelerator" ) );

    eventFilter = new ReportModelEventFilterFactory().createAttributeFilter
      ( SimpleBarcodesAttributeNames.NAMESPACE, SimpleBarcodesAttributeNames.TYPE_ATTRIBUTE );
  }

  protected void selectedElementPropertiesChanged( final ReportModelEvent event ) {
    if ( eventFilter.isFilteredEvent( event ) ) {
      updateSelection();
    }
  }

  public boolean isSelected() {
    return Boolean.TRUE.equals( getValue( Action.SELECTED_KEY ) );
  }

  public void setSelected( final boolean selected ) {
    putValue( Action.SELECTED_KEY, selected );
  }

  protected void updateSelection() {
    super.updateSelection();

    final DocumentContextSelectionModel model = getSelectionModel();
    if ( model == null ) {
      return;
    }

    final List<Element> visualElements = model.getSelectedElementsOfType( Element.class );

    boolean selected;
    if ( visualElements.isEmpty() ) {
      selected = false;
    } else {
      selected = true;
      for ( Element visualElement : visualElements ) {
        final Object oldValue = visualElement.getAttribute
          ( SimpleBarcodesAttributeNames.NAMESPACE, SimpleBarcodesAttributeNames.TYPE_ATTRIBUTE );
        selected &= ObjectUtilities.equal( oldValue, type );
      }
    }
    setSelected( selected );
  }

  /**
   * Invoked when an action occurs.
   */
  public void actionPerformed( final ActionEvent e ) {
    final DocumentContextSelectionModel model = getSelectionModel();
    if ( model == null ) {
      return;
    }

    final Element[] visualElements = filterBarcodeElements( model );
    if ( visualElements.length == 0 ) {
      return;
    }
    final ReportDocumentContext activeContext = getActiveContext();
    if ( activeContext == null ) {
      return;
    }

    final ArrayList<UndoEntry> undos = new ArrayList<UndoEntry>();
    for ( int i = 0; i < visualElements.length; i++ ) {
      final Element element = visualElements[ i ];
      final Object oldValue = element.getAttribute
        ( SimpleBarcodesAttributeNames.NAMESPACE, SimpleBarcodesAttributeNames.TYPE_ATTRIBUTE );
      final UndoEntry entry = new AttributeEditUndoEntry( element.getObjectID(),
        SimpleBarcodesAttributeNames.NAMESPACE, SimpleBarcodesAttributeNames.TYPE_ATTRIBUTE,
        oldValue, type );
      undos.add( entry );
      element.setAttribute( SimpleBarcodesAttributeNames.NAMESPACE, SimpleBarcodesAttributeNames.TYPE_ATTRIBUTE, type );
    }
    getActiveContext().getUndo().addChange( ActionMessages.getString( "BarcodeTypeAction.UndoName", type ),
      new CompoundUndoEntry( undos.toArray( new UndoEntry[ undos.size() ] ) ) );
  }


  private Element[] filterBarcodeElements( final DocumentContextSelectionModel model ) {
    final List<Element> visualElements = model.getSelectedElementsOfType( Element.class );
    final ArrayList<Element> retval = new ArrayList<Element>();
    String name = SimpleBarcodesType.INSTANCE.getMetaData().getName();
    for ( Element element : visualElements ) {
      if ( name.equals( element.getElementTypeName() ) ) {
        retval.add( element );
      }
    }
    return retval.toArray( new Element[ retval.size() ] );
  }
}
