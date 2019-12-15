import java.util.EventObject;

import javax.swing.JButton;

public class TictactoeEvent extends EventObject {

	private int x, y;
	private char turn;
	private GameStatus status;
	private char[][] grid;

	public TictactoeEvent(TicTacToeModel source, int x, int y, char turn, GameStatus status) {
		super(source);
		this.x = x;
		this.y = y;
		this.turn = turn;
		this.status = status;
	}
	
	public TictactoeEvent(TicTacToeModel source, char[][] buttons, char turn, GameStatus status) {
		super(source);
		this.turn = turn;
		this.status = status;
		this.grid = buttons;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public char getTurn() {
		return turn;
	}

	public char[][] getGrid() {
		return grid;
	}
	
	public GameStatus getStatus() {
		return status;
	}


}
