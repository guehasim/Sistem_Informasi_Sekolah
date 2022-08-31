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
public class tombol extends usu.widget.ButtonGlass {
private static final long suid = 1L;
public tombol(){
    super();
    setFont(getFont().deriveFont(Font.BOLD));
    setForeground(Color.BLACK);
    setRoundRect(true);
}
}
