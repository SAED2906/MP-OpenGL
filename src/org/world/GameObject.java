package org.world;

import org.graphics.Animation;
import org.graphics.Graphics;

public class GameObject {
	
	
	//Position
	public float x = 0;
	public float y = 0;
	
	//Size
	public float width = 1;
	public float height = 1;
	
	//Rotation
	public float rotation = 0;
	
	public Animation[] animations;
	public int currentAnimation = 0;
	
	
	public void update() {
		//Implement in subclass
	}
	
	public void render() {
		//Implement in subclass
		animations[currentAnimation].play();
		Graphics.setRotation(rotation);
		Graphics.drawImage(animations[currentAnimation].getImage(), x, y, width, height);
		Graphics.setRotation(0);
	}

}
