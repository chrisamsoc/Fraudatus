/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.econosky;

/**
 *
 * @author chris
 */

import java.util.*;
public class EconoSky {

    public static void main(String[] args) {
        
    
         flightNet manage = new flightNet();
        
        // Add cities to the network
        manage.addCity("YYZ",2);
        manage.addCity("YUL",3);
        manage.addCity("YVR",3);
        manage.addCity("STC",4);
        manage.addCity("SFO",1);
        manage.addCity("JFK",1);
        manage.addCity("MIA",4);
       
        
        // Add flights between cities (costs)
        manage.addFlight("YYZ","YVR",200);
        manage.addFlight("YYZ","MIA",100);
        manage.addFlight("YUL","YYZ",2);
        manage.addFlight("YUL","JFK",10000);
        manage.addFlight("YVR","STC",10);
        manage.addFlight("STC","SFO",1);
        manage.addFlight("SFO","JFK",300);
        manage.addFlight("MIA","JFK", 5000);

        
        algo lah = new algo(manage,"YUL","JFK");
         // Find the shortest path from New York to San Francisco
        List<String> shortestPath = lah.execute();
        
        // Print the shortest path
        System.out.println("Shortest path from New York to San Francisco:");
        for (String city : shortestPath) {
            System.out.print(city + " ");
        }
        
        System.out.println("");
        price loh = new price(2);
        System.out.println(loh.determine(5,3));
        
        
        
    }
}
