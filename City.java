/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.econosky;

/**
 *
 * @author chris
 */

import java.util.HashMap; 


public class City {
    HashMap<String, Integer> neighbor;
    String name; 
    
    //cName meaning original Name
    public City(String oName)
    {
        //setting input name from param to name 
        this.name = oName;
        this.neighbor = new HashMap();
        
        //new
    }
    
    
    //adds key value pair to hashmap
    //cName meaning city Name
    public void add(String cname, int cost)
    {
        //inputs pair into neighbor hashmap
        neighbor.put(cname,cost);
        
        
    }
    
    //gets cost from speific cityName
    public int getCost(String cname)
    {
        return neighbor.get(cname);
    }
    
    
    
    // Returns the map of neighbors (city name to cost)
    public HashMap<String, Integer> getNeighbor() {
        return neighbor;
    }

    // Getter for the city name
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
