/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hometastic;

import java.sql.Blob;
import java.sql.SQLException;
import javax.swing.ImageIcon;

/**
 *
 * @author user
 */
class Property {
    
    private int propertyID;
    private String propertyName;
    private String propertyType;
    private String propertyDesc;
    private String street;
    private String city;
    private String state;
    private String hostID;
    private int queenBed;
    private int singleBed;
    private String wifi;
    private String backyard;
    private int maxPerson;
    private String aircond;
    private String parking;
    private String pool;
    private double price;
    private Blob image;
    
    Property(int propertyID, String propertyName, String propertyType, String propertyDesc, 
            String street, String city, String state, String hostID, int queenBed, int singleBed, String wifi, 
            String backyard, int maxPerson, String aircond, String parking, String pool){
        this.propertyID=propertyID;
        this.propertyName=propertyName;
        this.propertyType=propertyType;
        this.propertyDesc=propertyDesc;
        this.street=street;
        this.city=city;
        this.state=state;
        this.hostID=hostID;
        this.queenBed=queenBed;
        this.singleBed=singleBed;
        this.wifi=wifi;
        this.backyard=backyard;
        this.maxPerson=maxPerson;
        this.aircond=aircond;
        this.parking=parking;
        this.pool=pool;
    }
    
    Property(int propertyID,String propertyName, String city, String state, double price, int maxPerson){
        this.propertyID = propertyID;
        this.propertyName = propertyName;
        this.city = city;
        this.state = state;
        this.price = price;
        this.maxPerson = maxPerson;
    }
    
    public void setPropertyID(int propertyID){this.propertyID=propertyID;}
    int getPropertyID(){return propertyID;}
    String getPropertyName(){return propertyName;}
    String getCity(){return city;}
    String getState(){return state;}
    double getPrice(){return price;}
    int getMaxPerson(){return maxPerson;}
    Blob getImage(){return image;}
    
    /*public ImageIcon getImg() {
        byte[] bytes = image.getBytes(1l,(int)image.length());
        return new ImageIcon(bytes);
    }*/
    
}
