/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.tux;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author elmoussm
 */
class Partie {

    private String date;
    private String mot;
    private int niveau;
    private int trouve;
    private int temps;

    /*
    1er constructeurs a trois paramètres permet de construire une nouvelle partie et initialise
    tous les attributs . 
     */
    public Partie(String date, String mot, int level) {
        this.mot = mot;
        this.niveau = level;
        this.date = date;
        this.trouve = 0;
        this.temps = 0;
    }

    /*
    2eme constructeur permit de construir et la réinitialisation
    Ce constructeur devra donc à l'aide du doc en paramètre et d'un parsing DOM retrouver les bonnes valeurs
    et les réinitialiser dans les attributs.
    */
    public Partie(Element partieElt) {
        try {
//            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder p = dbFactory.newDocumentBuilder();
//        
//            Document doc = p.parse("../xml/gametux.xml");

            this.date = partieElt.getAttributes().getNamedItem("date").getTextContent();
            this.niveau = Integer.parseInt(partieElt.getAttributes().getNamedItem("date").getTextContent());

            //this.niveau=Integer.parseInt(partieElt.getAttribute("date").getTextContent());
            this.mot = partieElt.getElementsByTagName("word").item(0).getAttributes().getNamedItem("date").getTextContent();

            //System.out.println(doc.getElementsByTagName("game").item(0).getAttributes().item(0));
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /*
    getPartie(doc:Document):Element la méthode crée le bloc XML représentant une partie à partir 
    du paramètre doc pour créer les éléments du XML et renvoie ce bloc en tant que Element.
     */
    public Element getPartie(Document doc) {
        Element retour = null;
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder p = dbFactory.newDocumentBuilder();

            doc = p.parse("../xml/gametux.xml");

            retour = (Element) doc.getElementsByTagName("game").item(0);

        } catch (Exception e) {

        }
        return retour;
    }

    /*
    La méthode setTrouve(nbrLettreRestantes):int qui permet de renvoyer un pourcentage 
    en fonction du nombre de lettres trouvées.
    */
    public void setTrouve(int nbLettresRestantes) {
        // Calcul pourcentage de lettre trouvees
        this.trouve = ((this.mot.length() - nbLettresRestantes) * 100) / this.mot.length();
    }

    // pour la grestyion des parties
    public void setTemps(int temps) {
        this.temps = temps;
    }
    // pour la grestyion des parties
    public int getNiveau() {
        return this.niveau;
    }
    // pour la grestyion des parties
    public String toString() {
        return "A la date : " + date + " le mot " + mot + " dans le niveau " + niveau + " possede " + trouve + " % de lettres trouvees au bout de " + temps;
    }
}
