package org.graphics;

import org.input.KeyInput;
import org.input.mouseInput;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.FPSAnimator;

public class Renderer {
	
	private static GLWindow window = null;
	private static GLProfile profile = null;
	
	public static int screenWidth = 640;
	public static int screenHeight = 360;
	
	public static float unitsWide = 10;
	public static float unitsTall;
	
	public static float camerax = 0;
	public static float cameray = 0;
	
	public static void init() {
		GLProfile.initSingleton();
		profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities caps = new GLCapabilities(profile);
		
		window = GLWindow.create(caps);
		window.requestFocus();
		window.setSize(screenWidth, screenHeight);
		window.setResizable(false);
		window.addGLEventListener(new EventListener());
		window.addMouseListener(new mouseInput());
		window.addKeyListener(new KeyInput());
		
		
		FPSAnimator animator = new FPSAnimator(window, 144);
		animator.start();
		
		window.setFullscreen(true);
		window.setVisible(true);
		
	}
	
	public static void Render() {
		if (window == null) {
			return;
		}
		
		window.display();
	}
	
	public static int getWidth() {
		return window.getWidth();
	}
	
	public static int getHeight() {
		return window.getHeight();
	}
	
	
	public static GLProfile getProfile() {
		return profile;
	}

}
