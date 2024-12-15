/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fraudatus;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author chris
 */
public class box {
    
    public HashMap<Integer, vote> ballots = new HashMap();
    
    public box()
    {
        
    }
    
    public void add(String[] data)
    {
        
        
        int ID = Integer.parseInt(data[0]);
        vote bal = new vote(ID);
        ballots.put(ID,bal);
                  
        for (int i = 1; i < data.length;i++)
        {
                     
          bal.add(data[i]);
        }
               
        

    }
    
    public String choice(int ID,int element)
    {
      String candidate = (ballots.get(ID)).access(element);
      
        
     return candidate;   
    }
    
    
    
}
