package com.mycompany.fraudatus;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



import java.io.File;  // Import the File class
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner; 
import java.util.Vector;
/**
 *
 * @author chris
 */
public class av {
    
    private String infoPath; private String votePath;
    private Vector<String> candidates = new Vector();
    private Map<String, Integer> candidatesVotes =new HashMap<>();// define map
    public av(String path)
    {
        
        this.infoPath = path;
         try {
      File myObj = new File(infoPath);
      Scanner myReader = new Scanner(myObj);
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
            this.candidatesVotes.put(data,0);
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
         
         System.out.println(candidates);
    }
    
    
    
    public void count()
    {
        File myObj = new File(this.votePath);
                  try {
 
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        System.out.println(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
        
    }
    
    
    
}
