/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import org.dvb.ui.DVBColor;
import org.havi.ui.HComponent;


/**
 *
 * @author student
 */
public class MijnComponent extends HComponent {
   
    Image schipimng;
    Image sterren;
    int x = 100;
    int sy = 0;
    
    public MijnComponent(int x, int y, int w, int h) {
        
        this.setBounds(x,y,w,h);

        schipimng = this.getToolkit().getImage("ship.png");
        sterren = this.getToolkit().getImage("sterren.png");
        //schip zetten in c:/program files/technotrend/tt-mhp-browser/fileio/dsmcc/0.0.3
        MediaTracker mt = new MediaTracker(this);
        mt.addImage(schipimng, 0);
        mt.addImage(sterren, 1);
        
        try {
            mt.waitForAll();
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
    public void moveLeft() {
        
        x-=5; if (x<=0) x=0;
        this.repaint();
        
    }
    
    public void moveRight() {
        
        x+=5; if (x>672) x=672;
        this.repaint();
        
    }
    
    public void scroll() {
        
        sy+=5; if (sy>=570) {sy=0;}
        this.repaint();
        
    }
    
    public void paint(Graphics g)
    {    
        g.drawImage(sterren, 0, sy, null);
        g.drawImage(sterren, 0, sy-570, null);
        g.drawImage(schipimng, x, 500, null);
        
    }

}
