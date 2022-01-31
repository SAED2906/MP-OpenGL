package org.input;

import org.graphics.Renderer;

import com.jogamp.newt.event.MouseEvent;
import com.jogamp.newt.event.MouseListener;

public class mouseInput implements MouseListener {
	
	private static int x  = 0;
	private static int y  = 0;
	
	public static int getX() {
		return x;
	}
	
	public static int getY() {
		return y;
	}
	
	public static float getWX() {
		return (Renderer.unitsWide / Renderer.getWidth() * x - Renderer.unitsWide/2) + Renderer.camerax;
	}
	
	public static float getWY() {
		float unitsTall = Renderer.unitsWide * ((float) Renderer.getHeight() / (float) Renderer.getWidth());
		return -(unitsTall / Renderer.getHeight() * y - unitsTall / 2) + Renderer.cameray;
	}

	public void mouseClicked(MouseEvent e) {
		//
		System.out.println(e.getX());
	}

	public void mouseDragged(MouseEvent e) {
		//
		
	}

	public void mouseEntered(MouseEvent e) {
		//
		
	}

	public void mouseExited(MouseEvent e) {
		//
		
	}

	public void mouseMoved(MouseEvent e) {
		//
		x = e.getX();
		y = e.getY();
	}

	public void mousePressed(MouseEvent e) {
		//
		
	}

	public void mouseReleased(MouseEvent e) {
		//
		
	}

	public void mouseWheelMoved(MouseEvent e) {
		//
		
	}
	
	

}
