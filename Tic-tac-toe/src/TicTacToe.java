
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
	
	
	

}
