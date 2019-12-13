
public class TicTacToe {
	private int dimension; //Grid dimensions
	private char grid[][];
	private char turn;
	private GameStatus gameState;
	private int plays; //Used to detect full grid for draw

	public TicTacToe(char initialTurn) {
		this (3,initialTurn);
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
	
}
