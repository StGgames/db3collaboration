package com.main.gameObject.player.hud;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.main.window.Game;

public class HUD {

	public static int Health = 100;
	public static int Points = 0;
	public void render(Graphics g){
		g.setColor(Color.red);
		g.fillRect(15, 15, Health*2, 32);
		g.setColor(Color.white);
		g.drawRect(15, 15, 200, 32);
		
		g.setColor(Color.white);
		g.setFont(new Font("Helvetica", Font.BOLD, 30));
		g.drawString("COINS: " + Points, 15, Game.Height - 35);
	}

}
