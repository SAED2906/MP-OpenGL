package org.networking;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	
	public static int newLobby() {
	
			String host_Final = "192.168.1.53";
			String HOST = host_Final;
	        final int PORT = 25565;
	        int lobbyNum = -1;
	        
	        try (
	            Socket socket = new Socket(HOST, PORT);
	            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
	            Scanner in = new Scanner(socket.getInputStream());
	            Scanner s = new Scanner("NEW");
	        		
	        		
	        ) {

	                String input = s.nextLine();
	                out.println(input);
	                
	                lobbyNum = Integer.parseInt(in.nextLine());

	        } catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
		}
			return lobbyNum;
	}
	
	public static void join(int lobby_num, String name) {
		
		String host_Final = "192.168.1.53";
		String HOST = host_Final;
        final int PORT = 25565;
        
        try (
            Socket socket = new Socket(HOST, PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner in = new Scanner(socket.getInputStream());
            Scanner s = new Scanner("Join," + lobby_num + "," + name);
        		
        		
        ) {

                String input = s.nextLine();
                out.println(input);
                
                //in.nextLine();

        } catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	}
}
	
	public static void update(float x, float y, int type) {
		
		String host_Final = "192.168.1.53";
		String HOST = host_Final;
        final int PORT = 25565;
        
        try (
            Socket socket = new Socket(HOST, PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner in = new Scanner(socket.getInputStream());
            Scanner s = new Scanner("Packet," + x + "," + y + "," + type);
        		
        		
        ) {

                String input = s.nextLine();
                out.println(input);
                
                in.nextLine();

        } catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	}
}
	
	

}
