package hellotvxlet;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.tv.xlet.*;
import org.dvb.ui.*;
import org.havi.ui.*;
import org.havi.ui.event.HActionListener;



public class HelloTVXlet implements Xlet, HActionListener {
    
    HScene scene;
    HTextButton button1;
    HTextButton button2;
    HTextButton button3;
    HTextButton button4;
    
    HStaticText winText;
    HStaticText loseText;
    
    HTextButton HulpButton;
  
    public HelloTVXlet() {

    }

    public void initXlet(XletContext context) {
        //Debug
        //System.out.println("initXlet");    
        scene = HSceneFactory.getInstance().getDefaultHScene();
    }

    public void startXlet() {
        //System.out.println("startXlet");  
        
        
        //-----LABEL------
        
        HStaticText label = new HStaticText("Wat is het antwoord?", 100, 300, 500, 50);
            //x,y,breedte, hoogte
        label.setBackgroundMode(HVisible.BACKGROUND_FILL);
        label.setBackground(new DVBColor(0,0,255,255));
        
        winText = new HStaticText("U hebt goed geraden!", 100, 150, 500, 100);
        loseText = new HStaticText("U hebt het fout..", 100, 150, 500, 100);
        
        loseText.setBackgroundMode(HVisible.BACKGROUND_FILL);
        loseText.setBackground(new DVBColor(0, 255, 0, 255));
        winText.setBackgroundMode(HVisible.BACKGROUND_FILL);
        winText.setBackground(new DVBColor(0, 255, 0, 255));
        
        HulpButton = new HTextButton("Hulplijn aanvragen", 520, 0, 200, 50);
        HulpButton.setBackgroundMode(HVisible.BACKGROUND_FILL);
        HulpButton.setBackground(new DVBColor(0, 0, 255, 255));
        
        //------BUTTON-------
        
        button1 = new HTextButton("A: ", 100, 380, 200, 50);
        button2 = new HTextButton("B: ", 100, 450, 200, 50);
        button3 = new HTextButton("C: ", 400, 380, 200, 50);
        button4 = new HTextButton("D: ", 400, 450, 200, 50);
        
        //link de buttons aan de pijltoetsen
        button1.setFocusTraversal(HulpButton, button2, null, button3);
        button2.setFocusTraversal(button1, null, null, button4);
        button3.setFocusTraversal(null, button4, button1, null);
        button4.setFocusTraversal(button3, null, button2, null);
        HulpButton.setFocusTraversal(null, button1, null, null);
        
        button1.setBackgroundMode(HVisible.BACKGROUND_FILL);
        button1.setBackground(new DVBColor(0,0,255,255)); //r,g,b,alpha
        
        button2.setBackgroundMode(HVisible.BACKGROUND_FILL);
        button2.setBackground(new DVBColor(0,0,255,255));
        
        button3.setBackgroundMode(HVisible.BACKGROUND_FILL);
        button3.setBackground(new DVBColor(0,0,255,255));
        
        button4.setBackgroundMode(HVisible.BACKGROUND_FILL);
        button4.setBackground(new DVBColor(0,0,255,255));
        
        //als je op enter klikt
        button1.setActionCommand("button1klik");
        button1.addHActionListener(this);
        
        button2.setActionCommand("button1klik");
        button2.addHActionListener(this);
        
        button3.setActionCommand("button1klik");
        button3.addHActionListener(this);
        
        button4.setActionCommand("button1klik");
        button4.addHActionListener(this);
        
        HulpButton.setActionCommand("buttonHulpklik");
        HulpButton.addHActionListener(this);
        
        //-----SCENE-----
        scene.add(label);
        scene.add(HulpButton);
        scene.add(button1);
        scene.add(button2);
        scene.add(button3);
        scene.add(button4);
        //laat de scene zien
        scene.validate();
        scene.setVisible(true);
        
        //zorgt ervoor dat je tussen buttons kunt navigeren
        button1.requestFocus();
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }

    public void actionPerformed(ActionEvent event) {
        System.out.println(event.getActionCommand());
        
        if (event.getActionCommand().equals("button1klik")) {
            
            scene.add(winText);
            scene.remove(loseText);
            scene.repaint();

        }
        
        /*else if (event.getActionCommand().equals("buttonHulpklik")) {
        
        button4 = null;
        button3 = null;
        scene.repaint();
        return;
        }*/
        
        else {
            
            scene.add(loseText);
            scene.remove(winText);
            scene.repaint();
            
        }
    }
}
