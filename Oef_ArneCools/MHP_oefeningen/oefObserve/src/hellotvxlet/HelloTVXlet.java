package hellotvxlet;


import java.util.Timer;
import javax.tv.xlet.*;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;


public class HelloTVXlet implements Xlet {
    static HScene scene; //dit hoort bij de klasse en niet bij het object
    static Subject publisher;
    
    public static HScene getScene(){
        return scene;
    }
    
    public static Subject getPublisher(){
        return publisher;
        
    }

    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {
        scene = HSceneFactory.getInstance().getDefaultHScene();
        
        Player player = new Player(400,500);
        scene.add(player);
        Enemy s1=new Enemy(100,100);
        EnemyRocket s2=new EnemyRocket(100,200);
        scene.add(s1);
        scene.add(s2);
        publisher = new Subject();
        Timer tim1 = new Timer();
        tim1.scheduleAtFixedRate(publisher,0,10); //elke 10 ms
        
      
            for(int x=0;x<5;x++)
                for(int y=0;y<3;y++){
                    Enemy e= new Enemy(x*100,y*100);
                    scene.add(e);
                    publisher.register(e);
                }
                
            
        
        publisher.register(player);

        
        
        scene.validate();
        scene.setVisible(true);
    }

    public void pauseXlet() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void startXlet() throws XletStateChangeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
