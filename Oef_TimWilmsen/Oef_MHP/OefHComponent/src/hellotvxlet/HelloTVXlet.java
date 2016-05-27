package hellotvxlet;

import javax.tv.xlet.*;
import org.havi.ui.*;
import org.dvb.ui.*;


public class HelloTVXlet implements Xlet {

    HScene scene;
  
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context) {     
        
        scene = HSceneFactory.getInstance().getDefaultHScene();
        MijnComponent mc = new MijnComponent(300,200,200,100);
        MijnComponent mc2 = new MijnComponent(0,0,150,100);
        
        scene.add(mc);
        scene.add(mc2);
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
