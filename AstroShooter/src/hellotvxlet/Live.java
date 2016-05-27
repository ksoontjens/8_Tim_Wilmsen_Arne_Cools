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
public class Live extends Player {

    
    Image heartIMG;
    int aantal;
    
    int posX;
    int posY;
    
    public Live(int x, int y) {
        
        super(x,y);
        
        heartIMG = this.getToolkit().getImage("heart.png");
        
        
        MediaTracker mt = new MediaTracker(this);
        mt.addImage(heartIMG, 1);
       
        try{
            mt.waitForAll();
        }
        catch(InterruptedException ex){
            ex.printStackTrace();
        }
        this.setGraphicContent(heartIMG, HVisible.NORMAL_STATE);
        this.setSize(heartIMG.getWidth(this),heartIMG.getHeight(this));
        
    }
    
    public void update(int tijd) {
        
        
        verplaatsen();
        
        
        
    }
    
    public void verplaatsen() {
        
        switch(aantal){
            case 1: posX = 50;
                break;
            case 2: posX = 100;
                break;
            case 3:posX = 150;
                break;
            case 4:posX = 200;
                break;
            default:
            break;
        }
    }
    
}
