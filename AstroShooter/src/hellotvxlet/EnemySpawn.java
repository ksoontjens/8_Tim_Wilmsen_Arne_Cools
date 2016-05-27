/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.util.Random;

/**
 *
 * @author student
 */
public class EnemySpawn implements ObserverInterface {
    
    Random r;
    int teller=0;
    int random;
    static int snelheidAstro = 2;
    float multiplier = 1;
    
    int spawnHeight;
        
    public EnemySpawn() {
        
        r=new Random();
        
        random = r.nextInt(720);     
        
    }

    public void update(int tijd) {
            
            teller += snelheidAstro;
            if(teller%20000 == 0){
                System.out.println("Multiplier x2 active");
                 multiplier =4;
             }
            else if(teller%10000 == 0){
                System.out.println("Multiplier active");
                 multiplier =2;
             }
            
            
         if (teller % (190/multiplier) == 0) {
             
            Astroid raket = new Astroid(random,-100);
            HelloTVXlet.getScene().add(raket);
            HelloTVXlet.getPublisher().register(raket);
        }
            if (teller % 300 == 0) {
                
                
                
                
                
                switch(r.nextInt(4)){
                    case 1: spawnHeight = 50;
                        break;
                    case 2: spawnHeight = 100;
                        break;
                    case 3:spawnHeight = 150;
                        break;
                    case 4:spawnHeight = 200;
                        break;
                    default:
                    break;
                }
                
                
                Enemy vijand = new Enemy(r.nextInt(720),spawnHeight);
                HelloTVXlet.getScene().add(vijand);
            HelloTVXlet.getPublisher().register(vijand);
            }
            
            
    }

}
