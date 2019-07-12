/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SortingNumber;

/**
 *
 * @author onege
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Number number = new Number("50,1,2,7,11,30");
        number.display();
        System.out.println();
        System.out.println("Start Sorting...");
        number.SelectionSort();
        number.display();
    }
    
}
