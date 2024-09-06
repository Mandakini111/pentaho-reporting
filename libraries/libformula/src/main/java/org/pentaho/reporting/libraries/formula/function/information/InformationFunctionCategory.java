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

package org.pentaho.reporting.libraries.formula.function.information;

import org.pentaho.reporting.libraries.formula.function.AbstractFunctionCategory;
import org.pentaho.reporting.libraries.formula.function.FunctionCategory;

/**
 * Creation-Date: 05.11.2006, 14:30:36
 *
 * @author Thomas Morgner
 */
public final class InformationFunctionCategory extends AbstractFunctionCategory {
  public static final FunctionCategory CATEGORY = new InformationFunctionCategory();

  private InformationFunctionCategory() {
    super( "org.pentaho.reporting.libraries.formula.function.information.category" );
  }
}
