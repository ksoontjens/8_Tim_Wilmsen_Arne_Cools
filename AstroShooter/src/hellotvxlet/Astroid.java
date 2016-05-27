/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Image;
import java.awt.MediaTracker;
import java.util.Random;
import org.havi.ui.HVisible;

/**
 *
 * @author student
 */
public class Astroid extends Sprite {
    Random r;
    Image mijnimg;
    Image astroid;
    int richting = 1;
    int teller=0;
    int random; 
    int destroyTimer;
    
    public Astroid(int x, int y) {
        
        super(x,y);
        astroid = this.getToolkit().getImage("astro1.png");
        MediaTracker mt= new MediaTracker(this);
        mt.addImage(astroid, 1);
        
        try{
            mt.waitForAll();
        }
        catch(InterruptedException ex){
            ex.printStackTrace();
        }
        
        this.setGraphicContent(astroid, HVisible.NORMAL_STATE);
        this.setSize(astroid.getWidth(this),astroid.getHeight(this));
        r=new Random();
        
        random = r.nextInt(720);
    }
    
    public void update(int tijd) {
        destroyTimer++;
        teller++;
        int x=random;
        int y=this.getY();
        
        y=y+richting*3;
        
        this.setLocation(x,y);
        
        if (destroyTimer>500){
            HelloTVXlet.getScene().remove(this);
            HelloTVXlet.getPublisher().unregister((this));
        }
        
       
    }

}
