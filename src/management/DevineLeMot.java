/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.builder.LayerBuilder;
import de.lessvoid.nifty.builder.PanelBuilder;
import de.lessvoid.nifty.builder.ScreenBuilder;
import de.lessvoid.nifty.builder.TextBuilder;
import env3d.Env;
import game.Room;
import game.Tux;
import java.util.ArrayList;
import org.lwjgl.input.Keyboard;

/**
 *
 * @author elmoussm
 */
public class DevineLeMot {

    Env env;
    Tux tux;
    ArrayList<Letter> letters;
    int nbreLettreRestantes;
    int temps;
    Chronometre chrono;
    Letter e;
    private boolean finished;
    Nifty nifty;

    public DevineLeMot(String mot, Env env, Room room) {
        //env
        this.env = env;

        //tux
        tux = new Tux(25, 3, 20);

        //lettres
        letters = new ArrayList<Letter>();

        //Chronometre
        this.temps = 40;
        chrono = new Chronometre(this.temps);

        //nbreLettreRestantes
        nbreLettreRestantes = mot.length();

//        env.setRoom(room);
        //lettre
        for (int i = 0; i < mot.length(); i++) {
            e = new Letter(mot.charAt(i), (int) (Math.random() * (room.getWidth())-1), (int) (Math.random() * (room.getHeight()))-1);
            System.out.println("lettre :" + mot.charAt(i));
            letters.add(e);
            this.env.addObject(e);
            env.addObject(e);

        }
        afficherMot(mot);
        jouer();
    }

    public void checkUserKey() {
        tux.move(this.env.getKeyDown());
    }

    private boolean tuxMeetsLetter() {
        return collision(tux, letters.get(0));
    }

    private boolean tuxMeetsWrongLetter() {
        boolean isClosed = false;
        for(int i = 1;i<letters.size();i++){
            isClosed = distance(tux, letters.get(i)) < 3 ? true : false;
            //System.out.println("isClosed : " + isClosed);
        }
        return isClosed;
    }
    
    private double distance(Tux tux, Letter letter) {
        return tux.distance(letter);
    }

    private boolean collision(Tux tux, Letter letter) {
        return distance(tux, letter) < 3 ? true : false;
    }

    private int getNbLettresRestantes() {
        return letters.size();
    }

    public int getTemps() {
        return chrono.getSeconds();
    }

    public void jouer() {
        // Insert Tux
        this.env.addObject(tux);
        boolean finished = false;
        
        // Start chrono
        chrono.start();
        // The main game loop
        do {
            // Ask for user input, check if it collides and remove letters if necessary
            checkUserKey();
            // Update display
            this.env.advanceOneFrame();
            //System.out.println("Temps restant ;" + getTemps());
            if (tuxMeetsLetter()) {
                //System.out.println("en collision ? :" + tuxMeetsLetter());
                
                this.env.removeObject(letters.get(0));
                letters.remove(0);
                
                tux.tuxHappy(env);
            }
            // Update display
            this.env.advanceOneFrame();
            
            if(tuxMeetsWrongLetter()){
                System.out.println("Wrong Word");
                tux.tuxSad(env);
            }

            // Update display
            this.env.advanceOneFrame();

            
        } while (!finished&&letters.size()>0&&chrono.remainsTime()); //  les 3 condition 
        //Post-Process: game is finished
        //we have to keep the data to save our score (chrono, temps, nbLettresRestantes)
        
        chrono.stop();
        System.out.println("Nombre de lettres restantes:"+letters.size());
        System.out.println("Temps restant:"+chrono.getSeconds()+" seconds");
        this.env.exit();
    }
    
    
    public void afficherMot(final String mot) {
       
            nifty = env.getNiftyGUI();

            // We build a screen using the *Builder classes.  
            new ScreenBuilder("Hello") {
               // We are defining the screen 
                {
                    // Each screen has one or more layers
                    layer(new LayerBuilder() {
                        {
                            // Layout the child elements in the middle
                            childLayoutCenter();
                            // Each layer can have one or more panel
                            panel(new PanelBuilder() {
                                {
                                    // We simply have an empty panel with a 
                                    // translucent background
                                    alignCenter();
                                    valignCenter();
                                    childLayoutCenter();
                                    marginTop("-210");
                                    marginLeft("0");
                                    width(percentage(100));
                                    height(percentage(15));
                                    
                                    text(new TextBuilder("fps") {
                                        {
                                            text("Mot a trouver : "+mot);
                                            alignCenter();
                                            valignCenter();

                                            height("600px");
                                            width("100%");
                                            color("#000");
                                            font("aurulent-sans-16.fnt");

                                        }
                                    });
                                    // color is expressed using the RGBA notation
                                    backgroundColor("#ffffff88");
                                }
                            });
                        }
                    });
                }
                // Build this screen and let the nifty object manage it
            }.build(nifty);

            // Activate the screen
            nifty.gotoScreen("Hello");
            
            //nifty.removeScreen("Hello");
    }
    
    public void desparMot(Nifty nifty) {
        for (int i = 0; i < 200; i++) {                    
                if(i == 190){
                   nifty.removeScreen("Hello");
                }
            }
    }
}
