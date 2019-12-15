import java.util.EventObject;

public class TictactoeEvent extends EventObject {

	private int x, y;
	private char turn;
	private GameStatus status;

	public TictactoeEvent(TicTacToeModel source, int x, int y, char turn, GameStatus status) {
		super(source);
		this.x = x;
		this.y = y;
		this.turn = turn;
		this.status = status;
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

	public GameStatus getStatus() {
		return status;
	}

}
