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
            
            
              
        }catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
    }
        
     
        
    }
    
    //checkMajority method checks to see if candidates has a majority
    public String[] checkMajority()
    {
        //this function shall check for a majority, it will also output at the beggining of the array the candidatges with least votes
        //last element shall contain the winner
        
        this.voteNumbers.clear(); // clears the map before using it again
        //default is n.a meaning not applicatble
        String winner = "n.a";
        //total votes
        int totalVotes = 0;
        //loops through to calculate total votes
        for (String key :candidatesList.keySet())
        {
          int voteNumber = (candidatesList.get(key)).getVotes();
          totalVotes += voteNumber;
          this.voteNumbers.put(key,voteNumber);
        }
        int min = totalVotes; //used to determine which value is the lowest
        ArrayList<String> minName = new ArrayList();
        for (String key :candidatesList.keySet())
        {
          
          int numberVotes = ((candidatesList.get(key)).getVotes());
          //percentage votes is calculated by dividing candidate votes with total votes
          double percentageVotes = numberVotes/(double) totalVotes;
          //check to see if another key equal min 
          if (numberVotes == min){ minName.add(key); }
          //check to see if a new minimum number of votes exists (per candidate)
          if (numberVotes < min){ min = numberVotes; minName.clear(); minName.add(key);}
          
          
          
          //if percentage of  votes is greater or equal to 51%, then winner
          if (percentageVotes >= 0.51){winner = key;}
          
        }
        //adding winner name to list
        minName.add(winner);
        
         // Convert ArrayList to array
        String[] conclusion = minName.toArray(String[]::new);
        return conclusion;
    }
    
    
    public String round()
    {
        //majority varr
       String[] majority = checkMajority();
       int lastElement = majority.length;
       
      
        if((majority[lastElement-1]).equals("n.a"))
        {
            System.out.println("no majority");
            for (int i = 0; i <(lastElement-1);i++)
            {
                //reshuffles the ballots
              reshuffle(majority[i]);
            }
            
        }
        else
        {
            System.out.println(majority[lastElement-1]+" has a majority");
        }
        System.out.println("leasts votes");
        for (int i = 0; i <(lastElement-1);i++)
        {
            System.out.println(majority[i]);
        }
        //returns majority winner/status
       return  majority[lastElement-1];
    }
    
    
    
    public void reshuffle(String oldName)
    {
        //removes first ballots from list
       (candidatesList.get(oldName)).removeFirst();
       //copy previous key values to new box
       
       
       for (int key : (candidatesList.get(oldName)).ballots.keySet())
       {
           //getting newName
           String newName= (candidatesList.get(oldName)).choice(key,0);
          //specifiying new box ||  inputing new key value|||  key (ID), old box ||
           (candidatesList.get(newName)).ballots.put(key,(candidatesList.get(oldName)).ballots.get(key));
       }
       
       //remove all ballots from loser
       (candidatesList.get(oldName)).deleteBallots();
       //removes this candidate from hashMap
       candidatesList.remove(oldName);
    }
    
    public void display()
    {
        //option 1
        for (int key : (candidatesList.get("Option1")).ballots.keySet())
       {
         String aa = (candidatesList.get("Option1")).choice(key,0);
         System.out.println(aa);
       }
        
          //option 2
        for (int key : (candidatesList.get("Option2")).ballots.keySet())
       {
         String aa = (candidatesList.get("Option2")).choice(key,0);
         System.out.println(aa);
       }
        
          //option 4
        for (int key : (candidatesList.get("Option4")).ballots.keySet())
       {
         String aa = (candidatesList.get("Option4")).choice(key,0);
         System.out.println(aa);
       }
        
        
        
    }
    
    
}
