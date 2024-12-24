/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fraudatus;


import java.util.ArrayList;

/**
 *
 * @author chris
 * 
 * this class is for the individual ballot
 */
public class vote {
    
   //defines rec list to contain mutable array of order of candidates selected
    private ArrayList<String> rec = new ArrayList();
    //id var to identity ballot
    private int ID;
    
    
    //constructor
    public vote(int ID)
    {
        
        this.ID = ID;
        
        
    }
    
    
  
    //change an element within the list
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
    
    public int getSize()
    {
        return rec.size();
    }
    
    
}
