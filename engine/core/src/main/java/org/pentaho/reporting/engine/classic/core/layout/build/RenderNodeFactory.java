/*!
 * This program is free software; you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License, version 2.1 as published by the Free Software
 * Foundation.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this
 * program; if not, you can obtain a copy at http://www.gnu.org/licenses/old-licenses/lgpl-2.1.html
 * or from the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * Copyright (c) 2002-2017 Hitachi Vantara..  All rights reserved.
 */

package org.pentaho.reporting.engine.classic.core.layout.build;

import org.pentaho.reporting.engine.classic.core.ReportDefinition;
import org.pentaho.reporting.engine.classic.core.ReportElement;
import org.pentaho.reporting.engine.classic.core.layout.model.LogicalPageBox;
import org.pentaho.reporting.engine.classic.core.layout.model.RenderBox;
import org.pentaho.reporting.engine.classic.core.layout.model.RenderableReplacedContentBox;
import org.pentaho.reporting.engine.classic.core.layout.model.context.BoxDefinition;
import org.pentaho.reporting.engine.classic.core.layout.output.OutputProcessorMetaData;
import org.pentaho.reporting.engine.classic.core.states.ReportStateKey;
import org.pentaho.reporting.engine.classic.core.style.StyleSheet;

public interface RenderNodeFactory extends Cloneable {
  public LogicalPageBox createPage( final ReportDefinition report, final StyleSheet style );

  public RenderBox produceSubReportPlaceholder( final ReportElement element, final StyleSheet style,
      final ReportStateKey stateKey );

  public RenderBox produceSectionBox( final String layoutType, final ReportStateKey stateKey );

  public RenderBox produceRenderBox( final ReportElement band, final StyleSheet style, final String layoutType,
      final ReportStateKey stateKey );

  @Deprecated
  public RenderBox createAutoParagraph( final ReportStateKey stateKey );

  public RenderBox
    createAutoParagraph( final ReportElement band, final StyleSheet style, final ReportStateKey stateKey );

  public StyleSheet createAutoGeneratedSectionStyleSheet( final StyleSheet style );

  public RenderableReplacedContentBox createReplacedContent( final ReportElement element, final StyleSheet style,
      final Object value, final Object rawValue, final ReportStateKey stateKey );

  public BoxDefinition getBoxDefinition( StyleSheet style );

  public RenderBox createPageBreakIndicatorBox( final ReportStateKey stateKey, final long range );

  public StyleSheet createStyle( StyleSheet style );

  public void close();

  void initialize( OutputProcessorMetaData outputProcessorMetaData );
}
