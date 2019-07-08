/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokusolving;

/**
 *
 * @author onege
 */
public class Sudoku1 {
    public static int [][] GRID_SOLVE = {
        {8, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 3, 6, 0, 0, 0, 0, 0},
        {0, 7, 0, 0, 9, 0, 2, 0, 0},
        {0, 5, 0, 0, 0, 7, 0, 0, 0},
        {0, 0, 0, 0, 4, 5, 7, 0, 0},
        {0, 0, 0, 1, 0, 0, 0, 3, 0},
        {0, 0, 1, 0, 0, 0, 0, 6, 8},
        {0, 0, 8, 5, 0, 0, 0, 1, 0},
        {0, 9, 0, 0, 0, 0, 4, 0, 0}
    };
    
    private int[][] board;
    private static final int EMPTY = 0;
    private static final int SIZE = 9;
        
    public Sudoku1 (int [][] board){
        this.board = new int[SIZE][SIZE];
        
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                this.board[i][j] = board[i][j];
            }
        }
    }
    
    public boolean isInRow(int row, int number){
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == number) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isInColumn(int col, int number){
        for (int i = 0; i < SIZE; i++) {
            if(board[i][col] == number){
                return true;
            }
        }
        return false;
    }
    
    public boolean isInBox(int row, int col, int number){
        int r = row - row % 3;
        int c = col - col % 3;
        
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (board[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean isOk(int row, int col, int number){
        return !isInRow(row, number) && !isInColumn(col, number) && !isInBox(row, col, number);
    }
    
    public boolean solve(){
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == EMPTY) {
                    for (int number = 1; number <= SIZE; number++) {
                        if (isOk(row, col, number)) {
                            board[row][col] = number;
                            
                            if (solve()) {
                                return true;
                            } else {
                                return false;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    public void display(){
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                System.out.print(board[row][col]);
                if (col == 2 || col == 5) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if(row == 2 || row == 5){
                System.out.println("--- --- ---");
            }
        }
    }
    
    public static void main(String[] args) {
        Sudoku1 sudoku1 = new Sudoku1(GRID_SOLVE);
        sudoku1.display();
        
        if (sudoku1.solve()) {
            System.out.println("Sudoku Solved");
            sudoku1.display();
        } else {
            System.out.println("Sudoku Unsolved");
        }
    }
}
