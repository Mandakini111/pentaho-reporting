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

package org.pentaho.reporting.engine.classic.extensions.toc.parser;

import org.pentaho.reporting.engine.classic.core.modules.parser.bundle.layout.SubReportReadHandler;
import org.pentaho.reporting.engine.classic.extensions.toc.TocElement;
import org.pentaho.reporting.engine.classic.extensions.toc.TocElementType;

public class TocReadHandler extends SubReportReadHandler {
  public TocReadHandler() {
    super( TocElementType.INSTANCE, TocElement.class );
  }
}

