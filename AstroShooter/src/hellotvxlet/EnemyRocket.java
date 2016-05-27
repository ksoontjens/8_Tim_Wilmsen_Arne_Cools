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
    int xPos;
    int yPos;
    Image rocketImage;
    int destroyTimer;
    
    public EnemyRocket(int x, int y){
        super(x,y);
        rocketImage = this.getToolkit().getImage("enemyRocket.png");
        
        MediaTracker mt= new MediaTracker(this);
        mt.addImage(rocketImage, 1);
       
        try{
            mt.waitForAll();
        }
        catch(InterruptedException ex){
            ex.printStackTrace();
        }
        this.setGraphicContent(rocketImage, HVisible.NORMAL_STATE);
        this.setSize(rocketImage.getWidth(this),rocketImage.getHeight(this));
        xPos=this.getX();
        yPos=this.getY();
    }

    public void update(int tijd) {
        destroyTimer++;
        yPos+=2;
        this.setLocation(xPos,yPos);
        if (destroyTimer>250){
            HelloTVXlet.getScene().remove(this);
            HelloTVXlet.getPublisher().unregister((this));
        }
    }
    
    

}
