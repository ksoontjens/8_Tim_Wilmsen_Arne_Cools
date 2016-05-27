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
    Image mijnimg;
    int richting=1;
    int teller = 0;
    Random r;
    static int aantalEnemies = 0;
    
    
    public Enemy(int x, int y) {
        
        super(x,y);
        mijnimg = this.getToolkit().getImage("ship.png");
        MediaTracker mt = new MediaTracker(this);
        mt.addImage(mijnimg, 1);
        
        
        try {

            mt.waitForAll();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
        this.setGraphicContent(mijnimg, HVisible.NORMAL_STATE);
        this.setSize(mijnimg.getWidth(this), mijnimg.getHeight(this));
        aantalEnemies++;
        r= new Random();
        r.setSeed(aantalEnemies);
    }
    
    public void Update(int tijd) {
        int x = this.getX();
        int y = this.getY();
        x=x+richting*3;
        if (x>=720-mijnimg.getWidth(this)) richting=-1;
        if (x<=0) richting=1;
        this.setLocation(x, y);
        
        
        
        if (r.nextInt(500)==250) {
        
            teller = 0;
            EnemyRocket raket = new EnemyRocket(x,y+20);
            HelloTVXlet.getScene().add(raket);
            HelloTVXlet.getPublisher().register(raket);
            
            
        }
        
    }

}
