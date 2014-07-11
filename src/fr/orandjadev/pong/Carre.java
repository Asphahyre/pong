package fr.orandjadev.pong;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class Carre {
	int x,y,hauteur,largeur;
	public Carre(int x, int y, int hauteur, int largeur){
		this.x=x;
		this.y=y;
		this.hauteur=hauteur;
		this.largeur=largeur;
	}
	
	public void draw(){
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glVertex2i(x, y);
			GL11.glVertex2i(x+largeur, y);
			GL11.glVertex2i(x+largeur, y+hauteur);
			GL11.glVertex2i(x, y+hauteur);
		GL11.glEnd();
	}
}
