/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import org.w3c.dom.Document;
import org.w3c.dom.*;
import xml.ProfileManager;
import xml.Profile;
import xml.XMLUtil;
import xml.XMLUtil.DocumentFactory;

/**
 *
 * @author elmoussm
 */
public class TestProfileManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //  initialise 
        ProfileManager pManager = new ProfileManager("src/xml/profile.xml");
        //
        pManager.toXML("src/xml/profile2.xml");
        System.out.println("name : " + pManager.getProfil().getName());
        //
        Document doc = XMLUtil.DocumentFactory.fromObject(pManager.getProfil());
        //  les info de fichier
        //Affiche la version de XML
        System.out.println(XMLUtil.DocumentFactory.fromObject(pManager.getProfil()).getXmlVersion());
        //Affiche l'encodage
        System.out.println(XMLUtil.DocumentFactory.fromObject(pManager.getProfil()).getXmlEncoding());
        //Affiche s'il s'agit d'un document standalone		
        System.out.println(XMLUtil.DocumentFactory.fromObject(pManager.getProfil()).getXmlStandalone());

        //*************************
        /*
         * récupération de l'Element racine
         */
        Element racine = doc.getDocumentElement();
        System.out.println(doc.getDocumentElement());
        //Affichage de l'élément racine
        System.out.println("\n*************RACINE************");
        System.out.println(racine.getNodeName());

        /*
         * récupération des profiles
         */
        NodeList racineNoeuds = racine.getChildNodes();

        if (racineNoeuds.item(0).getNodeType() == Node.ELEMENT_NODE) {
            Element profile = (Element) racineNoeuds.item(0);

            /*
             * récupération du name et du préname
             */
            Element name = (Element) profile.getElementsByTagName("name").item(1);
            Element birthday = (Element) profile.getElementsByTagName("birthday").item(0);

            //Affichage du name et du birthday
            System.out.println("name : " + name.getTextContent());
            System.out.println("birthday : " + birthday.getTextContent());

        }

        //****************************
    }

}
