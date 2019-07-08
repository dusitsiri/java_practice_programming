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
public class SudokuSolving {

    /**
     * @param args the command line arguments
     */
    public static int[][] GRID_TO_SOLVE = {
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

    public static int[][] GRID_TO_SOLVE_2 = {
        {5, 3, 0, 0, 7, 0, 0, 0, 0},
        {6, 0, 0, 1, 9, 5, 0, 0, 0},
        {0, 9, 8, 0, 0, 0, 0, 6, 0},
        {8, 0, 0, 0, 6, 0, 0, 0, 3},
        {4, 0, 0, 8, 0, 3, 0, 0, 1},
        {7, 0, 0, 0, 2, 0, 0, 0, 6},
        {0, 6, 0, 0, 0, 0, 2, 8, 0},
        {0, 0, 0, 4, 1, 9, 0, 0, 5},
        {0, 0, 0, 0, 8, 0, 0, 7, 9}
    };

    public static int[][] GRID_TO_SOLVE_3  = {
        {5, 3, 0, 0, 7, 0, 0, 0, 0},
        {6, 0, 0, 1, 9, 5, 0, 0, 0},
        {0, 9, 8, 0, 0, 0, 0, 6, 0},
        {8, 0, 0, 0, 6, 0, 0, 0, 3},
        {4, 0, 0, 8, 0, 3, 0, 0, 1},
        {7, 0, 0, 0, 2, 0, 0, 0, 6},
        {0, 6, 0, 0, 0, 0, 2, 8, 0},
        {0, 0, 0, 4, 1, 9, 0, 0, 5},
        {0, 0, 0, 0, 8, 0, 0, 7, 9}
    };

    private int board[][];
    public static final int EMPTY = 0;
    public static final int SIZE = 9;

    public SudokuSolving(int[][] board) {
        this.board = new int[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                this.board[i][j] = board[i][j];
            }
        }
    }

    public boolean isInRow(int row, int num) {
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == num) {
                return true;
            }
        }
        return false;
    }

    public boolean isInColumn(int col, int num) {
        for (int i = 0; i < SIZE; i++) {
            if (board[i][col] == num) {
                return true;
            }
        }
        return false;
    }

    public boolean isInBox(int row, int col, int num) {
        int r = row - row % 3; //8-8%3 = 8-2 = 6 , 5-5%3 = 5-2 = 3
        int c = col - col % 3; //1-1%3 = 1-1 = 0 , 

        for (int i = r; i < r + 3; i++) { //( i = 6 ; 6 < 9 ; 6++)
            for (int j = c; j < c + 3; j++) { //(j = 0 ; j < 3 ; 
                if (board[i][j] == num) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isOk(int row, int col, int num) {
        return !isInRow(row, num) && !isInColumn(col, num) && !isInBox(row, col, num);
    }

    public boolean solve() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                //find 0 value in table
                if (board[row][col] == EMPTY) {
                    //prepare insert number
                    for (int number = 1; number <= SIZE; number++) {
                        //if number possible to put in position
                        if (isOk(row, col, number)) {
                            //add number into table
                            board[row][col] = number;
                            //start backtracking 
                            if (solve()) {
                                return true;
                            } else {
                                board[row][col] = EMPTY;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public void display() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j]);
                if (j == 2 || j == 5) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i == 2 || i == 5) {
                System.out.print("--- --- ---");
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        SudokuSolving sudokuSolving = new SudokuSolving(GRID_TO_SOLVE_2);
        sudokuSolving.display();
        System.out.println();

        if (sudokuSolving.solve()) {
            System.out.println("Sudoku solved");
            sudokuSolving.display();
        } else {
            System.out.println("Sodoku unsolved");
        }
    }
}
