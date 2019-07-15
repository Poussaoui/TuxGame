/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import management.LectureClavier;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.Size;
import de.lessvoid.nifty.builder.EffectBuilder;
import de.lessvoid.nifty.builder.HoverEffectBuilder;
import de.lessvoid.nifty.builder.LayerBuilder;
import de.lessvoid.nifty.builder.PanelBuilder;
import de.lessvoid.nifty.builder.ScreenBuilder;
import de.lessvoid.nifty.builder.TextBuilder;
import de.lessvoid.nifty.controls.listbox.ListBoxItemController;
import de.lessvoid.nifty.input.mapping.MenuInputMapping;
import env3d.Env;
import game.tux.Profil;
import javafx.beans.binding.Bindings;
import management.DevineLeMot;
import management.Dico;
import management.Letter;

/**
 *
 * @author elmoussm
 */
public class Jeu {

    private Env env;
    private Room room;
    private boolean finished;
    private management.Letter lettre;
    boolean isStarted = false;
    private int level;
    private Dico dico;
    DevineLeMot gm;
    String mot_recuper;
    private Profil profil;

    public Jeu() throws InterruptedException {
        // Create the new environment.
        this.isStarted = true;

        // initialisation
        // Instanciate a room 
        room = new Room("textures/floor/paving1.png", "textures/skybox/snow/north.png", "textures/skybox/snow/east.png", "textures/skybox/snow/west.png");
        // Instanciate l'env 
        this.env = new Env();
        initialisation(this.env, room);

        this.level = new LectureClavier().lireEntier("entrez un entier : ");

        dico = new Dico("");
        //dico.addWordToDico(level,"dn");
        //dico.addWordToDico(level,"dm"); 
        mot_recuper = dico.getWordFromListLevel(level);
        System.out.println("Mots level " + level + " :" + mot_recuper);

        gm = new DevineLeMot(mot_recuper, this.env, room);
        
        //initialize
        finished = false;
    }

    public Jeu(String filename) throws InterruptedException {
        // initialise l'attribut profile à l'aide du chemin vers le XML
        profil = new Profil(filename);
        // Create the new environment.
        this.isStarted = true;

        // initialisation
        // Instanciate a room 
        room = new Room("textures/floor/paving1.png", "textures/skybox/snow/north.png", "textures/skybox/snow/east.png", "textures/skybox/snow/west.png");
        // Instanciate l'env 
        this.env = new Env();
        initialisation(this.env, room);

        // initialise niveau au dernier niveau fait dans le profil.
        this.level = profil.getDernierNiveau();

        dico = new Dico("");
        //dico.addWordToDico(level,"dn");
        //dico.addWordToDico(level,"dm"); 
        String mot_recuper = dico.getWordFromListLevel(level);
        System.out.println("Mots level " + level + " :" + mot_recuper);

        gm = new DevineLeMot(mot_recuper, this.env, room);

        //initialize
        finished = false;
    }

    public void initialisation(Env env, Room room) {
        if (this.isStarted) {
            // method as the game loop
           
            // Instanciate a room 
            this.env.setRoom(room);

            // Sets up the camera
            this.env.setCameraXYZ(20, 30, 75);
            this.env.setCameraPitch(-27);

            // Turn off the default controls
            this.env.setDefaultControl(false);

            //env.addObject(tux);
            //env.addObject(lettre);
            System.out.println("Stared env");
            
        } else {
            this.env.restart();
            System.out.println("allready Stared env");
        }

    }
    
    

    public void Jouer() {
        gm.jouer();
    }

    public void setEnv(Env env) {
        this.env = env;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public Env getEnv() {
        return env;
    }

    public boolean isFinished() {
        return finished;
    }

}
