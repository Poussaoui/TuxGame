/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import env3d.EnvObject;
import org.lwjgl.input.Keyboard;

/**
 *
 * @author mushingd
 */
public class Tux extends EnvObject {
    int step = 1;
    
    public Tux(double x, double y, double z) {
        setX(x);
        setY(y);
        setZ(z);
        setScale(1);
        setTexture("models/tux/tux.png");
        setModel("models/tux/tux.obj");
    }

    public void move(int currentKey) {
        if (currentKey == Keyboard.KEY_DOWN) {
            this.setRotateY(180);
            this.setZ(this.getZ() - step);
        }
    }
}
