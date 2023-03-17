/*
 * Sudoku Solver 
 * Idea and Starting code from "Coding with John"
 * https://www.youtube.com/watch?v=mcXc8Mva2bA
 * Modifications by Tim Norman. 
 */

package sudokuSolver;

public class SudokuSolver {

	private static final int GRID_SIZE = 9;

	public static void main(String[] args) {

		Board board = new Board();

		int[][] puzzle = new int[GRID_SIZE][GRID_SIZE];
		
		board.populateBoard(puzzle);
		System.out.println("This is the starting board");
		board.printBoard(puzzle);
		System.out.println();
		
		if (solveBoard(puzzle)) {
			System.out.println("Solved sucessfully!");
		} else {
			System.out.println("Unsolvable board");
		}
		
		board.printBoard(puzzle);
	}
	
	/**
	 * Checks if a number is already present in the current row. Returns true if so, false otherwise.
	 * @param board The 2D array representing the Sudoku board. 
	 * @param number The number being tested. 
	 * @param row The row being searched. 
	 * @return
	 */
	private static boolean isNumberInRow(int[][] board, int number, int row) {
		for (int i = 0; i < GRID_SIZE; i++) {
			if (board[row][i] == number) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if a number is already present in the current column. Returns true if so, false otherwise. 
	 * @param board The 2D array representing the Sudoku board. 
	 * @param number The number being tested. 
	 * @param column The column being searched. 
	 * @return
	 */
	private static boolean isNumberInColumn(int[][] board, int number, int column) {
		for (int i = 0; i < GRID_SIZE; i++) {
			if (board[i][column] == number) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if a number is already present in the 3x3 sub-square of the board. Returns true if so, false otherwise.
	 * @param board The 2D array representing the Sudoku board. 
	 * @param number The number being tested. 
	 * @param row The row being searched. Limited to the 3x3 sub-square of the board. 
	 * @param column The column being searched. Limited to the 3x3 sub-square of the board. 
	 * @return
	 */
	private static boolean isNumberInBox(int[][] board, int number, int row, int column) {
		int localBoxRow = row - row % 3;
		int localBoxColumn = column - column % 3;
		
		for (int i = localBoxRow; i < localBoxRow + 3; i++) {
			for (int j = localBoxColumn; j < localBoxColumn +  3; j++) {
				if (board[i][j] == number) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Tests that the number being tested is valid in the current position. It must pass the tests checking the row, column, and sub-square. 
	 * @param board The 2D array representing the Sudoku board. 
	 * @param number The number being testetd. 
	 * @param row The row being searched. 
	 * @param column The column being searched. 
	 * @return
	 */
	private static boolean isValidPlacement(int[][] board, int number, int row, int column) {
		return !isNumberInRow(board, number, row) &&
				!isNumberInColumn(board, number, column) &&
				!isNumberInBox(board,number, row, column);
	}
	
	/**
	 * A method to solve the Sudoku board using brute force. It iteratively tries each number (1-9) to determine 
	 * if it is valid, and the first valid candidate is used. This method is then recursively called again to fill 
	 * in the next blank, and so on. If a valid candidate cannot be found the last recursive loop is exited and the 
	 * previous candidate is discarded and the next tried. This recursive process continues until all empty spaces 
	 * have been filled. 
	 * @param board The 2D array representing the Sudoku board. 
	 * @return
	 */
	private static boolean solveBoard(int[][] board) {
		for (int row = 0; row < GRID_SIZE; row++) {
			for (int column = 0; column < GRID_SIZE; column++) {
				if (board[row][column] == 0) {
					for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
						if (isValidPlacement(board, numberToTry, row, column)) {
							board[row][column] = numberToTry;
							
							if (solveBoard(board)) {
								return true;
							} else {
								board[row][column] = 0;
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}
}
