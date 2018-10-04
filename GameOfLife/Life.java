
public class Life {

	private final int ROWS = 24;
	private final int COLUMNS = 80;
	private final int GENERATIONS = 500;
	private boolean[][] board = new boolean[ROWS][COLUMNS]; // holds current generation
	private boolean[][] temp = new boolean[ROWS][COLUMNS]; // holds next generation
	private boolean[][] swap; // a reference we will use to swap board and temp

	public Life() {
	}

	/**
	 * Use this method to iterate through your generations. 
	 * Intended to be called from main, 
	 * for example:
	 * 		Life game = new Life();
	 * 		game.play();
	 * 
	 * To help make the console appear animated, 
	 * use this at the end of each generation's loop:
	 * 
	 * try {
	 * 	Thread.sleep(100);
	 * } catch (InterruptedException e) {
	 * // handle exception here
	 * }
	 */
	public void play() {
		this.initializeBoard();
		for (int generation = 0; generation < GENERATIONS; generation++) {
			determineFate();
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				// handle exception here
//			}
		}
	}

	/**
	 * Use this method to initialize your board field.
	 * The board instance stores the state of the current generation
	 * of cells, represented as boolean values (true for alive, false for dead)
	 */
	void initializeBoard() {
		for (int row = 0; row < ROWS; row++) {
			for (int column = 0; column < COLUMNS; column++) {
//				create board and make 10% of cells alive
//				you may wish to play with this number to 
//				see how the patterns in the simulation are affected.
				board[row][column] = (Math.random() > 0.9);
			}
		}
	}

	/**
	 * Implementation should print your current generation
	 * of cells to the console.
	 * 		Alive cells are represented by "*" characters
	 * 		Dead cells are represented by a space (" ")
	 * 
	 * Note: To simulate animation in the console, print
	 * 100 blank lines.
	 */
	void printBoard() {

		for (int row = 0; row < ROWS; row++) {
			for (int column = 0; column < COLUMNS; column++) {
				if (board[row][column]) { // cell is alive (true)
					System.out.print("*");
				} else { // cell is dead (false)
					System.out.print(" ");
				}
			}
			System.out.println();
		}

	}

	/**
	 * Use this method to determine the fate of a single cell,
	 * by conditionally checking the 4 rules of the Game of Life.
	 * Call the getNumAliveNeighbors method to help.
	 * 
	 * Update the board variable appropriately.
	 * 
	 */
	void determineFate() {
		for (int row = 0; row < ROWS; row++) {
			for (int column = 0; column < COLUMNS; column++) {
				int total = getNumAliveNeighbors(row, column);
				if (board[row][column]) {
					// If the cell is living and has exactly 2 or 3 living neighbors,
					// it will continue to be living.
					temp[row][column] = (total == 2 || total == 3);
				} else {
					// If a cell is dead, it will come to life only if it has exactly 3 living
					// neighbors.
					temp[row][column] = (total == 3);
				}
			}

			// After we have stored the state of each cell in the next generation
			// into temp, we swap board and temp, using the swap variable.

			// We could have thrown out the old array stored in board instead of swapping it
			// with temp,
			// but then we would have to create a new array for temp each time, which is
			// less efficient.
			swap = board;
			board = temp;
			temp = swap;
			printBoard();
		}
	}

	/**
	 * A helper method to determine the number of alive 
	 * cells surrounding the board cell referenced
	 * by the row and column values passed 
	 * @param row The row index of the cell to check
	 * @param column The column index of the cell to check
	 * @return the number of alive cells surrounding the referenced cell.
	 */
	int getNumAliveNeighbors(int row, int column) {

		int total = 0;// tracks the number of alive neighbors

		// Starts one row before the current row and finishes one row after the current
		// row.
		// Does the same for columns

		// Math.max() and Math.min() keep us within the array's bounds
		// When backing up a row or a column, the Math.max() methods
		// make sure that we do not generate an index smaller than 0.

		// When going forward a row or a column, the Math.min() methods
		// make sure that we do not generate an index greater than
		// ROWS - 1 or COLUMNS - 1
		for (int i = Math.max(row - 1, 0); i < Math.min(row + 2, ROWS); i++) {
			for (int j = Math.max(column - 1, 0); j < Math.min(column + 2, COLUMNS); j++) {
				if ((i != row || j != column) && board[i][j]) {
					total++; // an alive neighbor was found
				}
			}
		}

		return total;
	}
}
