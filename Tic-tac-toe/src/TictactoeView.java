import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TictactoeView extends JFrame {

	JButton[][] buttons;

	TictactoeView() {
		this.setTitle("Tic-tac-toe");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 300);
		JPanel buttonPanel = new JPanel();
		JMenuBar menuBar = new JMenuBar();
		JMenu reset = new JMenu("Reset");
		buttons = new JButton[3][3];
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons.length; j++) {
				buttons[i][j] = new JButton();
				buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
				buttons[i][j].addActionListener(tictactoeListener);
				buttonPanel.add(buttons[i][j]);
			}
		}
		buttonPanel.setLayout(new GridLayout(3, 3));
		menuBar.add(reset);
		this.setJMenuBar(menuBar);
		this.add(buttonPanel);
		this.setVisible(true);
	}

	public void setButtonText(int row, int column, String text) {
		buttons[row][column].setText(text);
	}
	
	public String getButtonText(int row, int column) {
		return buttons[row][column].getText();
	}
	
	public static void main(String[] args) {
		new TictactoeView();
	}

}
