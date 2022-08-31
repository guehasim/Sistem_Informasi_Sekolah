/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package komponen;

import java.awt.Color;
import javax.swing.JTable;
import usu.widget.util.WidgetUtilities;

/**
 *
 * @author GITA
 */
public class tabel extends JTable {
public static final long suid =1L;

public tabel(){
    super();
    setForeground(Color.WHITE);
    setSelectionBackground(Color.BLUE.brighter());
        setSelectionForeground(Color.BLACK);
        setFillsViewportHeight(true);
        setOpaque(false);
        WidgetUtilities.setAutomaticPopUpMenu(this);
        setAutoCreateRowSorter(true);
        getTableHeader().setReorderingAllowed(false);
}

    @Override
    public boolean isCellEditable(int row, int column) {
      return false;

    }

}
