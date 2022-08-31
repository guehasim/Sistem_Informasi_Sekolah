/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package komponen;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import usu.util.StringUtil;
import usu.widget.text.DefaultDocument;

/**
 *
 * @author GITA
 */
public class passwordtext extends usu.widget.glass.PasswordBox {
private static final long suid = 1L;
public passwordtext(){
    super();
    setSelectionColor(Color.GRAY);
    setCaretColor(Color.WHITE);
    setFont(getFont().deriveFont(Font.BOLD));
    setForeground(Color.BLACK);
    setHorizontalAlignment(LEFT);
    addFocusListener(new FocusAdapter() {

            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                selectAll();
            }




    });
    setDocument(new DefaultDocument(){
        private static final long suid = 1L;

            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if(StringUtil.containQuote(str)){
                    return;
                }

                super.insertString(offs, str, a);
            }
        
    });

}
}
