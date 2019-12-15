import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TictactoeView extends JFrame implements TictactoeListener{

	JButton[][] buttons;
	JButton reset;
	TicTacToeModel gameModel;
	

	TictactoeView(TicTacToeModel gameModel) {
		this.setTitle("Tic-tac-toe");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 300);
		JPanel buttonPanel = new JPanel();
		JMenuBar menuBar = new JMenuBar();
		reset = new JButton("Reset");
		buttons = new JButton[3][3];
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons.length; j++) {
				buttons[i][j] = new JButton();
				buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
				buttons[i][j].addActionListener(new TictactoeController(gameModel,this));
				buttonPanel.add(buttons[i][j]);
			}
		}
		buttonPanel.setLayout(new GridLayout(3, 3));
		menuBar.add(reset);
		this.gameModel = gameModel;
		this.setJMenuBar(menuBar);
		this.add(buttonPanel);
		gameModel.addView(this);
		this.setVisible(true);
	}
	
	public JButton[][] getButtons() {
		return buttons;
	}
	
	public void displayErrorMessage(IllegalArgumentException e) {
		JOptionPane.showMessageDialog(this, e.getMessage());
	}

	@Override
	public void handleTictactoeEvent(TictactoeEvent e) {
		buttons[e.getX()][e.getY()].setText(Character.toString(e.getTurn()));
	}

}
