package com.main.gameObject;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
	protected int x;
	protected int y;
	private ID Id;
	private int velX, velY;
	public GameObject(ID Id, int x, int y) {
		this.setId(Id);
		this.x = x;
		this.y = y;
		this.setVelX(0);
		this.setVelY(0);
	}

	public abstract void render(Graphics g);
	
	public abstract void tick();

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}
	
	public abstract Rectangle getBounds();

	public ID getId() {
		return Id;
	}

	public void setId(ID id) {
		Id = id;
	}
}
