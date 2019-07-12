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
public class Number {

    private String[] number;
    private int size;

    public Number(String number) {
        this.number = number.split(",");
        this.size = this.number.length;
    }
    
    public Number(String[] number){
        this.number = number;
    }

    public void SelectionSort() {
        String temp = "";
        for (int i = 1; i < size; i++) {
            if (Integer.parseInt(number[i-1]) > Integer.parseInt(number[i])) {
                temp = number[i-1];
                number[i-1] = number[i];
                number[i] = temp;
            }
        }
    }
    
    public void display(){
        for (int i = 0; i < size; i++) {
            System.out.print(number[i]+" ");
        }
        System.out.println();
    }

}
