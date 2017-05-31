package com.main.gameObject;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
	protected int x;
	protected int y;
	private ID Id;
	protected float velX;
	protected float velY;
	public GameObject(ID Id, int x, int y) {
		this.Id = Id;
		this.x = x;
		this.y = y;
		this.setVelX(0);
		this.setVelY(0);
	}

	public abstract void render(Graphics g);
	
	public abstract void tick();

	public abstract float getVelY();

	public abstract void setVelY(float velY);

	public abstract float getVelX();

	public abstract void setVelX(float velX);
	
	public abstract Rectangle getBounds();

	public ID getId() {
		return Id;
	}
}
