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
public class Fraudatus {

    public static void main(String[] args) {
       Scanner read = new Scanner(System.in);
       System.out.println("Welcome to Project \"Fraudatus\"");
       System.out.print("1 For vote counting, 2 for general format of info file:");
       int choice = read.nextInt();
       read.nextLine();
       if (choice == 1){ home();}
       else if (choice ==2){format();}
        
    }
    
    public static void home()
    {
        Scanner read = new Scanner(System.in);
        System.out.println("Please input infopath:");
        String infopath = read.nextLine();
        
        av COUNT = new av(infopath);
    }
    
    
    //outputs format style for info file
    public static void format()
    {
        System.out.println("Format is as follows\n======================");
        System.out.print("Pathway\nCandidate Names");
        
    }
    public static String[] exert(String[] candidates,String pathway)
    {
        String[] a = {};
          try {
      File myObj = new File(pathway);
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
        return a;
    }
}



