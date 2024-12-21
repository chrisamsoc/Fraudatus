/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fraudatus;


import java.util.HashMap;


/**
 *
 * @author chris
 * 
 * class for containers that manage votes for a candidate
 */
public class box {
    //defines the ballots hashmap that shall contain the ballots for the candidate
    public HashMap<Integer, vote> ballots = new HashMap();
    //records how many primary place votes the candidate has, currently
    private int currentVotes;
//no need to have anything in the constructor, check if possible to delete later    
    public box()
    {
        currentVotes = 0;
    }
    // add a ballot, takes in array of split vals from av class
    public void add(String[] data)
    {
        
        //sets ID to first element of array, converts from string to int
        int ID = Integer.parseInt(data[0]);
        //creates new instance of vote class and calls the object bal
        vote bal = new vote(ID);
        //creates a new key value pair in the ballots map, has ID as key, and bal obj as value
        ballots.put(ID,bal);
                  
        
        //repeats through array of data
        for (int i = 1; i < data.length;i++)
        {
                     //adds candidates to the array
          bal.add(data[i]);
        }
        //increments current votes by 1
         currentVotes++; 
        

    }
    
    //pulls a candidate using ID and element 
    public String choice(int ID,int element)
    {
      String candidate = (ballots.get(ID)).access(element);
      
        
     return candidate;   
    }
    
    //method to return current votes 
    public int getVotes()
    {
        return currentVotes;
    }
    
    
    
}
