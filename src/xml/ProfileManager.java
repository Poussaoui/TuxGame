/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.Period;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;
import xml.Profile;
//import xml.DemoTuxBinding;

/**
 *
 * @author mushingd
 */
public class ProfileManager {
/**
 *
 * attribut globale
 */
    private Profile profil;
/**
 *
 * Le constructeur devra instancier et intialiser l'attribut de la classe.
 */
    public ProfileManager(String filename) {
        profil = fromXML(filename);
    }
    
/**
 *
 * methode qui réalise le marshalling de l'attribut et l'enregistre dans un fichier XML.
 */
    public void toXML(String filename) {
        try {
            // Fabrication d'un contexte pour notre classe.
            // La classe Profile est simple au sens où elle ne contient que des données (même chose pour le Dictionnaire),
            // toute "l'intelligence" de JAXB se trouve définie ailleurs... 
            // Le contexte contient donc tout le code général nécessaire au 
            // bon fonctionnement du data-binding.
            // Il suffit de fournir le nom du package au contexte pour que toutes les fonctionnalités
            // JAXB soient disponibles pour celui-ci.
            // notez : ici encore on utilise une factory
            // notez aussi qu'on génère ici le contexte à partir de l'instance de classe (p : Profile) à l'aide de getClass().
            // On peut le faire car la classe a été instanciée.
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(profil.getClass().getPackage().getName());
            // ou bien on génère, comme dans le unmarshaller, le contexte à partir de la classe; ça marche aussi bien
            // javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(Profile.class.getPackage().getName());

            // création d'un marshaller pour notre package (note : encore une factory !)
            javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();

            // quelques paramètres pour le support du bon encoding et pour l'affichage simplifié pour les humains
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8"); //NOI18N
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Les 4 lignes ci-dessous sont optionnelles
            // On y indique quel est le schema utilisé : cela permet de créer une instance XML
            // directement validable (contenant l'attribut xsi:instance)            
            SchemaFactory sf = SchemaFactory.newInstance(javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI);
            // note : modifiez la ligne ci-dessous si vous n'avez pas respecté strictement l'énoncé
            Schema schema = sf.newSchema(new File("src/xml/profile.xsd"));
            marshaller.setSchema(schema);
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_SCHEMA_LOCATION, "http://myGame/profile src/xml/profile.xsd");

            // et c'est parti pour l'opération de marshalling (cf cours pour la définition)
            marshaller.marshal(profil, new FileOutputStream(filename));

        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        } catch (java.io.FileNotFoundException e) {
            System.out.println("Probleme d'ouverture fichier " + filename + " en ecriture !");
        } catch (SAXException ex) {
            Logger.getLogger(ProfileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
/**
 *
 * methode qui réalise le unmarshalling d'un Profil. 
 */
    public Profile fromXML(String filename) {
        try {
            // création du contexte à partir de la classe Profile (ici, encore non instanciée, donc on génère le contexte à partir de la classe)
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(Profile.class.getPackage().getName());

            // création d'un unmarshaller 
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();

            // unmarshalling... (utilisation d'un transtypage)
            profil = (Profile) unmarshaller.unmarshal(new java.io.File(filename)); //NOI18N
                /*
             // et voila, ça marche. Ici on affiche le nom et l'age du joueur
             LocalDate today = LocalDate.now();
             XMLGregorianCalendar birthdayCalendar = profile.getBirthday();
             LocalDate birthday = LocalDate.of(birthdayCalendar.getYear(), birthdayCalendar.getMonth(), birthdayCalendar.getDay());
             Period p = Period.between(birthday, today);
             System.out.println("Joueur: " + profile.getName() + " (" + p.getYears() + " ans)");

             // ici, pour tester le unmarshalling, utilisez la methode playerToString() rajoutée à la classe Profile ..........
             // [à faire]
            
            
             // ...
             // ...
             */
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N

        }

        return profil;
    }

    public Profile getProfil() {
        return profil;
    }

    public void setProfil(Profile profil) {
        this.profil = profil;
    }

}
