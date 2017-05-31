package com.main.window;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

import javax.swing.JFrame;

import com.main.gameObject.ID;
import com.main.gameObject.coin.Coin;
import com.main.gameObject.handler.Handler;
import com.main.gameObject.player.Player;
import com.main.gameObject.player.hud.HUD;
import com.main.gameStates.GameStates;

@SuppressWarnings("serial")
public class Game extends Canvas implements Runnable {

	private boolean running = false;
	private Thread thread;
	public static JFrame frame = new JFrame();
	public Handler handler = new Handler();
	public HUD hud;
	public GameStates gameState = GameStates.Menu;
	public static final int Width = 800;
	public static final int Height = 600;
	
	public void init(){
		if(gameState == GameStates.Game){
			Random r = new Random();
			handler.addObject(new Player(ID.PLAYER, Width/2, Height/2, handler));
			handler.addObject(new Coin(ID.COIN, r.nextInt(800), r.nextInt(600), "/Coin.png"));
			handler.addObject(new Coin(ID.COIN, r.nextInt(800), r.nextInt(600), "/Coin.png"));
			handler.addObject(new Coin(ID.COIN, r.nextInt(800), r.nextInt(600), "/Coin.png"));
			hud = new HUD();
		}
	}
	
	@Override
	public void run() {
		this.requestFocus();
		init();
		while (running) {
			tick();
			render();
		}
	}

	public void start() {
		if (running) {
			return;
		} else {
			running = true;
			thread = new Thread(this);
			thread.start();
		}
	}

	private void tick() {
		if(gameState == GameStates.Game)
			handler.tick();
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, Width, Height);
		
		if(gameState == GameStates.Menu){
			handler.objects.clear();
			
			//play button / font and button colors
			
			g.setColor(Color.white);
			g.setFont(new Font("Helvetica", Font.BOLD, 30));
			
			g.drawString("Play", 800/2 - 30, 600/3 + 40);
			g.drawRect(800/2 - 200/2, 600/3, 200, 64);
			
			g.drawString("Help", 800/2 - 30, 600/2 + 40);
			g.drawRect(800/2 - 200/2, 600/2, 200, 64);
			
			g.drawString("Dodge Box 3", 800/2 - 30*3, 35);
		}
		
		
		if(gameState == GameStates.Game){
			handler.render(g);
			hud.render(g);
		}
		
		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		new Window(Width, Height, "Dodge Box 3", new Game());
	}

}
