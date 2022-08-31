/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package komponen;

import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author GITA
 */
public class label extends usu.widget.Label {
    private static final long suid = 1L;

    public label(){
        setForeground(Color.BLACK);
        setFont(getFont().deriveFont(Font.BOLD));
        
    }
}
