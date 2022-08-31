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
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Timer;
import javax.swing.JProgressBar;

/**
 *
 * @author GITA
 */
public class progressbar extends JProgressBar {
private static final long suid = 1L;
private javax.swing.Timer timer;
private int persen;
private Color terang = new Color(1F, 1F, 1F, 0.4F);
private Color gelap = new Color(1F, 1F, 1F, 0.4F);
private Color abu_abu = Color.GRAY;
private Color putih = Color.WHITE;

private javax.swing.Timer set_time(){
    if(timer == null){
       timer = new javax.swing.Timer(10,new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                   if(getPersen()>= 100){
                       setPersen(0);
                   }
                   setValue(0);
                   setPersen(getPersen()+1);
                }
            });
    }
    return timer;
}


    public int getPersen() {
        return persen;
    }

    public void setPersen(int persen) {
        this.persen = persen;
        repaint();
    }
    public progressbar(){
        super();
        setPersen(0);
        setOpaque(false);
        setBorderPainted(false);
        super.setIndeterminate(false);

    }

    @Override
    public void setIndeterminate(boolean newValue) {

        if (newValue){
            setPersen(0);
            set_time().start();
        }else {
            if(set_time().isRunning()){
                timer.stop();
                setPersen(0);
                setValue(0);
                super.setIndeterminate(newValue);
            }
        }



    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
     Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        GradientPaint paint = new GradientPaint(0, 0,abu_abu, 0, getHeight(), putih);
        g2.setPaint(paint);
        g2.fillRect(0, 0, getWidth(), getHeight());

        if (getPersen() > 0) {
            paint = new GradientPaint(0, 0, putih, 0, getHeight(), abu_abu);
            g2.setPaint(paint);

            int space = getPersen() * getWidth() / 100;
            int width = getWidth() * 10 / 100;
            Shape s = new Rectangle2D.Double(space, 0, width, getHeight());
            g2.fill(s);
        }

        if (getValue() > 0 && getValue() < getMaximum()) {

            int total = getMaximum() - getMinimum();
            double rate = (getWidth() * 1.0) / (total * 1.0);
            int now = getValue() - getMinimum();

            paint = new GradientPaint(0, 0, putih, 0, getHeight(), abu_abu);
            g2.setPaint(paint);

            Shape s = new Rectangle2D.Double(0, 0, now * rate, getHeight());
            g2.fill(s);
        }


        paint = new GradientPaint(0, 0, terang, 0, getHeight() * 3 / 4, gelap);
        g2.setPaint(paint);
        g2.fillRect(0, 0, getWidth(), getHeight() * 3 / 4);

        g2.setColor(gelap);
        g2.drawRect(0, 0, getWidth(), getHeight());

        g2.dispose();

    }


}
