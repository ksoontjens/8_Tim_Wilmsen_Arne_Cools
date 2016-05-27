package hellotvxlet;

import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.tv.xlet.*;
import org.davic.resources.ResourceClient;
import org.davic.resources.ResourceProxy;
import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.havi.ui.*;
import org.havi.ui.event.*;


public class HelloTVXlet implements Xlet, ResourceClient, HBackgroundImageListener, UserEventListener  {
    
    HBackgroundDevice _hBackgrDev;
    HBackgroundImage pizza1, pizza2, pizza3, pizza4;
    HStillImageBackgroundConfiguration hsibc;
    int imageteller = 0;
    int cursor = 2;
    HStaticText orderhst;
    String orderstring = "Orderlijst: \n";
    
    
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context) {
      
        HScreen hscreen = HScreen.getDefaultHScreen();
        _hBackgrDev = hscreen.getDefaultHBackgroundDevice();    
        _hBackgrDev.reserveDevice(this);
        
        HBackgroundConfigTemplate cfgTemplate = new HBackgroundConfigTemplate();
        cfgTemplate.setPreference(HBackgroundConfigTemplate.STILL_IMAGE, HBackgroundConfigTemplate.REQUIRED);
        
        _hBackgrDev.getBestConfiguration(cfgTemplate);
        hsibc = (HStillImageBackgroundConfiguration)_hBackgrDev.getBestConfiguration(cfgTemplate);
        
        try {

            if (_hBackgrDev.setBackgroundConfiguration(hsibc)) {

                System.out.println("Reservatie & Configuratie gelukt!!!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        pizza1 = new HBackgroundImage("pizza1.m2v");
        pizza1.load(this);
        pizza2 = new HBackgroundImage("pizza2.m2v");
        pizza2.load(this);
        pizza3 = new HBackgroundImage("pizza3.m2v");
        pizza3.load(this);
        pizza4 = new HBackgroundImage("pizza4.m2v");
        pizza4.load(this);
        
        UserEventRepository rep = new UserEventRepository("naam");
        rep.addAllArrowKeys();
        rep.addKey(HRcEvent.VK_ENTER);
        EventManager e= EventManager.getInstance();
        e.addUserEventListener(this, rep);
        
        HScene scene = HSceneFactory.getInstance().getDefaultHScene();
        orderhst = new HStaticText(orderstring, 300,50,300,400);
        scene.add(orderhst);
        scene.validate();
        scene.setVisible(true);
    }
    
    public void imageLoaded(HBackgroundImageEvent e) {
        imageteller++;
        if(imageteller == 4) 
        {
            System.out.println("Alles is geladen");
            try {
                hsibc.displayImage(pizza3);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void userEventReceived(UserEvent e) {
        if (e.getType()== KeyEvent.KEY_PRESSED) {
            
            if (e.getCode() == HRcEvent.VK_LEFT) {         
                cursor--; if (cursor < 1) cursor = 4;  
            }
            if (e.getCode() == HRcEvent.VK_RIGHT) {               
                cursor++; if (cursor > 4) cursor = 1;   
            }
            if (e.getCode() == HRcEvent.VK_ENTER) {           
                if (cursor == 1) orderstring = orderstring + " Meat Lovers\n";
                if (cursor == 2) orderstring = orderstring + " Pepperoni Lovers \n";
                if (cursor == 3) orderstring = orderstring + " Cheese Lovers \n";
                if (cursor == 4) orderstring = orderstring + " Vegi Lovers \n";
            }
            orderhst.setTextContent(orderstring, HStaticText.NORMAL_STATE);
        }
        
        try {
            if (cursor == 1) hsibc.displayImage(pizza1);
            if (cursor == 2) hsibc.displayImage(pizza2);
            if (cursor == 3) hsibc.displayImage(pizza3);
            if (cursor == 4) hsibc.displayImage(pizza4);
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
    }

    public void startXlet() {
    
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
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

    

    public void imageLoadFailed(HBackgroundImageEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
}
