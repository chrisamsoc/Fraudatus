/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.fraudatus;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;
import java.util.Scanner; 




/**
 *
 * @author cristian
 */

//main program class
public class Fraudatus {
//main method
    public static void main(String[] args) {
        //defining new scanner
       Scanner read = new Scanner(System.in);
       //telling users of project name and choices
       System.out.println("Welcome to Project \"Fraudatus\"");
       System.out.print("1 For vote counting, 2 for general format of info file:");
       //taking input and setting to choice
       int choice = read.nextInt();
       read.nextLine();
       //if chocie is 1 , meaning to count votes call home method
       if (choice == 1){ home();}
       //if 2 then go to format method
       else if (choice ==2){format();}
        
    }
    
    //home method creates instance of av (alternative voting) class which manages the voting
    public static void home()
    {
        //new scanner
        Scanner read = new Scanner(System.in);
        //asks for infopath to properly count votes (infofile has pathway to csv file and list of candidates)
        System.out.println("Please input infopath:");
        String infopath = read.nextLine();
        System.out.println(infopath);
        //defines new instance of av class as cnt (is an object)
        av cnt = new av(infopath);
        //first round
        //calling count method within cnt object (of class av)
        cnt.count();
        //calling round method to conduct a round of voting
        cnt.round(); //2nd round
        //display new votes
        cnt.display();
        System.out.println("/////////////////////");
        cnt.round(); //2nd round
        //display new votes
        cnt.display();
        
        
        
        
      
        
    }
    
    
    //outputs format style for info file
    public static void format()
    {
        System.out.println("Format is as follows\n======================");
        System.out.print("Pathway\nCandidate Names");
        
    }
    
}



