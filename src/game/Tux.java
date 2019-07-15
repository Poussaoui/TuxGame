/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import env3d.Env;
import env3d.EnvObject;
import org.lwjgl.input.Keyboard;

/**
 *
 * @author elmoussm
 */
public class Tux extends EnvObject {

    double step = 0.2;
    public String etat = "models/tux/tux.png";

    public Tux(double x, double y, double z) {
        setX(x);
        setY(y);
        setZ(z);
        setScale(3);
        setTexture(etat);
        setModel("models/tux/tux.obj");
    }
//  22/12  =====>     08/01 

    public void move(int currentKey) {
        switch (currentKey) {
            case Keyboard.KEY_UP:
                if (this.getZ() > getScale() / 2) {
                    this.setZ(this.getZ() - step);
                }
                this.setRotateY(180);
                break;
            case Keyboard.KEY_DOWN:
                if (this.getZ() < 48) {
                    this.setZ(this.getZ() + step);
                }
                this.setRotateY(0);
                break;
            case Keyboard.KEY_LEFT:
                if (this.getX() > getScale() / 2) {
                    this.setX(this.getX() - step);
                }
                this.setRotateY(-90);
                break;
            case Keyboard.KEY_RIGHT:
                if (this.getX() < 38) {
                    this.setX(this.getX() + step);
                }
                this.setRotateY(90);
                break;
        }
    }

    public void tuxHappy(Env env) {
        while (this.getY() < 10) {
            this.setY(this.getY() + 1);
            env.advanceOneFrame();
            this.etat = "models/tux/tux_happy.png";
            this.setTexture(this.etat);
            env.advanceOneFrame();
            env.soundPlay("/home/mrthe/NetBeansProjects/Env3DTemplate/src/sounds/rightOne.wav");
            env.advanceOneFrame();
        }
        while (this.getY() > 3) {
            this.setY(this.getY() - 1);
            this.etat = "models/tux/tux.png";            
            env.advanceOneFrame();
            this.setTexture(this.etat);
            env.advanceOneFrame();
            
        }
    }
    
     public void tuxSad(Env env) {
         /*
            this.setX(this.getX() - step*3);
            env.advanceOneFrame();
            this.setZ(this.getZ() - step*3);
            env.advanceOneFrame();
        */
            this.etat = "models/tux/tux_sad.png";
            this.setTexture(this.etat);
            env.advanceOneFrame();
            env.soundPlay("/home/mrthe/NetBeansProjects/Env3DTemplate/src/sounds/wrong.wav");
            env.advanceOneFrame();
            
            this.etat = "models/tux/tux.png";            
            env.advanceOneFrame();
            this.setTexture(this.etat);
            env.advanceOneFrame();
    }
     
     
     
     
}
