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
public class Player extends Sprite {
    Random r;
    Image mijnimg;
    int richting = 1;
    int teller=0;
    static int aantalEnemies=0;
    public Player(int x, int y){
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
       
        
    }
}

