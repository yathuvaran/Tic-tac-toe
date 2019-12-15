package Tictactoe;
public interface TictactoeListener {
	
	public void handleTictactoeEvent(TictactoeEvent e);
	
	public void handleReset(TictactoeEvent e);

}
