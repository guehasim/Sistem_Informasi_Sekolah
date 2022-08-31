/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package komponen;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author GITA
 */
public class panel extends JPanel {
private static final long suid = 1L;
private Color abu_abu = Color.WHITE;
private BufferedImage gambargradient;
private Color warna = Color.ORANGE;

public panel(){
    super();
}

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(isOpaque()){
            Graphics2D gd = (Graphics2D) g.create();
            gd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            instal_gradient();
            gd.drawImage(gambargradient, 0, 0, getWidth(), getHeight(), null);
            int lebar = getWidth();
            int tinggi = getHeight() * 5 / 100;
            Color terang = new Color(1F, 1F, 1F, 0.5F);
            Color gelap = new Color(1F, 1F, 1F, 0.0F);
            GradientPaint paint = new GradientPaint(0, 0, terang, 0, tinggi, gelap);
            GeneralPath path = new GeneralPath();
            path.moveTo(0, getHeight());
            path.lineTo(0, getHeight()-tinggi);
            path.curveTo(0, getHeight() - tinggi, lebar/2, getHeight()- tinggi/2, lebar, getHeight()- tinggi);
            path.lineTo(lebar, getHeight());
            path.closePath();
            gd.setPaint(paint);
            gd.fill(path);
            gd.dispose();
        }

    }


    private void instal_gradient() {
       gambargradient = new BufferedImage(1, getHeight(), BufferedImage.TYPE_INT_ARGB);
       Graphics2D gd = (Graphics2D) gambargradient.getGraphics();
       gd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

       GradientPaint gmb   = new GradientPaint(0, 0, abu_abu, 0, getHeight(), warna);
       gd.setPaint(gmb);
       gd.fillRect(0, 0, 1, getHeight());
       gd.dispose();

    }


}
