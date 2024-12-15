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
 */
public class av {
    
    //
    private ArrayList<String> votes = new ArrayList();
    
    private String infoPath; //pathway of format file
    private String votePath; //pathway of .csv file
    private Vector<String> candidates = new Vector(); 
    private Map<String, Integer> candidatesList =new HashMap<>();// define map
    
    public HashMap<Integer, vote> ballots = new HashMap();
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
        String data = myReader.nextLine();
        //checks if is on pathway file for xlsx file
        if (count == 0)
        {
            //set path to current data
            this.votePath = data;
        }
        //if not line 0, then add data to vector of candidates
        else{
            this.candidatesList.put(data,0);
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
                  vote bal = new vote(ID);
                  ballots.put(ID,bal);
                  
                  for (int i = 1; i < values.length;i++)
                  {
                     
                      bal.add(values[i]);
                  }
               }
               count++;
              }
        }catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
    }
        
        System.out.println("===============");
        //notice how the ballot hashmap is used to access an object
        System.out.println((ballots.get(3)).access(2));
        
    }
    
    
}
//from data collected in count, create 