/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import env3d.Env;

/**
 *
 * @author elmoussm
 */
public class Jeu {

    private Env env;
    private boolean finished;
    private Tux tux;
    
    public Jeu(){
        // Create the new environment.  Must be done in the same
        // method as the game loop
        env = new Env();
        //tux
        tux = new Tux(25,1,20);
        
        // Instanciate a room 
        Room room;
        room = new Room("textures/floor/paving3.png", "textures/floor/paving2.png", "textures/floor/paving3.png", "textures/floor/paving3.png");
        env.setRoom(room);
        // Sets up the camera
        env.setCameraXYZ(20, 30, 75);
        env.setCameraPitch(-30);
        // Turn off the default controls
        env.setDefaultControl(false);
        
        
        env.addObject(tux);

        //initialize
        finished = false;
    }

    public void Jouer() {
        // The main game loop
        finished = false;
        while (!finished) {
            //1 is for escape key
            if (env.getKey() == 1) {
                finished = true;
            }
            // Update display
            env.advanceOneFrame();
        }
        // Just a little clean up
        env.exit();
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
