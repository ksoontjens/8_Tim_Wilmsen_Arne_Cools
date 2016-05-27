package hellotvxlet;


import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Timer;
import javax.tv.xlet.*;
import org.bluray.ui.event.HRcEvent;
import org.davic.resources.ResourceClient;
import org.davic.resources.ResourceProxy;
import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.dvb.ui.DVBColor;
import org.havi.ui.HBackgroundConfigTemplate;
import org.havi.ui.HBackgroundDevice;
import org.havi.ui.HBackgroundImage;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HScreen;
import org.havi.ui.HStillImageBackgroundConfiguration;
import org.havi.ui.HTextButton;
import org.havi.ui.HVisible;
import org.havi.ui.event.HActionListener;
import org.havi.ui.event.HBackgroundImageEvent;
import org.havi.ui.event.HBackgroundImageListener;


public class HelloTVXlet implements Xlet, UserEventListener, HActionListener, ResourceClient, HBackgroundImageListener {
    static HScene scene;
    static Player speler;
    static Live hearts;
    static Subject publisher;
    private Title titel;
    static Timer time;
    private HTextButton knopStart, knopExit;
    
    private HScreen screen;
    private HBackgroundDevice bgDev;
    private HStillImageBackgroundConfiguration bgConfig;
    private HBackgroundImage bgSterren;
  
    public HelloTVXlet() {
        
    }
    
    public static HScene getScene(){
        return scene;
    }
    
    public static Subject getPublisher(){
        return publisher;
    }
    
    public static Player getPlayer(){
        return speler;
    }
    
    public static Live getLives(){
        return hearts;
    }

    public void initXlet(XletContext context) {
        
        screen=HScreen.getDefaultHScreen();
        bgDev=screen.getDefaultHBackgroundDevice();
        bgDev.reserveDevice(this);
        HBackgroundConfigTemplate bgConfigTemplate =new HBackgroundConfigTemplate();
        bgConfigTemplate.setPreference(HBackgroundConfigTemplate.STILL_IMAGE, 
                HBackgroundConfigTemplate.REQUIRED);
        try {
            bgConfig=(HStillImageBackgroundConfiguration)bgDev.getBestConfiguration(bgConfigTemplate);
            bgDev.setBackgroundConfiguration(bgConfig);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
      
        scene = HSceneFactory.getInstance().getDefaultHScene();
        
        titel = new Title(250,70,200,200, "Astro Shooter");
        
        scene.add(titel);

        knopStart = new HTextButton ( "Start" );
        knopStart.setLocation(250,200);
        knopStart.setSize (200,80);
        knopStart.setBackground (new DVBColor(0 ,0 ,0 ,179) );
        knopStart.setBackgroundMode ( HVisible .BACKGROUND_FILL);

        knopExit = new HTextButton ( "Exit" );
        knopExit.setLocation(250,300);
        knopExit.setSize (200,80);
        knopExit.setBackground (new DVBColor(0 ,0 ,0 ,179) );
        knopExit.setBackgroundMode ( HVisible .BACKGROUND_FILL);
        
        knopStart.setFocusTraversal ( null , knopExit, null , null );
        knopExit.setFocusTraversal (knopStart, null , null , null );
        
        scene.add(knopStart);
        scene.add(knopExit);

        knopStart.requestFocus ( ) ;
        
        knopStart.setActionCommand( "knopStart_actioned" );
        knopExit.setActionCommand( "knopExit_actioned" );
        
        knopStart.addHActionListener ( this ) ;
        knopExit.addHActionListener ( this ) ;
        
        time = new Timer();

        scene.validate();
        scene.setVisible(true);
    }
    

    
    public void userEventReceived(UserEvent e) {
        
        if(e.getType() == KeyEvent.KEY_PRESSED) {
            switch (e.getCode()) {
                
                case HRcEvent.VK_LEFT:
                    speler.moveLeft();
                    break;
                case HRcEvent.VK_RIGHT:
                    speler.moveRight();
                    break;
                
            }
            if(e.getCode() ==  HRcEvent.VK_SPACE){
                
                speler.shoot();
            }
        } 
        else if(e.getType() == KeyEvent.KEY_RELEASED){
            switch (e.getCode()) {
                
                case HRcEvent.VK_LEFT:
                    speler.stop();
                    
                    break;
                case HRcEvent.VK_RIGHT:
                    speler.stop();
                    break;
                
            }
        }
    }
    
    
    public void startXlet() {
        EventManager m =EventManager.getInstance();
        
        UserEventRepository rep = new UserEventRepository("naam");
        rep.addAllArrowKeys();
        rep.addKey(32);
        
        m.addUserEventListener(this, rep);
        
        bgSterren=new HBackgroundImage("sterren.png");
        bgSterren.load(this);
    
    }

    public void pauseXlet() {
        
        speler = new Player(400,500);
        EnemySpawn spawner= new EnemySpawn();
        scene.add(speler);
        publisher = new Subject();
        hearts = new Live(30,30);
        scene.add(hearts);
        
        publisher.register(speler);
        publisher.register(spawner);
        publisher.register(hearts);
        
        time.scheduleAtFixedRate(publisher,0,10);
        
    }

    public void destroyXlet(boolean unconditional) {
        
    }

    void callback() {
        throw new UnsupportedOperationException("Not yet implemented(callback)");
    }

    public void actionPerformed(ActionEvent evt) {
        
        String action = evt.getActionCommand();
        
        if (action == "knopStart_actioned") {
            
            HelloTVXlet.getScene().removeAll();
        
            pauseXlet();
        }
        
        else if (action == "knopExit_actioned") {
            
            destroyXlet(true);
        }
        
        
    }

    public boolean requestRelease(ResourceProxy proxy, Object requestData) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void release(ResourceProxy proxy) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void notifyRelease(ResourceProxy proxy) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void imageLoaded(HBackgroundImageEvent e) {
        try {
            bgConfig.displayImage(bgSterren);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void imageLoadFailed(HBackgroundImageEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
