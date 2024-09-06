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

package org.pentaho.reporting.libraries.designtime.swing.colorchooser;

import java.awt.*;

public class SwingColorSchema implements ColorSchema {
  private static final Color[] COLORS = new Color[] {
    new Color( 255, 255, 255 ),
    new Color( 204, 255, 255 ),
    new Color( 204, 204, 255 ),
    new Color( 255, 204, 255 ),
    new Color( 255, 204, 204 ),
    new Color( 255, 255, 204 ),
    new Color( 204, 255, 204 ),
    new Color( 204, 204, 204 ),
    new Color( 153, 255, 255 ),
    new Color( 153, 204, 255 ),
    new Color( 153, 153, 255 ),
    new Color( 204, 153, 255 ),
    new Color( 255, 153, 255 ),
    new Color( 255, 153, 204 ),
    new Color( 255, 153, 153 ),
    new Color( 255, 204, 153 ),
    new Color( 255, 255, 153 ),
    new Color( 204, 255, 153 ),
    new Color( 153, 255, 153 ),
    new Color( 153, 255, 204 ),
    new Color( 102, 255, 255 ),
    new Color( 102, 204, 255 ),
    new Color( 102, 153, 255 ),
    new Color( 102, 102, 255 ),
    new Color( 153, 102, 255 ),
    new Color( 204, 102, 255 ),
    new Color( 255, 102, 255 ),
    new Color( 255, 102, 204 ),
    new Color( 255, 102, 153 ),
    new Color( 255, 102, 102 ),
    new Color( 255, 153, 102 ),
    new Color( 255, 204, 102 ),
    new Color( 255, 255, 102 ),
    new Color( 204, 255, 102 ),
    new Color( 153, 255, 102 ),
    new Color( 102, 255, 102 ),
    new Color( 102, 255, 153 ),
    new Color( 102, 255, 204 ),
    new Color( 153, 153, 153 ),
    new Color( 51, 255, 255 ),
    new Color( 51, 204, 255 ),
    new Color( 51, 153, 255 ),
    new Color( 51, 102, 255 ),
    new Color( 51, 51, 255 ),
    new Color( 102, 51, 255 ),
    new Color( 153, 51, 255 ),
    new Color( 204, 51, 255 ),
    new Color( 255, 51, 255 ),
    new Color( 255, 51, 204 ),
    new Color( 255, 51, 153 ),
    new Color( 255, 51, 102 ),
    new Color( 255, 51, 51 ),
    new Color( 255, 102, 51 ),
    new Color( 255, 153, 51 ),
    new Color( 255, 204, 51 ),
    new Color( 255, 255, 51 ),
    new Color( 204, 255, 51 ),
    new Color( 153, 255, 51 ),
    new Color( 102, 255, 51 ),
    new Color( 51, 255, 51 ),
    new Color( 51, 255, 102 ),
    new Color( 51, 255, 153 ),
    new Color( 51, 255, 204 ),
    new Color( 0, 255, 255 ),
    new Color( 0, 204, 255 ),
    new Color( 0, 153, 255 ),
    new Color( 0, 102, 255 ),
    new Color( 0, 51, 255 ),
    new Color( 0, 0, 255 ),
    new Color( 51, 0, 255 ),
    new Color( 102, 0, 255 ),
    new Color( 153, 0, 255 ),
    new Color( 204, 0, 255 ),
    new Color( 255, 0, 255 ),
    new Color( 255, 0, 204 ),
    new Color( 255, 0, 153 ),
    new Color( 255, 0, 102 ),
    new Color( 255, 0, 51 ),
    new Color( 255, 0, 0 ),
    new Color( 255, 51, 0 ),
    new Color( 255, 102, 0 ),
    new Color( 255, 153, 0 ),
    new Color( 255, 204, 0 ),
    new Color( 255, 255, 0 ),
    new Color( 204, 255, 0 ),
    new Color( 153, 255, 0 ),
    new Color( 102, 255, 0 ),
    new Color( 51, 255, 0 ),
    new Color( 0, 255, 0 ),
    new Color( 0, 255, 51 ),
    new Color( 0, 255, 102 ),
    new Color( 0, 255, 153 ),
    new Color( 0, 255, 204 ),
    new Color( 102, 102, 102 ),
    new Color( 0, 204, 204 ),
    new Color( 0, 153, 204 ),
    new Color( 0, 102, 204 ),
    new Color( 0, 51, 204 ),
    new Color( 0, 0, 204 ),
    new Color( 51, 0, 204 ),
    new Color( 102, 0, 204 ),
    new Color( 153, 0, 204 ),
    new Color( 204, 0, 204 ),
    new Color( 204, 0, 153 ),
    new Color( 204, 0, 102 ),
    new Color( 204, 0, 51 ),
    new Color( 204, 0, 0 ),
    new Color( 204, 51, 0 ),
    new Color( 204, 102, 0 ),
    new Color( 204, 153, 0 ),
    new Color( 204, 204, 0 ),
    new Color( 153, 204, 0 ),
    new Color( 102, 204, 0 ),
    new Color( 51, 204, 0 ),
    new Color( 0, 204, 0 ),
    new Color( 0, 204, 51 ),
    new Color( 0, 204, 102 ),
    new Color( 0, 204, 153 ),
    new Color( 0, 153, 153 ),
    new Color( 0, 102, 153 ),
    new Color( 0, 51, 153 ),
    new Color( 0, 0, 153 ),
    new Color( 51, 0, 153 ),
    new Color( 102, 0, 153 ),
    new Color( 153, 0, 153 ),
    new Color( 153, 0, 102 ),
    new Color( 153, 0, 51 ),
    new Color( 153, 0, 0 ),
    new Color( 153, 51, 0 ),
    new Color( 153, 102, 0 ),
    new Color( 153, 153, 0 ),
    new Color( 102, 153, 0 ),
    new Color( 51, 153, 0 ),
    new Color( 0, 153, 0 ),
    new Color( 0, 153, 51 ),
    new Color( 0, 153, 102 ),
    new Color( 51, 51, 51 ),
    new Color( 0, 102, 102 ),
    new Color( 0, 51, 102 ),
    new Color( 0, 0, 102 ),
    new Color( 51, 0, 102 ),
    new Color( 102, 0, 102 ),
    new Color( 102, 0, 51 ),
    new Color( 102, 0, 0 ),
    new Color( 102, 51, 0 ),
    new Color( 102, 102, 0 ),
    new Color( 51, 102, 0 ),
    new Color( 0, 102, 0 ),
    new Color( 0, 102, 51 ),
    new Color( 0, 0, 0 ),
    new Color( 0, 51, 51 ),
    new Color( 0, 0, 51 ),
    new Color( 51, 0, 51 ),
    new Color( 51, 0, 0 ),
    new Color( 51, 51, 0 ),
    new Color( 0, 51, 0 ),

  };

  public SwingColorSchema() {
  }

  public Color[] getColors() {
    return COLORS.clone();
  }

  public String getName() {
    return ColorChooserMessages.getInstance().getString( "ColorSchema.Swing" );
  }
}
