package Sudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class clicks implements ActionListener{
	sudoku game;
	
	public clicks(sudoku game) {
		this.game = game;
	}
	
	//override method in ActionListener
	public void actionPerformed(ActionEvent event) {
		button click = (button)event.getSource();
		//only modify value if not filled
		if(!click.getDisplay())
			click.setDisplay(game.getNum());

		if(event.getSource() instanceof userButton) {
			/*
			 * fix : casting? combine two if conditions (should be modified when 
			 * user clicks on the userButton)
			*/
			click.setDisplay(game.getNum());
		}
	}
}
