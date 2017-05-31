package com.main.gameObject.player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.main.gameObject.GameObject;
import com.main.gameObject.ID;
import com.main.gameObject.handler.Handler;
import com.main.gameObject.player.hud.HUD;

public class Player extends GameObject {
	public static Color currentColor = Color.green;
	public boolean greenPicked = false;
	public boolean bluePicked = false;
	public boolean pinkPicked = false;
	public boolean orangePicked = false;
	
	private Handler handler;
	public Player(ID Id, int x, int y, Handler handler) {
		super(Id, x, y);
		// TODO Auto-generated constructor stub
		this.handler = handler;
	}
	
	public void collision(){
		for(int i=0;i<this.handler.objects.size();i++){
			GameObject temp = this.handler.objects.get(i);
			
			if(temp.getId() == ID.ENEMY){
				if(temp.getBounds().intersects(this.getBounds())){
					HUD.Health--;
				}
			}
		}
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x, y, 32, 32);
	}

	@Override
	public void render(Graphics g) {
		if (greenPicked) {
			currentColor = Color.green;
		}else if(bluePicked){
			currentColor = Color.blue;
		}else if(pinkPicked){
			currentColor = Color.pink;
		}else if(orangePicked){
			currentColor = Color.orange;
		}
		
		g.setColor(currentColor);
		g.fillRect(x, y, 32, 32);
	}

	@Override
	public void tick() {
		x+=velX;
		y+=velY;
	}

	@Override
	public float getVelY() {
		// TODO Auto-generated method stub
		return velY;
	}

	@Override
	public void setVelY(float velY) {
		this.velY = velY;		
	}

	@Override
	public float getVelX() {
		// TODO Auto-generated method stub
		return velX;
	}

	@Override
	public void setVelX(float velX) {
		this.velX = velX;	
	}

}
