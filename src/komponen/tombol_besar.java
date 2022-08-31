/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package komponen;

import java.awt.Color;
import java.awt.Font;
import usu.widget.glass.ButtonImageReflection;

/**
 *
 * @author GITA
 */
public class tombol_besar extends ButtonImageReflection {

    private static final long suid = 1L;

    public tombol_besar(){
        super();
        setForeground(Color.WHITE);
        setFont(getFont().deriveFont(Font.BOLD));
    }

}
