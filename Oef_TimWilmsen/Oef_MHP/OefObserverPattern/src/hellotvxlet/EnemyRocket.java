/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Image;
import java.awt.MediaTracker;
import org.havi.ui.HVisible;

/**
 *
 * @author student
 */
public class EnemyRocket extends Sprite {
    Image mijnimg;
    int richting=1;
    
    public EnemyRocket(int x, int y) {
        
        super(x,y);
        mijnimg = this.getToolkit().getImage("rocket.png");
        MediaTracker mt = new MediaTracker(this);
        mt.addImage(mijnimg, 1);
        
        
        try {

            mt.waitForAll();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
        this.setGraphicContent(mijnimg, HVisible.NORMAL_STATE);
        this.setSize(mijnimg.getWidth(this), mijnimg.getHeight(this));
    }
    
    public void Update(int tijd) {
        int x = this.getX();
        int y = this.getY();
        y++;
        if (y>576) {
            
            HelloTVXlet.scene.remove(this);
            HelloTVXlet.publisher.unregister(this);
            
        }
        this.setLocation(x, y);
    }

}
