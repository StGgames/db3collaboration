package com.main.window;

import java.awt.Canvas;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Window extends Canvas {
	public Window(double w, double h, String title, Game game) {
		JFrame frame = new JFrame(title);

		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize((int) w, (int) h);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		game.start();
	}
}
