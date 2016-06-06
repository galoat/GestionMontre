/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Service.ServiceItineraireFromFileGPX;

/**
 *
 * @author florian
 */
//CHEMIN C:\Users\florian\Downloads\406328c77fef80554d25.gpx
public class Main {
   public static void main (String[] args){
       Service.ServiceItineraireFromFileGPX gp=new ServiceItineraireFromFileGPX();
       gp.generateItineraire();
               
   }

}
