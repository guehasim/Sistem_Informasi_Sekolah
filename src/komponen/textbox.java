/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package komponen;

import java.awt.Color;
import java.awt.Font;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import usu.util.StringUtil;
import usu.widget.glass.FormatedTextBox;
import usu.widget.text.DefaultDocument;

/**
 *
 * @author GITA
 */
public class textbox extends FormatedTextBox {
public static final long suid = 1L;

public textbox(){
    setFont(getFont().deriveFont(Font.BOLD));
    setForeground(Color.BLACK);
    setSelectionColor(Color.GRAY.brighter());
    setCaretColor(Color.WHITE);
    setHorizontalAlignment(LEFT);
    setDocument(new DefaultDocument(){
    public static final long suid =1L;

            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {

                if(StringUtil.containQuote(str)){
                    return;
                }
                super.insertString(offs, str, a);

            }






    });
}

    public void setText(long kembalian) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
