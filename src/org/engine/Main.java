package org.engine;

import org.graphics.Renderer;
import org.networking.Client;
import org.test.TestPlayer;
import org.world.World;
import org.world.tiles.GrassTile;

public class Main {
	
	static int lobbyNum = -1;

	public static void main(String[] args) {
		
		Renderer.init();
		//lobbyNum = Client.newLobby();
		//Client.join(lobbyNum, "William");
		GameLoop.start();
		
		
		
		
		
		//TestCode
		
		
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++) {
				GrassTile tile = new GrassTile();
				tile.x = tile.width * x;
				tile.y = tile.height * y;
				World.addTile(tile);
			}
		}
		World.addObject(new TestPlayer());
		//World.addTile(new GrassTile());
	}

}
