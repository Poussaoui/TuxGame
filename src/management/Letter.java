/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management;

import env3d.EnvObject;

/**
 *
 * @author elmoussm
 */
public class Letter extends EnvObject {
    private char letter;

    public Letter(char letter, double x, double z) {
        this.letter = letter;
        
        if(letter == ' '){
            setX(x);
            setZ(z);
            setY(2.5);
            setScale(2);
            setTexture("models/cube/cube.png");
            setModel("models/cube/cube.obj");
        }else
            {
            setX(x);
            setZ(z);
            setY(2.5);
            setScale(2);
            setTexture("models/letter/"+this.letter+".png");
            setModel("models/letter/cube.obj");
        }
            
        
    }

    public char getLetter() {
        return letter;
    }
    
    
}
