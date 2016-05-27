package hellotvxlet;

import java.awt.event.KeyEvent;
import java.util.Timer;
import javax.tv.xlet.*;
import org.havi.ui.*;
import org.havi.ui.event.*;
import org.dvb.event.*;


public class HelloTVXlet implements Xlet, UserEventListener {

    HScene scene;
    MijnComponent mc;
  
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context) {     
        
        scene = HSceneFactory.getInstance().getDefaultHScene();
        mc = new MijnComponent(0,0,720,576);
        
        scene.add(mc);
        scene.validate();
        scene.setVisible(true);
    }

    public void startXlet() {
        EventManager m =EventManager.getInstance();
        
        UserEventRepository rep = new UserEventRepository("naam");
        rep.addAllArrowKeys();
        
        m.addUserEventListener(this, rep);
        
        MijnTimerTask objMijnTimerTask = new MijnTimerTask(this);
        Timer t = new Timer();
        t.scheduleAtFixedRate(objMijnTimerTask, 0, 50);
        
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }

    public void userEventReceived(UserEvent e) {
        if(e.getType() == KeyEvent.KEY_PRESSED) {
            
            switch (e.getCode()) {
                
                case HRcEvent.VK_LEFT:
                    mc.moveLeft();
                    break;
                case HRcEvent.VK_RIGHT:
                    mc.moveRight();
                    break;
                
            }
        } 
    }
    
    public void callback() {
        
        mc.scroll();
        
    }
}
