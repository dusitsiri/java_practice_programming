/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BMICalculator;

import java.util.Scanner;

/**
 *
 * @author onege
 */
public class BMICalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner( System.in );
        double height, weight, bmi;
        
        System.out.print("Please enter your height(cm): ");
        height = scan.nextDouble() / 100;
        System.out.print("Please enter your weight(kg): ");
        weight = scan.nextDouble();
        
        bmi = weight / (height * height);
        
        System.out.println();
        System.out.printf(" Your BMI is %.2f\n", bmi );
    }
    
}
