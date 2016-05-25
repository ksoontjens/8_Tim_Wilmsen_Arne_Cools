/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.TimerTask;

/**
 *
 * @author student
 */
public class Subject extends TimerTask implements SubjectInterface {
    
    ArrayList oblijst = new ArrayList();
    int tijd = 0;

    public void run() {
        tijd++;
        for(int i=0;i<oblijst.size();i++){
            ((ObserverInterface)oblijst.get(i)).update(tijd);
        }
        doCollisionDetectionPlayer();
        
    }
    
    
    public void doCollisionDetectionPlayer(){
        for(int i=0;i<oblijst.size();i++){
            Object sprite= oblijst.get(i);
            if(oblijst.get(i).getClass()==Player.class){
                for(int j=0;j<oblijst.size();j++){
                    Object sprite2=oblijst.get(j);
                    if(oblijst.get(j).getClass()==EnemyRocket.class){
                        Rectangle r2=((EnemyRocket)sprite2).getBounds();
                        Rectangle r1=((Player)sprite).getBounds();
                        if(r2.intersects(r1)){
                            System.out.println("game OVer");
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
