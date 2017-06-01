package com.main.gameStates.stateChanger;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.main.gameStates.GameStates;

public class StateChanger implements MouseListener {

	GameStates gs;

	public StateChanger(GameStates gs) {
		this.gs = gs;
	}
	
	public boolean mouseOverBtn(MouseEvent e, int x, int y, int w, int h) {
		if (e.getX() >= x || e.getY() >= y || e.getX() <= x + w || e.getY() <= y + h) {
			return true;
		}
		
		return false;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getX() + e.getY());
		
		if(mouseOverBtn(e, 800/2 - 200/2, 600/3, 200, 64)){	
			gs = GameStates.Game;
		}
		
		if(mouseOverBtn(e, 800/2 - 200/2, 600/2, 200, 64)){	
			gs = GameStates.Help;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
