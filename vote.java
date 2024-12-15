/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fraudatus;

import java.util.Map;
import java.util.ArrayList;
import java.util.Vector;
/**
 *
 * @author chris
 */
public class vote {
    
   
    private ArrayList<String> rec = new ArrayList();
    private int ID;
    
    
    
    public vote(int ID)
    {
        
        this.ID = ID;
        
        
    }
    
    
  
    
    public void change(int element,String Candidate)
    {
        rec.set(element,Candidate);
        
        
    }
    
    public void remove(int element)
    {
        rec.remove(element);
    }
    
    public void add(String Candidate)
    {
        rec.add(Candidate);
    }
    
    public String access(int element)
    {
        return rec.get(element);
    }
    
    
}
