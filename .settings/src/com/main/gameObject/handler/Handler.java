package com.main.gameObject.handler;

import java.awt.Graphics;
import java.util.ArrayList;

import com.main.gameObject.GameObject;

public class Handler {

	public ArrayList<GameObject> objects = new ArrayList<GameObject>();
	
	public void tick(){
		for(int i=0;i<this.objects.size();i++){
			GameObject temp = this.objects.get(i);
			temp.tick();
		}
	}
	
	public void render(Graphics g){
		for(int i=0;i<this.objects.size();i++){
			GameObject temp = this.objects.get(i);
			temp.render(g);
		}
	}
	
	public void addObject(GameObject obj){
		objects.add(obj);
	}
	
	public void removeObject(GameObject obj){
		objects.remove(obj);
	}
	
	public void clearObjects(){
		objects.clear();
	}
	
}
