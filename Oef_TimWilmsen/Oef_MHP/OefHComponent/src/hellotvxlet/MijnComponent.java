/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Graphics;
import org.dvb.ui.DVBColor;
import org.havi.ui.HComponent;


/**
 *
 * @author student
 */
public class MijnComponent extends HComponent {
    
    private int br, ho;
    
    public MijnComponent(int x, int y, int w, int h) {
        
        this.setBounds(x,y,w,h);
        
        br = w;
        ho = h;
        
    }
    public void paint(Graphics g)
    {    
        g.setColor(new DVBColor(0,0,63,179));
        g.fillRoundRect(10, 10, br-10, ho-10, 15, 15);
        g.setColor(new DVBColor(0,0,179,179));
        g.fillRoundRect(0, 0, br-10, ho-10, 15, 15);
        g.setColor(new DVBColor(255,255,0,255)); 
        g.drawString("MijnComponent", 50, 50);
        
    }

}
