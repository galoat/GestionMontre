/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Point;

/**
 *
 * @author florian
 */
public class ServicePointConsole {
    public String afficherString(Point p){
        return "\n lattitude "+p.getLatitude()+" longitude "+p.getLongitude()+" alltitute "+p.getAlltitude()+" Date "+p.getTemp();
        
    }
}
