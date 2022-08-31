
package komponen;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import usu.util.StringUtil;
import usu.widget.glass.TextBoxGlass;
import usu.widget.text.DefaultDocument;


public class TextBox_1 extends TextBoxGlass {

    
    private static final long serialVersionUID = 1L;

    public TextBox_1() {
        super();
        setFont(getFont().deriveFont(Font.BOLD));
        setForeground(Color.WHITE);
        setSelectionColor(Color.BLUE.brighter());
        setCaretColor(Color.white);
        setHorizontalAlignment(LEFT);
        
        addFocusListener(new FocusAdapter() {

            @Override
            public void focusGained(FocusEvent e) {
                selectAll();
            }
        });
        setDocument(new DefaultDocument() {

            /*
             * Serial version UID
             */
            private static final long serialVersionUID = 1L;

            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (StringUtil.containQuote(str)) {
                    return;
                }
                super.insertString(offs, str, a);
            }
        });
    }
}
