package hellotvxlet;

import java.awt.event.KeyEvent;
import java.util.Timer;
import javax.tv.xlet.*;
import org.havi.ui.*;
import org.havi.ui.event.*;
import org.dvb.event.*;


public class HelloTVXlet implements Xlet {

    static HScene scene= null;
    static Subject publisher= null;
    
    public HelloTVXlet() {
        
    }
    
    public static HScene getScene() {
        
        return scene; 
        
    }
    
    public static Subject getPublisher() {
        
        return publisher; 
        
    }

    public void initXlet(XletContext context) {
      
        scene = HSceneFactory.getInstance().getDefaultHScene();
        
        Player player = new Player(400,500);
        scene.add(player);
        
        publisher = new Subject();
        Timer tim1 = new Timer();
        tim1.scheduleAtFixedRate(publisher , 0, 10); //elke 10ms
        
        for(int i = 0; i<3; i++) {
            for(int y=0; y<3; y++) {
                Enemy e = new Enemy(i*300,y*100);
                scene.add(e);
                publisher.register(e);
            }
        }
        
        publisher.register(player);
                
        scene.validate();
        scene.setVisible(true);
     
    }

    public void startXlet() {
    
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }
}
