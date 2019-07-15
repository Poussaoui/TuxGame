/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.tux;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.Document;
import xml.XMLUtil;

/**
 *
 * @author elmoussm
 */
public class Profil {
    

    private String nom;
    private String dateNaissance;
    private String avatar;
    private ArrayList<Partie> parties;
    public Document _doc;

    public Profil(String nom, String dateNaissance) {
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.avatar = null;
    }

    // Cree un DOM à partir d'un fichier XML
    public Profil(String filename) {
        _doc = fromXML(filename);
    }
    
    
    // Cree un DOM à partir d'un fichier XML
    public Document fromXML(String filename) {
        try {
            return XMLUtil.DocumentFactory.fromFile(filename);
        } catch (Exception ex) {
            Logger.getLogger(Profil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    // Sauvegarde un DOM en XML
    public void toXML(String filename) {
        try {
            XMLUtil.DocumentTransform.writeDoc(_doc, filename);
        } catch (Exception ex) {
             Logger.getLogger(Profil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public void ajouterPartie(Partie p) {
        parties.add(p);
    }

    public int getDernierNiveau() {
        return parties.get(parties.size() - 1).getNiveau();
    }

    public String toString() {
        return "Ce profil a fait " + parties.size() + " parties";
    }

    public void sauvegarder(String filename) {
        toXML(filename);
    }

     /// Takes a date in XML format (i.e. ????-??-??) and returns a date
    /// in profile format: dd/mm/yyyy
    public static String xmlDateToProfileDate(String xmlDate) {
        String date;
        // récupérer le jour
        date = xmlDate.substring(xmlDate.lastIndexOf("-") + 1, xmlDate.length());
        date += "/";
        // récupérer le mois
        date += xmlDate.substring(xmlDate.indexOf("-") + 1, xmlDate.lastIndexOf("-"));
        date += "/";
        // récupérer l'année
        date += xmlDate.substring(0, xmlDate.indexOf("-"));

        return date;
    }

    /// Takes a date in profile format: dd/mm/yyyy and returns a date
    /// in XML format (i.e. ????-??-??)
    public static String profileDateToXmlDate(String profileDate) {
        String date;
        // Récupérer l'année
        date = profileDate.substring(profileDate.lastIndexOf("/") + 1, profileDate.length());
        date += "-";
        // Récupérer  le mois
        date += profileDate.substring(profileDate.indexOf("/") + 1, profileDate.lastIndexOf("/"));
        date += "-";
        // Récupérer le jour
        date += profileDate.substring(0, profileDate.indexOf("/"));

        return date;
    }
    

}
