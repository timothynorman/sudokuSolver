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
	
	





	private static boolean isNumberInRow(int[][] board, int number, int row) {
		for (int i = 0; i < GRID_SIZE; i++) {
			if (board[row][i] == number) {
				return true;
			}
		}
		return false;
	}

	private static boolean isNumberInColumn(int[][] board, int number, int column) {
		for (int i = 0; i < GRID_SIZE; i++) {
			if (board[i][column] == number) {
				return true;
			}
		}
		return false;
	}

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
	
	private static boolean isValidPlacement(int[][] board, int number, int row, int column) {
		return !isNumberInRow(board, number, row) &&
				!isNumberInColumn(board, number, column) &&
				!isNumberInBox(board,number, row, column);
	}
	
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
