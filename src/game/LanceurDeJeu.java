/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;


import env3d.Env;
import management.DevineLeMot;
import management.LectureClavier;

/**
 *
 * @author elmoussm
 */
public class LanceurDeJeu {
    public static void main(String[] args) throws InterruptedException {
        
        boolean rejouer;
        LectureClavier lecturec;
         lecturec = new LectureClavier();
        //Instanciate a new Jeu
        do{
            //Instanciate a new Jeu
            Jeu gm = new Jeu();

            //Play the game
            gm.Jouer();

           System.out.println("voulez vous rejouer ? (o/n)");
           rejouer=lecturec.lireOuiNon();
        }while(rejouer);
        //env.exit();
        
        
       
    }
}
