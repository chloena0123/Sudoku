package Sudoku;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class userButton extends JButton{
	int value;
	public userButton(int val) {
		value = val;
		this.setText(""+ value);
		this.setPreferredSize(new Dimension(100,100));
		this.setBorder(new LineBorder(Color.decode("#E8EAEA"), 1));
		this.setFont(new Font("monospaced",Font.PLAIN,30));
	}
	
	public int getVal() {
		return value;
	}
}
