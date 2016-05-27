/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Color;
import org.havi.ui.HStaticIcon;
import org.havi.ui.HVisible;

/**
 *
 * @author student
 */
public abstract class Sprite extends HStaticIcon implements ObserverInterface {

    public Sprite(int x, int y) {
        
        //altijd eerst doen in de constructor
        super();
        
        this.setLocation(x,y);
        //this.setSize(50, 50);
        //this.setBackground(Color.YELLOW);
        //this.setBackgroundMode(HVisible.BACKGROUND_FILL);
    
    }

    public void Update(int tijd) {
        int x = this.getX();
        int y = this.getY();
        x++;
        this.setLocation(x, y);
    }
    
    
}
