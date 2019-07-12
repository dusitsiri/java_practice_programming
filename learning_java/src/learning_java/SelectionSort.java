/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learning_java;

/**
 *
 * @author onege
 */
public class SelectionSort {

    /**
     * @param args the command line arguments
     */
    public static int[] numberList = {50, -1, 3, 20, 66};

    private int[] arr;

    public SelectionSort(int[] arr) {
        this.arr = arr;
    }

    public void solve() {
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {       //0    1   2   3   4
            for (int j = i + 1; j < arr.length; j++) { //1-4  2-4 3-4 4-4
                if (arr[i] > arr[j]) {
                    temp = arr[i];      //temp = 50
                    arr[i] = arr[j];    //arr[0] = 1
                    arr[j] = temp;      //arr[1] = 50
                }
            }
        }
    }

    public void display() {
        System.out.print(arr[0] + " ");
        System.out.print(arr[1] + " ");
        System.out.print(arr[2] + " ");
        System.out.print(arr[3] + " ");
        System.out.print(arr[4] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort(numberList);
        selectionSort.display();
        selectionSort.solve();
        selectionSort.display();
    }

}
