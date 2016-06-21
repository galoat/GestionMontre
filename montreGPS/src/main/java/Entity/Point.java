/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author florian
 */
public class Point {
    private float latitude;
    private float longitude;
    private Date temp;
    private float alltitude;

    public Point(float latitude, float longitude, Date temp, float alltitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.temp = temp;
        this.alltitude = alltitude;
    }
    
    
    
 //GETHER AND SETHER
    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public Date getTemp() {
        return temp;
    }

    public void setTemp(Date temp) {
        this.temp = temp;
    }

    public float getAlltitude() {
        return alltitude;
    }

    public void setAlltitude(float alltitude) {
        this.alltitude = alltitude;
    }
 
}
