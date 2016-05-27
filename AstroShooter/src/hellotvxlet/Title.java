/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Graphics;
import org.dvb.ui.DVBColor;

/**
 *
 * @author student
 */
public class Title extends UI {
    
    private String title;

    
    public Title(int x, int y, int w, int h, String titleText) {
        
        super(x,y,w,h);
        title = titleText;
    }
    
    public void paint(Graphics g)
    {

        g.setColor(new DVBColor(255,255,0,255)); 
        g.drawString(title, 40, 50);
    }

}
