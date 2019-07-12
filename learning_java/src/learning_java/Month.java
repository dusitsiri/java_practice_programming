/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learning_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author onege
 */
public class Month {

    public static void main(String[] args) {
        String[] month = {
            "January", "February", "March",
            "April", "May", "June", 
            "July", "August", "September",
            "October", "November", "December"};
        
        String input;
        int index;
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(ir);
        System.out.print("Enter month number(1-12 only): ");
        try{
            input = in.readLine();
            index = Integer.parseInt(input);
            if (index < 1 || index > 12) {
                System.out.println("Month number error.");
            } else{
                System.out.println(index+" = "+month[index-1]);
            }
        } catch (IOException e){
            System.err.println("Try again.");
        }

    }
}
