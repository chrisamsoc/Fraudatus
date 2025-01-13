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
 import java.util.ArrayList;
import java.util.Set;
public class flightNet {
    
    

    private HashMap<String,City> cities;
    public int teer;
    
    public flightNet()
    {
        cities = new HashMap();
        
    }
    
    
    public void addCity(String cName, int t)
    {
        //org part
        System.out.println(cName);
        cities.putIfAbsent(cName, new City(cName));
        
        //new part
        this.teer = t;
        
    }
    
    
    
    public void addFlight(String depName, String arrName,int cost)
    {
        System.out.printf("%s to %s | cost : %d\n",depName,arrName,cost);
        cities.get(depName).add(arrName,cost);
        
    }
    
    
    
    public City getCity(String cName)
    {
        return cities.get(cName);
    }
    
    public ArrayList<String> getCities()
    {
        Set<String> keys2 = cities.keySet(); 
        ArrayList<String> keys = new ArrayList(keys2);
        return keys;
    }
    
    
    
}
