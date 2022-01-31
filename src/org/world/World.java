package org.world;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class World {
	
	private static ConcurrentLinkedQueue<Tile> tiles = new ConcurrentLinkedQueue<Tile>();
	
	//private static ArrayList<Tile> tiles = new ArrayList<Tile>();
	private static ConcurrentLinkedQueue<GameObject> gameObjects = new ConcurrentLinkedQueue<GameObject>();
	
	public static void update() {
		
		for (GameObject go : gameObjects) {
			go.update();
		}
		
	}
	
	public static void render() {
		//Render All tiles
		for (Tile tile : tiles) {
			tile.render();
		}
		
		//Render all objects
		for (GameObject go : gameObjects) {
			go.render();
		}
		
	}
	
	public static void addObject (GameObject go) {
		gameObjects.offer(go);
	}
	
	public static void addTile (Tile tile) {
		tiles.offer(tile);
	}

}
