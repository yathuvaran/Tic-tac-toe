import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TictactoeView extends JFrame{
	
	TictactoeView(){
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300,300);
		JButton b1=new JButton("1");  
	    JButton b2=new JButton("2");  
	    JButton b3=new JButton("3");  
	    JButton b4=new JButton("4");  
	    JButton b5=new JButton("5");  
	    JButton b6=new JButton("6");  
	    JButton b7=new JButton("7");  
	    JButton b8=new JButton("8");  
	    JButton b9=new JButton("9");
	    this.add(b1);this.add(b2);this.add(b3);
	    this.add(b4);this.add(b5);this.add(b6);
	    this.add(b7);this.add(b8);this.add(b9);
	    
	    this.setLayout(new GridLayout(3,3));
	    this.setVisible(true);	
	}
	
	public static void main(String[] args) {
		new TictactoeView();
	}

}
