/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Itineraire;
import Entity.Point;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.SAXException;


/**
 *
 * @author florian
 */
public class ServiceItineraireFromFileGPX implements ServiceItineraire{
    /**
     * Fonction permettant de generer un Itineraire a partir
     * d'un fichier xml sous format *.GPX
     * @return 
     */
    @Override
    public Itineraire generateItineraire() {
     
        Scanner saisieUtilisateur = new Scanner(System.in); 
        System.out.println("Veuillez saisir le path :\n"); 
        String path = saisieUtilisateur.next(); 
        Itineraire iti=null;
        try {
            iti=creerIti(path);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ServiceItineraireFromFileGPX.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(ServiceItineraireFromFileGPX.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServiceItineraireFromFileGPX.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        return iti;
    }
    /**
     * Fonction permettant l'affichage de l'Itinéraire dans la sortie général
     * @param iti
     * L'itinéraire a suivre
     * @return une String contenant tous l'Itinéraire à suivre
     */
    private String toString(Itineraire iti){
        ServicePointConsole servicePoint= new ServicePointConsole();
        String result = "";
        for(Point p:iti){
            result+=servicePoint.afficherString(p);
        }
        return result;
    }
    
    /**
     * FOnction servant a retourne l'Itineraire contenus dans fichier PATH sous format .GPX
     * @param path
     *  Le chemin ou se trouve le fichier a recupérer en format gpx
     * @return
     *  L'itinéraire contenu dans le fichier path en .gpx
     * @throws IOException 
    */
  private Itineraire creerIti(String path) throws ParserConfigurationException, SAXException, IOException
{        Itineraire retour=new Itineraire();
         File inputFile = new File(path);
         DocumentBuilderFactory dbFactory  = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         org.w3c.dom.Document doc =  dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();      
         NodeList nList = doc.getElementsByTagName("trkpt");
         for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);     
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
               float lattitude=Float.parseFloat(eElement.getAttribute("lat"));
               float longitude=Float.parseFloat(eElement.getAttribute("lon"));
               float alltitude=Float.parseFloat(eElement.getElementsByTagName("ele").item(0).getTextContent());
               SimpleDateFormat formatageDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                try {
                    Date df=formatageDate.parse(eElement.getElementsByTagName("time").item(0).getTextContent());                   
                    Point p = new Point(lattitude, longitude, df, alltitude);
                    retour.add(p);
                    
                } catch (ParseException ex) {
                    Logger.getLogger(ServiceItineraireFromFileGPX.class.getName()).log(Level.SEVERE, null, ex);
                }
               
              }
         }
         return retour;
   }
}
