import java.util.Scanner;

public class TicTacToe {
	private int dimension; // Grid dimensions
	private char grid[][];
	private char turn;
	private GameStatus gameState;
	private int plays; // Used to detect full grid for draw

	public TicTacToe(char initialTurn) {
		this(3, initialTurn);
	}

	public TicTacToe(int dimension, char initialTurn) {
		if (dimension < 0) {
			throw new IllegalArgumentException("Grid must be a positive size");
		}
		this.dimension = dimension;
		this.grid = new char[dimension][dimension];
		reset(initialTurn);
	}

	public void reset(char initialTurn) {
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				this.grid[i][j] = ' ';
			}
		}
		this.turn = initialTurn;
		this.plays = 0;
		this.gameState = GameStatus.IN_PROGRESS;
	}

	public GameStatus takeTurn(int row, int column) {
		if (this.gameState != GameStatus.IN_PROGRESS) {
			throw new IllegalArgumentException("Game Over");
		}
		if (row < 0 || row > this.dimension || column < 0 || column > this.dimension) {
			throw new IllegalArgumentException("Grid is " + this.dimension + " by " + this.dimension);
		}
		if (this.grid[row][column] != ' ') {
			throw new IllegalArgumentException("This location is already taken");
		}
		this.grid[row][column] = this.turn;
		this.plays++;
		this.turn = (this.turn == 'X') ? 'O' : 'X'; // change turn
		this.gameState = findWinner();
		return this.gameState;
	}

	private GameStatus findWinner() {
		if (plays == dimension * dimension) {
			return GameStatus.DRAW;
		}
		GameStatus newGameState;
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				if (grid[i][j] != ' ') {
					newGameState = findWinnerFrom(i, j);
					if (newGameState != GameStatus.IN_PROGRESS) {
						return newGameState;
					}
				}
			}

		}
		return GameStatus.IN_PROGRESS;
	}

	private GameStatus charToEnum(char player) {
		if (player == 'X') {
			return GameStatus.X_WON;
		} else {
			return GameStatus.O_WON;
		}
	}

	private GameStatus findWinnerFrom(int row, int column) {

		// Look horizontally - left than right

		int count;

		count = 1;
		for (int c = column - 1; c > 0; c--) {
			if (this.grid[row][column] == this.grid[row][c]) {
				count++;
				if (count == dimension) {
					return charToEnum(grid[row][column]);
				}
			} // else, look in another direction
		}

		count = 1;
		for (int c = column + 1; c < dimension; c++) {
			if (this.grid[row][column] == this.grid[row][c]) {
				count++;
				if (count == dimension) {
					return charToEnum(grid[row][column]);
				}
			} // else, look in another direction
		}

		// Look vertically - up then down
		count = 1;
		for (int r = row - 1; r > 0; r--) {
			if (this.grid[r][column] == this.grid[row][column]) {
				count++;
				if (count == dimension) {
					return charToEnum(grid[row][column]);
				}
			} // else, look in another direction
		}

		count = 1;
		for (int r = row + 1; r < dimension; r++) {
			if (this.grid[row][column] == this.grid[r][column]) {
				count++;
				if (count == dimension) {
					return charToEnum(grid[row][column]);
				}
			} // else, look in another direction
		}

		//Look diagonally - Left-down 
		
		count = 1;
		for (int r = row + 1, c = column + 1; r < dimension && c < dimension; r++, c++) {
			if (this.grid[row][column] == this.grid[r][c]) {
				count++;
				if (count == dimension) {
					return charToEnum(grid[row][column]);
				}
			} // else, look in another direction
		}

		// Look diagonally - Right-down
		
		count = 1;
		for (int r = row + 1, c = column - 1; r < dimension && c >= 0; r++, c--) {
			if (this.grid[row][column] == this.grid[r][c]) {
				count++;
				if (count == dimension) {
					return charToEnum(grid[row][column]);
				}
			} // else, look in another direction
		}

		return GameStatus.IN_PROGRESS;
	}

	public int getTurn() {
		return this.turn;
	}

	public GameStatus getGameState() {
		return this.gameState;
	}

	public String toString() {
		String s = "";
		for (int r = 0; r < dimension; r++) {
			for (int c = 0; c < dimension; c++) {
				s += grid[r][c] + " | ";
			}
			s += "\n";
		}
		return s;
	}

	public static void main(String args[]) {
		TicTacToe game = new TicTacToe('X');
		Scanner scanner = new Scanner(System.in);

		do {
			System.out.println(game.toString());
			System.out.println(game.getTurn() + ": Where do you want to mark? Enter row column");
			int row = scanner.nextInt();
			int column = scanner.nextInt();
			scanner.nextLine();
			game.takeTurn(row, column);

		} while (game.getGameState() == GameStatus.IN_PROGRESS);
		System.out.println(game.getGameState());

	}

}
