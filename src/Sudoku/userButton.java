package Sudoku;

import java.awt.Dimension;

import javax.swing.JButton;

public class userButton extends JButton{
	int value;
	public userButton(int val) {
		value = val;
		this.setText(""+ value);
		this.setPreferredSize(new Dimension(50,50));
	}
	public userButton() {
		this.setPreferredSize(new Dimension(50,50));
	}
	public int getVal() {
		return value;
	}
}
