package Sudoku;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class button extends JButton {
	//num is ans and input is user guess
	int num;
	boolean display;
	int input;
	
	public button(int num, boolean display) {
		this.setPreferredSize(new Dimension(80,80));
		if(display) 
			this.setText(""+ num);
		this.num = num;
		this.display = display;
		this.setFont(new Font("monospaced",Font.PLAIN,25));
		this.setBorder(new LineBorder(Color.decode("#E8EAEA"), 1));
	}
	
	public void setDisplay(int input) {
		this.input = input;
		this.setText("" + input);
		this.setForeground(Color.decode("#A4015E"));
	}
	
	public boolean getDisplay() {
		return display;
	}
	
	public int getAns() {
		return num;
	}
	
	public int getInput() {
		return input;
	}
	
}
