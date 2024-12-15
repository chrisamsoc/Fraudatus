package com.mycompany.fraudatus;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



import java.io.File;  // Import the File class
import java.io.FileNotFoundException;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner; 
import java.util.Vector;
import java.util.ArrayList;
/**
 *
 * @author chris
 * 
 * this class shall manage the voting counting
 */

//definition of av class
public class av {
    
    //
   
    
    private String infoPath; //pathway of format file
    private String votePath; //pathway of .csv file
    
    private Map<String, box> candidatesList =new HashMap<>();// define map
    
   
    
    public av(String path)  
    {
        
        this.infoPath = path;
         try {
      File infoCard = new File(infoPath);
      Scanner myReader = new Scanner(infoCard);
      //counter to determine line of file
      int count = 0;
      
      //loops through file
      while (myReader.hasNextLine()) {
        box cand = new box();
        String data = myReader.nextLine();
        //checks if is on pathway file for xlsx file
        if (count == 0)
        {
            //set path to current data
            this.votePath = data;
        }
        //if not line 0, then add data to vector of candidates
        else{
            this.candidatesList.put(data,cand);
        }
        //increment count by 1
        count++;
        
    
      }
      //close reader
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
         
         System.out.println(candidatesList);
         
         
         
  
    }
    
    
    
    public void count()
    {
        //testing out storage of ballots
        
        try{
            File voteSheet = new File("C:\\Users\\chris\\Downloads\\Voting.csv");
            Scanner readLine = new Scanner(voteSheet);
            int count = 0;
            while (readLine.hasNextLine())
            {
                
                String data= readLine.nextLine();
               
               
            
               if (count != 0)
               {
                  String[] values = data.split(",");
                  int ID = Integer.parseInt(values[0]);
                  //accessing 1st choice candidate box and adding ballot to it, element 1 means first choice
                  //then adding the values array to to the hashmap as a ballot entry
                  (candidatesList.get(values[1])).add(values);
                
                  
                  //accessing the first choice of current ballot
                  //done by first specifing which candidate ballot belongs to, then inputing current ID, 
                  //and 0 to represent first element meaning first choice
                  System.out.println((candidatesList.get(values[1])).choice(ID, 0));
               }
               count++;
              }
        }catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
    }
        
     
        
    }
    
    
}
//from data collected in count, create 