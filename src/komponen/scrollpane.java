/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package komponen;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import usu.widget.glass.ViewPortGlass;

/**
 *
 * @author GITA
 */


public class scrollpane extends JScrollPane {
private static final long suid =1L;
public scrollpane(){
    super();
    setViewport(new ViewPortGlass());
    setOpaque(false);
    setBorder(new LineBorder(Color.BLACK));
}
}
