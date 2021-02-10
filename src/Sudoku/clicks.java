package Sudoku;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class clicks implements ActionListener{
	sudoku game;
	//final Color c = Color.decode("F4EAFF");
	Color c = new Color(244,234,255);
	
	public clicks(sudoku game) {
		this.game = game;
	}
	
	//override method in ActionListener
	public void actionPerformed(ActionEvent event) {
		
		if(event.getSource() instanceof button) {
			button click = (button)event.getSource();
			//only modify value if not filled 
			if(!click.getDisplay() && game.getCurrentNum() != 0 && click.getBackground()!= c ) {
				click.setDisplay(game.getCurrentNum());
				if(game.checkWin(click)) {
					click.setBackground(c);
				}
					
			}
		}
		

		else if(event.getSource() instanceof userButton) {
			
			userButton user = (userButton) event.getSource();
			game.setCurrentNum(user.getVal());
		}
	}
	

}

