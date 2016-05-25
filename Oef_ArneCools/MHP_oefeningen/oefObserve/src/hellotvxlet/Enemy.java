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
    Random r;
    Image mijnimg;
    int richting = 1;
    int teller=0;
    static int aantalEnemies=0;
    public Enemy(int x, int y){
        super(x,y);
        mijnimg= this.getToolkit().getImage("ship.png");
        MediaTracker mt= new MediaTracker(this);
        mt.addImage(mijnimg, 1);
        
        try{
            mt.waitForAll();
        }
        catch(InterruptedException ex){
            ex.printStackTrace();
        }
        
        this.setGraphicContent(mijnimg, HVisible.NORMAL_STATE);
        this.setSize(mijnimg.getWidth(this),mijnimg.getHeight(this));
        aantalEnemies++; //klasse variable
        r=new Random();
        r.setSeed(aantalEnemies);
        
        
    }
    
        public void update(int tijd) {
        int x=this.getX();
        int y=this.getY();
        x=x+richting*3;
        if(x>=720-mijnimg.getWidth(this)) richting=-1;
        if(x<=0)richting=1;
        if(y>200){
            y -= 1;
        }
        if(y<200){
             y+=1;
        }
        this.setLocation(x,y);
        
        
        //teller++;
        if (r.nextInt(500)==250) // nieuwe racket
        {
            teller=0;
            EnemyRocket raket = new EnemyRocket(x+20,y+50);
            HelloTVXlet.getScene().add(raket);
            HelloTVXlet.getPublisher().register(raket);
                    
        }
        
    }
}
