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
public class Enemy extends Sprite {
    int xPos;
    int yPos;
    Image enemyImage;
    Random r;
    int random;
    int direction;
    int teller;
    
    public Enemy(int x, int y){
        super(x,y);
        enemyImage = this.getToolkit().getImage("enemy.png");
        
        MediaTracker mt= new MediaTracker(this);
        mt.addImage(enemyImage, 1);
        
       
        try{
            mt.waitForAll();
        }
        catch(InterruptedException ex){
            ex.printStackTrace();
        }
        this.setGraphicContent(enemyImage, HVisible.NORMAL_STATE);
        this.setSize(enemyImage.getWidth(this),enemyImage.getHeight(this));
        xPos=this.getX();
        yPos=this.getY();
        r = new Random();
        teller = r.nextInt(50)+50;
        
        
        
        if(r.nextBoolean()){
            direction = 1;
        }
        else{
            direction = -1;
        }
        
    }

    public void update(int tijd) {
        teller--;
        xPos += direction*3;
        if(xPos > 690){
                direction =-1;
            }
        if(xPos<=0){
            direction = 1;
        }
        
        this.setLocation(xPos,yPos);
        
        
        if (teller <= 0){
            EnemyRocket raket1 = new EnemyRocket(xPos+18,yPos+15);
        HelloTVXlet.getScene().add(raket1);
        HelloTVXlet.getPublisher().register(raket1);
        teller = r.nextInt(50)+60;
        
        }
        
        
    }
    
    

}
