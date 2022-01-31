package org.graphics;

import org.resource.ImageResource;

public class Animation {
	
	//The frames of the animation
	public ImageResource[] frames;
	
	
	private int current_Frame = 0;
	
	//FPS
	
	public int fps = 8;
	private long lastframeTime = 0;
	
	//Loop
	public boolean loop = true;

	public void play() {
		long currentTime = System.nanoTime();
		
		if (currentTime > lastframeTime + 1000000000/fps) {
			current_Frame++;
			
			if (current_Frame >= frames.length) {
				if (loop) {
					current_Frame = 0;
				}else {
					current_Frame--;
				}
			}
			
			lastframeTime = currentTime;
		}
	}
	
	public ImageResource getImage() {
		return frames[current_Frame];
	}
	
}
