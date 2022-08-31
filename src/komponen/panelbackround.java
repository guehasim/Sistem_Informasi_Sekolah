/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package komponen;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author GITA
 */
public class panelbackround extends JPanel {
private Image img;

    public panelbackround() {
  img = new ImageIcon(getClass().getResource("/icon/HS.png")).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
      Graphics2D gd = (Graphics2D) g.create();
      gd.drawImage(img, 0, 0, getWidth(), getHeight(), null);
      gd.dispose();
    }


}
