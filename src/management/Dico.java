/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management;

import java.util.ArrayList;

/**
 *
 * @author elmoussm
 */
public class Dico {

    private ArrayList<String> listLevel1;
    private ArrayList<String> listLevel2;
    private ArrayList<String> listLevel3;
    private ArrayList<String> listLevel4;
    private ArrayList<String> listLevel5;
    private String pathToDicoFile;

    public Dico(String pathToDicoFile) {
        this.pathToDicoFile = pathToDicoFile;
        //
        //
                    
        listLevel1 = new ArrayList<String>();
        listLevel1.add("mal");
        listLevel1.add("tri");
        
        listLevel2 = new ArrayList<String>();
        listLevel2.add("parler");
        listLevel2.add("manger");
        
        listLevel3 = new ArrayList<String>();        
        listLevel3.add("descendre");
        listLevel3.add("rabaisser");
        
        listLevel4 = new ArrayList<String>();       
        listLevel4.add("augmentation");
        listLevel4.add("observation");
        
        listLevel5 = new ArrayList<String>();      
        listLevel5.add("passe temps");
        listLevel5.add("porte monnaie");        
        listLevel5.add("tete a tete");
        listLevel5.add("casse tete"); 
        
        
    }

    public String getWordFromListLevel(int level) {
        String word = null;
        int index;
        switch (level) {
            case 1:
                // Que faire lorsque level == 1
                index = (int)(Math.random()*listLevel1.size()-1);
                word = listLevel1.get(index);
                break;
            case 2: 
                // Que faire lorsque level == 2
                index = (int)(Math.random()*listLevel2.size()-1);
                word = listLevel2.get(index);
                break;
            case 3:
                // Que faire lorsque level == 3
                index = (int)(Math.random()*listLevel3.size()-1);
                word = listLevel3.get(index);
                break;
            case 4: 
                // Que faire lorsque level == 4
                index = (int)(Math.random()*listLevel4.size()-1);
                word = listLevel4.get(index);
                break;
            case 5:
                // Que faire lorsque level == 5
                index = (int)(Math.random()*listLevel5.size()-1);
                word = listLevel5.get(index);
                break;
            default:
                break;
        }
        return word;
    }

    public void addWordToDico(int level, String word) {
        switch (level) {
            case 1:
                // Que faire lorsque level == 1
                listLevel1.add(word);
                break;
            case 2: 
                // Que faire lorsque level == 2
                listLevel2.add(word);
                break;
            case 3:
                // Que faire lorsque level == 3                
                listLevel3.add(word);
                break;
            case 4: 
                // Que faire lorsque level == 4
                listLevel4.add(word);
                break;
            case 5:
                // Que faire lorsque level == 5
                listLevel5.add(word);
                break;
            default:
                break;
        }
    }

    public ArrayList<String> getListLivel1() {
        return listLevel1;
    }

    public ArrayList<String> getListLivel2() {
        return listLevel2;
    }

    public ArrayList<String> getListLivel3() {
        return listLevel3;
    }

    public ArrayList<String> getListLivel4() {
        return listLevel4;
    }

    public ArrayList<String> getListLivel5() {
        return listLevel5;
    }

    public String getPathToDicoFile() {
        return pathToDicoFile;
    }

    public void setListLevel1(ArrayList<String> listLevel1) {
        this.listLevel1 = listLevel1;
    }

    public void setListLevel2(ArrayList<String> listLevel2) {
        this.listLevel2 = listLevel2;
    }

    public void setListLevel3(ArrayList<String> listLevel3) {
        this.listLevel3 = listLevel3;
    }

    public void setListLevel4(ArrayList<String> listLevel4) {
        this.listLevel4 = listLevel4;
    }

    public void setListLevel5(ArrayList<String> listLevel5) {
        this.listLevel5 = listLevel5;
    }

    public void setPathToDicoFile(String pathToDicoFile) {
        this.pathToDicoFile = pathToDicoFile;
    }

}
