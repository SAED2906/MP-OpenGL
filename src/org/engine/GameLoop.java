package org.engine;

import org.graphics.Renderer;
import org.world.World;

public class GameLoop {

	private static boolean running = false;
	
	private static int updates = 0;
	private static final int MAX_UPDATES = 5;
	
	private static long lastUpdateTime = 0;
	
	private static int targetFPS = 144;
	private static int targetTime = 1000000000 / targetFPS;
	
	public static void start() {
		Thread thread = new Thread() {
			public void run() {
				
				running = true;
				
				lastUpdateTime = System.nanoTime();
				
				int fps = 0;
				long lastfps_check = System.nanoTime();
				
				while (running) {
					
					long currentTime = System.nanoTime();
					
					updates = 0;
					
					while ((currentTime - lastUpdateTime) >= targetTime) {
						World.update();
						lastUpdateTime += targetTime;
						updates++;
						
						if (updates > MAX_UPDATES) {
							break;
						}
					}
					
					Renderer.Render();
//					
//					fps++;
//					if (System.nanoTime() >= lastfps_check + 1000000000) {
//						System.out.println(fps);
//						fps = 0;
//						lastfps_check = System.nanoTime();
//					}
					
					long timeTaken = System.nanoTime() - currentTime;
					
					if (timeTaken < targetTime) {
						try {
							Thread.sleep((targetTime - timeTaken)/1000000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
					
					
					
					//long startTime = System.nanoTime();
					
					//Pull input
					
					//UpdateGame
					
//					World.update();
//					
//					//Render
//					
//					Renderer.Render();
//					
//					long timeTaken = System.nanoTime() - startTime;
//					
//					if (timeTaken < targetTime) {
//						try {
//							Thread.sleep((targetTime - timeTaken) / 1000000);
//						} catch (InterruptedException e) {
//							e.printStackTrace();
//						}
//					}
					
					
					//Networking below \/
					
					
					
					
					
					
					
				}
				
			}
		};
		thread.setName("Gameloop");
		thread.start();
	}
	
	public static float updateDelta() {
		return 1.0f / 1000000000 * targetTime;
	}
	
}
