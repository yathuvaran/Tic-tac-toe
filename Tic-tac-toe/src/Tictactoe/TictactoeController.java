package Tictactoe;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class TictactoeController implements ActionListener{
	
	private TicTacToeModel gameModel;
	private TictactoeView gameView;
	private JButton[][] buttons;
	private JButton reset;
	
	public TictactoeController(TicTacToeModel gameModel,TictactoeView gameView) {
		this.gameModel = gameModel;
		this.gameView = gameView;
		this.buttons = gameView.buttons;
		this.reset = gameView.reset;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (reset.equals(e.getSource())) {
			gameModel.reset('X');
		}
		else {
			for (int i = 0; i < buttons.length; i++) {
				for(int j = 0; j < buttons.length; j++) {
					if (buttons[i][j].equals(e.getSource())) {
						try {
						gameModel.takeTurn(i, j);
						}
						catch(IllegalArgumentException error){
							gameView.displayErrorMessage(error);
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		TicTacToeModel gameModel = new TicTacToeModel('X');
		TictactoeView gameView = new TictactoeView(gameModel);
	}

}
