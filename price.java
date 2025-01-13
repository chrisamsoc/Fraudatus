/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.econosky;

/**
 *
 * @author chris
 */

import java.util.*;
import java.time.*;

public class price {
    
    private int bookingClass;
    private int baseCost;
    public price(int bookingClass)
    {
        
    
        //if between 7-9
    if(bookingClass/3 >2 )
    {
        
    }
    //if between 4-6
    else if (bookingClass/3 >1 & bookingClass/3 <2 ){
     
     
    }
    //if between 1-3
    else if (bookingClass/3 >0 & bookingClass/3 <1)
    {
        
    }
    
    }
    //month when booked, month at departure, day in month of booking, day in month of departure, depature tier, arrival tier
    
    public double determine(int bookMonth,int depMonth,int bookDay, int depDay, int tierDep, int tierArr)
    {
        //determine the default price between the cities first
        
        //use increments by decimals to determine how much more it costs based off of pure starting price of 400
        double increments =2.02;
        for (int i = 1; i <=tierDep; i++)
        {
            increments -= 0.085;
            System.out.println(i);
          
        }
        
       
        for (int i = 1; i <=tierArr; i++)
        {
            increments -= 0.085;
            System.out.println(i);
          
        }
        
        double costStuff= increments*400;
        System.out.println(increments);
        
        
        //now we calculate the values for the sine function
        //number of days in month
        
        //create class instance for month of departure
        YearMonth yearMonth =  YearMonth.of(2025,depMonth);
        double period = yearMonth.lengthOfMonth();
        
        double cVal = (2*(Math.PI))/period;
        
        
        
        
        
        return costStuff;
    }
    
    
}
