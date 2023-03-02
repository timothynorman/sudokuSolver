package sudokuSolver;

import java.util.Scanner;

public class Board {
	
	private static final int GRID_SIZE = 9;
	Scanner keyboard = new Scanner(System.in);
	
	public Board() {
	}

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
