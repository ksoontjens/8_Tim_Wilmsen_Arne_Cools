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
public class Player extends Sprite implements ObserverInterface {
    int xPos;
    int yPos;
    int direction = 2;
    
    int health = 5;
    int score = 0;
    
    int cooldown;
    
    Image spelerIMG;
    public Player(int x, int y)
    {
        super(x,y);
        spelerIMG = this.getToolkit().getImage("player.png");
        
        
        MediaTracker mt = new MediaTracker(this);
        mt.addImage(spelerIMG, 1);
       
        try{
            mt.waitForAll();
        }
        catch(InterruptedException ex){
            ex.printStackTrace();
        }
        this.setGraphicContent(spelerIMG, HVisible.NORMAL_STATE);
        this.setSize(spelerIMG.getWidth(this),spelerIMG.getHeight(this));
        xPos=this.getX();
        yPos=this.getY();
    }
        
        
    
    
    public void update(int tijd) {
        //System.out.println("Health: " + health + " - Score: " + score);
        
        
        if(cooldown > 0){
            cooldown--;
        }
        
        
        this.setLocation(xPos,yPos);
        
        if(direction == 1){
            if(xPos < 670){
                xPos+=2;
            }
            
        }
        else if(direction == 0){
            if(xPos > 0){
                xPos-=2;
            }
        }
        this.setLocation(xPos,yPos);
        score++;
    }
    
    
    void shoot(){
        if (cooldown <= 0){
            Rocket raket1 = new Rocket(xPos+18,yPos+15);
            HelloTVXlet.getScene().add(raket1);
            HelloTVXlet.getPublisher().register(raket1);
            cooldown=21;
        } 
    }

    void moveLeft() {
        direction = 0;
        
        
    }

    void moveRight() {
        direction = 1;
        
        
    }
    
    void stop(){
        direction = 2;
    }
    
    void takeDamage(){
        health--;
    }
    
    void addScore(int scoreAdd){
        score += scoreAdd;
    }

}
