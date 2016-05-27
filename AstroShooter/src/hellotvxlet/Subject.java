/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.TimerTask;
import org.dvb.ui.DVBColor;
import org.havi.ui.HStaticText;
import org.havi.ui.HVisible;

/**
 *
 * @author student
 */
public class Subject extends TimerTask implements SubjectInterface {
    
    ArrayList oblijst = new ArrayList();
    int tijd = 0;
    int coolDown = 0;
    private HStaticText score;
    
    public void run() {
        tijd++;
        if(coolDown > 0){
            coolDown--;
        }
        
        for(int i=0;i<oblijst.size();i++){
            ((ObserverInterface)oblijst.get(i)).update(tijd);
        }
        
        CheckCollisionWithPlayer();
        
    }
    
    
    void CheckCollisionWithPlayer(){
        //System.out.println(oblijst.size());
        Player speler = HelloTVXlet.getPlayer();
        Title gameOver = new Title(250,150,400,400, "Game Over");
        
        score = new HStaticText( Integer.toString(speler.score) ) ;
        score. setLocation(250,200) ;
        score. setSize (200,100) ;
        score. setBackground (new DVBColor(0 ,0 ,0 ,179) ) ;
        score.setBackgroundMode ( HVisible .BACKGROUND_FILL) ;
        
        if(coolDown <= 0){
            
        
            for(int i=0;i<oblijst.size();i++){
                
                if(oblijst.get(i).getClass()==Player.class){
                    Object spritePlayer= oblijst.get(i);
                    for(int j=0;j<oblijst.size();j++){
                        if(oblijst.get(j).getClass()==Astroid.class){
                            Object spriteEnemy=oblijst.get(j);
                            Rectangle r1=((Player)spritePlayer).getBounds();
                            Rectangle r2=((Astroid)spriteEnemy).getBounds();
                            if(r2.intersects(r1)){
                                System.out.println("Hit by astroid!");
                                coolDown = 50;
                                HelloTVXlet.getScene().remove((Astroid)oblijst.get(j));
                                speler.takeDamage();
                                
                                if (speler.health <= 0) {
                                    
                                    
                                    HelloTVXlet.getScene().add(gameOver);
                                    HelloTVXlet.getScene().add(score);
                                    
                                    HelloTVXlet.time.cancel();
                                    
                                }
                            }

                        }
                        else if(oblijst.get(j).getClass()==EnemyRocket.class){
                            Object spriteEnemyRocket=oblijst.get(j);
                            Rectangle r1=((Player)spritePlayer).getBounds();
                            Rectangle r2=((EnemyRocket)spriteEnemyRocket).getBounds();
                            if(r2.intersects(r1)){
                                System.out.println("Hit by enemy rocket!");
                                coolDown = 50;
                                HelloTVXlet.getScene().remove((EnemyRocket)oblijst.get(j));
                                speler.takeDamage();
                                
                            }

                        }
                    }
                }
                
        }
       
        
        
        
        
        
        
    }
        for(int i=0;i<oblijst.size();i++){
        if(oblijst.get(i).getClass()==Rocket.class){
            
                    Object spriteRocket= oblijst.get(i);
                    for(int j=0;j<oblijst.size();j++){
                        if(oblijst.get(j).getClass()==Astroid.class){
                            Object spriteEnemy=oblijst.get(j);
                            Rectangle r1=((Rocket)spriteRocket).getBounds();
                            Rectangle r2=((Astroid)spriteEnemy).getBounds();
                            if(r2.intersects(r1)){
                                System.out.println("Astroid destroyed!");
                                HelloTVXlet.getScene().remove((Astroid)oblijst.get(j));
                                HelloTVXlet.getScene().remove((Rocket)oblijst.get(i));
                                unregister((Astroid)oblijst.get(j));
                                speler.addScore(900);
                            }
                        }
                        else if(oblijst.get(j).getClass()==Enemy.class){
                            Object spriteEnemy=oblijst.get(j);
                            Rectangle r1=((Rocket)spriteRocket).getBounds();
                            Rectangle r2=((Enemy)spriteEnemy).getBounds();
                            if(r2.intersects(r1)){
                                System.out.println("Enemy destroyed!");
                                HelloTVXlet.getScene().remove((Enemy)oblijst.get(j));
                                HelloTVXlet.getScene().remove((Rocket)oblijst.get(i));
                                unregister((Enemy)oblijst.get(j));
                                speler.addScore(500);
                            }
                        }
                    }
            }
        }
    }
    
    
    

    public void register(ObserverInterface ob) {
        oblijst.add(ob);
        
    }

    public void unregister(ObserverInterface ob) {
        oblijst.remove(ob);
    }

}
