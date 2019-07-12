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
        int temp = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 1; j < size; j++) {
                
            }
        }
    }

}
