/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

/**
 *
 * @author student
 */

import java.util.TimerTask;

public class MijnTimerTask extends TimerTask {
    
    HelloTVXlet xlet;
    
    public MijnTimerTask(HelloTVXlet x) {
        
        xlet = x;
        
    }

    public void run() {
        //System.out.println("Timer ...");
        xlet.callback();
    }

}
