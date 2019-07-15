/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import management.Dico;

/**
 *
 * @author elmoussm
 */
public class TestDico {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Dico dico = new Dico("");
        
        dico.addWordToDico(5,"fdfhfghghf");
        dico.addWordToDico(5,"grrgrgr");
        dico.addWordToDico(5,"regrgrg");
        dico.addWordToDico(5,"vrvrg");
        dico.addWordToDico(5,"bfbbfbfbf");
        
        System.out.println("Mot l5 :" + dico.getWordFromListLevel(5));   
    }
    
}
