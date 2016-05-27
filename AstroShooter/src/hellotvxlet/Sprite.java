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
public abstract class Sprite extends HStaticIcon implements ObserverInterface{
    public Sprite(int x,int y){
        super();
        this.setLocation(x, y);
        this.setSize(50, 50);
    }


}
