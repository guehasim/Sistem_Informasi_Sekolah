
package komponen;

import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;


public class TextArea extends JTextArea {

    private static final long serialVersionUID = 1L;

    public TextArea() {
        super();
        setBackground(Color.RED);
        setOpaque(false);
        setLineWrap(true);
        setWrapStyleWord(true);
        setFont(new java.awt.Font("Tahoma", 1, 11));
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setForeground(Color.WHITE);
    }
}
