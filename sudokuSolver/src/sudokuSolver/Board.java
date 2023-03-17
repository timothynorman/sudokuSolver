package sudokuSolver;

import java.util.Scanner;

/**
 * A class to prompt the user for input, converts that string into characters and builds a 
 * Sudoku board from that. 
 * @author tim
 *
 */
public class Board {
	
	/**
	 * The length of the rows, columns, and sub-squares (3x3)
	 */
	private static final int GRID_SIZE = 9;
	Scanner keyboard = new Scanner(System.in);
	
	/**
	 * No arg constructor. 
	 */
	public Board() {
	}

	/**
	 * Prompts user to enter a Sudoku puzzle row-by-row, and then converts each string to an 
	 * array of characters to populate the board. 
	 * @param board The Sudoku puzzle board. 
	 */
	public void populateBoard(int[][] board) {
		System.out.println("Enter each line of the Sudoku problem one line at a time.");
		System.out.println("Do not use spaces or separators, and use 0 for blank squares.");
		
		for (int i = 0; i < GRID_SIZE; i++) {
			System.out.printf("Enter Row %d: ", i+1);
			String row = keyboard.nextLine();
			
			for (int j = 0; j < GRID_SIZE; j++) {
				board[i][j] = row.charAt(j)-48;
			}
		}
	}


	/**
	 * Method to display the board. Blank spaces are shown as 0. 
	 * @param board The Sudoku puzzle board. 
	 */
	public  void printBoard(int[][] board) {
		for (int row = 0; row < GRID_SIZE; row++) {
			if (row % 3 == 0 && row != 0) {
				System.out.println("-----------");
			}
			for (int column = 0; column < GRID_SIZE; column++) {
				if (column % 3 == 0 && column != 0) {
					System.out.print("|");
				}
				System.out.print(board[row][column]);
			}
			System.out.println( );
		}
	}

}
