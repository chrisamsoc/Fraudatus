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
import java.util.ArrayList;
/**
 *
 * @author chris
 * 
 * this class shall manage the voting counting
 */

//definition of av class
public class av {
    
    
   
    
    private String infoPath; //pathway of format file
    private String votePath; //pathway of .csv file
    
    private Map<String, box> candidatesList =new HashMap<>();// definition of hashmap that shall store the box objects of each candidate
    public Map<String,Integer> voteNumbers = new HashMap<>();   
    //constructor
    public av(String path)  
    {
        //infopath shall be set to the path provided in the constructor param
        this.infoPath = path;
        //try loop in event error reading file occurs
         try {
             //define instance of file class called infocard(obj)
      File infoCard = new File(infoPath);
       //define instance of scanner class called myReader(obj)
      Scanner myReader = new Scanner(infoCard);
      //counter to determine line of file
      int count = 0;
      
      //loops through file
      while (myReader.hasNextLine()) {
          //create instance of box class called cand (obj) each iteration of loop
        box cand = new box();
        //data set to current line data from the file
        String data = myReader.nextLine();
        //checks if is on pathway file for csv file
        if (count == 0)
        {
            //set path to current data
            this.votePath = data;
        }
        //if not line 0, then adds candidate to map of candidates, adds cand object as value, candidate name is key
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
         //print out the list, (not neccessary to be removed later)
         System.out.println(candidatesList);
         
         
         
  
    }
    
    
    //definition of count method
    public void count()
    {
       
        
        try{
            //change pathway to whatever user inputs, eventually
            File voteSheet = new File("C:\\Users\\chris\\Downloads\\Voting.csv");
            Scanner readLine = new Scanner(voteSheet);
            //count var is to be used to ensure that file is not being read on line 0
            int count = 0;
            while (readLine.hasNextLine())
            {
                //read data
                String data= readLine.nextLine();
               
               
            //checks if line is not 0
               if (count != 0)
               {
                   //splits data based on commas and sets splits to an array
                  String[] values = data.split(",");
                  //takes values 
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
            //prints out if majority is achieved
          System.out.print(this.checkMajority()+" winner of majority");
            
              
        }catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
    }
        
     
        
    }
    
    //checkMajority method checks to see if candidates has a majority
    public String checkMajority()
    {
        //default is n.a meaning not applicatble
        String winner = "n.a";
        //total votes
        int totalVotes = 0;
        //loops through to calculate total votes
        for (String key :candidatesList.keySet())
        {
          totalVotes += (candidatesList.get(key)).getVotes();
        }
        
        for (String key :candidatesList.keySet())
        {
            //percentage votes is calculated by dividing candidate votes with total votes
          double percentageVotes = ((candidatesList.get(key)).getVotes())/(double) totalVotes;
          //if percentage of  votes is greater or equal to 51%, then winner
          if (percentageVotes >= 0.51)
          {
              return key;
          }
        }
        return winner;
    }
    
}
//from data collected in count, create 