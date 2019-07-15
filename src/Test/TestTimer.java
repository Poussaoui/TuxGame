/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.util.logging.Level;
import java.util.logging.Logger;
import management.Chronometre;

/**
 *
 * @author elmoussm
 */
public class TestTimer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Chronometre timer = new Chronometre(6);
        timer.start();
        try {
            Thread.sleep(5900);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestTimer.class.getName()).log(Level.SEVERE, null, ex);
        }
        timer.stop();
        System.out.println("getHours : " + timer.getHours());
        System.out.println("getMilliseconds : " + timer.getMilliseconds());
        System.out.println("getMinutes : " + timer.getMinutes());
        System.out.println("getSeconds : " + timer.getSeconds());
        System.out.println("getTime : " + timer.getTime());
        System.out.println("----------------------------");
        System.out.println("getHours : " + timer.getHours());
        System.out.println("getMilliseconds : " + timer.getMilliseconds());
        System.out.println("getMinutes : " + timer.getMinutes());
        System.out.println("getSeconds : " + timer.getSeconds());
        System.out.println("getTime : " + timer.getTime());
        System.out.println("remainsTime : " + timer.remainsTime());
        
    }
    
}
