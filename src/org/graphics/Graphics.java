package org.graphics;

import org.resource.ImageResource;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.texture.Texture;

public class Graphics {
	
	private static float red = 1;
	private static float green = 1;
	private static float blue = 1;
	private static float alpha = 1;
	
	//Rotation Degrees
	
	private static float Rotation = 0;
	
	public static void drawImage(ImageResource Image, float x, float y, float width, float height) {
		
		GL2 gl = EventListener.gl;
		
		Texture texture = Image.getTexture();
		
		if (x - width/2 - Renderer.camerax > Renderer.unitsWide/2 || x + width/2 - Renderer.camerax < -Renderer.unitsWide/2 || y - height/2 - Renderer.cameray > Renderer.unitsTall/2 || y + height/2 - Renderer.cameray < -Renderer.unitsTall/2) {
			return;
		}
		
		if (texture != null) {
			gl.glBindTexture(GL2.GL_TEXTURE_2D, texture.getTextureObject());
		}
		
		gl.glTranslated(x, y, 0);
		gl.glRotated(-Rotation, 0, 0, 1);
		
		
		
		gl.glColor4f(red, green, blue, alpha);
		gl.glBegin(GL2.GL_QUADS);
		
			gl.glTexCoord2f(0, 1);
			gl.glVertex2f(-width/2, -height/2);
			
			gl.glTexCoord2f(1, 1);
			gl.glVertex2f(width/2, -height/2);
			
			gl.glTexCoord2f(1, 0);
			gl.glVertex2f(width/2, height/2);
			
			gl.glTexCoord2f(0, 0);
			gl.glVertex2f(-width/2, height/2);
			
		gl.glEnd();
		gl.glFlush();
		
		gl.glBindTexture(GL2.GL_TEXTURE_2D, 0);
		
		gl.glRotated(Rotation, 0, 0, 1);
		gl.glTranslatef(-x, -y, 0);
		
	}
	
	public static void fillRect(float x, float y, float width, float height) {
		
		GL2 gl = EventListener.gl;
		
		gl.glTranslated(x, y, 0);
		gl.glRotated(-Rotation, 0, 0, 1);
		
		
		
		gl.glColor4f(red, green, blue, alpha);
		gl.glBegin(GL2.GL_QUADS);
			gl.glVertex2f(-width/2, -height/2);
			gl.glVertex2f(width/2, -height/2);
			gl.glVertex2f(width/2, height/2);
			gl.glVertex2f(-width/2, height/2);
		gl.glEnd();
		gl.glFlush();
		
		gl.glRotated(Rotation, 0, 0, 1);
		gl.glTranslatef(-x, -y, 0);
		
	}
	
	public static void setColor(float r, float g, float b, float a) {
		red = Math.max(0, Math.min(1, r));
		green = Math.max(0, Math.min(1, g));
		blue = Math.max(0, Math.min(1, b));
		alpha = Math.max(0, Math.min(1, a));
	}
	
	public static void setRotation(float r){
		Rotation = r;
	}

}
