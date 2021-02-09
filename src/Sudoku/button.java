package Sudoku;

import java.awt.Dimension;

import javax.swing.JButton;

public class button extends JButton {
	int num;
	boolean display;
	int input;
	
	public button() {
		this.setPreferredSize(new Dimension(80,80));
	}
	
	public button(int num, boolean display) {
		this.setPreferredSize(new Dimension(80,80));
		if(display) 
			this.setText(""+ num);
		this.num = num;
		this.display = display;
		// removes blue border of the button when clicked
		this.setFocusPainted(false);
	}
	
	public void setDisplay(int input) {
		this.input = input;
		this.setText("" + input);
	}
	
	public boolean getDisplay() {
		return display;
	}
}
