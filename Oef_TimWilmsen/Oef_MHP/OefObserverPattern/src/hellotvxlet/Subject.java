/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.TimerTask;
import org.havi.ui.HStaticText;

/**
 *
 * @author student
 */
public class Subject extends TimerTask implements SubjectInterface {
    
    ArrayList oblijst = new ArrayList();
    
    int tijd = 0;
    public void run() {
        tijd++;
        for(int i=0; i<oblijst.size();i++) {
            
            ((ObserverInterface)oblijst.get(i)).Update(tijd);
            
        }
        
        doCollisionDetection();
       
    }
    public void doCollisionDetection() {
        
        for (int i=0;i<oblijst.size();i++) {
            
            Object sprite=oblijst.get(i);
            if (sprite.getClass() == Player.class) {
                
                for (int j=0;j<oblijst.size();j++) {
                    
                    Object sprite2 = oblijst.get(j);
                    if(sprite2.getClass() == EnemyRocket.class) {
                        
                        Rectangle r2 = ((EnemyRocket)sprite2).getBounds();
                        Rectangle r1 = ((Player)sprite).getBounds();
                        if (r2.intersects(r1)) {
                            
                            HelloTVXlet.getScene().add(new HStaticText("GAME OVER!!!"));
                            
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
