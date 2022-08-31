/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package komponen;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Reed
 */
public class AlternateTableRowColorRenderer  extends DefaultTableCellRenderer {    
         
    Color currColor=Color.white;  
      
    public AlternateTableRowColorRenderer() {    
        setOpaque(true);    
    }    
  
    
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,      boolean hasFocus, int row, int column) {       
         
        if(row%2==0) {                              
            currColor=Color.white;  
        }      
        else {  
            currColor=new Color(222,222,255);                  
        }                              
        if(isSelected) {  
            super.setForeground(table.getSelectionForeground());  
            super.setBackground(table.getSelectionBackground());  
        } else {  
            super.setForeground(Color.black);     
            super.setBackground(currColor);  
        }                         
        setFont(table.getFont());                                  
        setValue(value);  
        return this;    
    }    
    
}     

