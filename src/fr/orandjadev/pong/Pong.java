package fr.orandjadev.pong;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class Pong {
	
	Raquette RaquetteGauche = new Raquette(30, 400 , 200, 20, Keyboard.KEY_Z,Keyboard.KEY_S);
	Raquette RaquetteDroite = new Raquette(950, 400 , 200, 20,Keyboard.KEY_UP,Keyboard.KEY_DOWN);
	Ball ball = new Ball(490, 490, 20, 20, 4);
	
	public boolean collision(Carre r1,Carre r2){
	    if((r2.x >= r1.x + r1.largeur) // trop à droite
	     || (r2.x + r2.largeur <= r1.x) // trop à gauche
	     || (r2.y >= r1.y + r1.hauteur) // trop en bas
	     || (r2.y + r2.hauteur <= r1.y)) // trop en haut
	     return false; 
	    else
	     return true;
	}
    public void start() {
        try {
        	Display.setDisplayMode(new DisplayMode(1000,1000));
        	Display.create();
        } catch (LWJGLException e) {
        	e.printStackTrace();
        	System.exit(0);
        }
        // init OpenGL
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, 1000, 0, 1000, 1, -1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        while (!Display.isCloseRequested()) {
        	
        	
        	// Clear the screen and depth buffer
        	GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);	
 
        	// set the color of the quad (R,G,B,A)
        	GL11.glColor3f(1.0f,1.0f,1.0f);
        	
        	RaquetteGauche.input();
        	RaquetteDroite.input();
        	ball.logic();
        	if (collision(RaquetteDroite, ball))ball.flipX();
        	if (collision(RaquetteGauche, ball))ball.flipX();
        	RaquetteDroite.draw();
        	RaquetteGauche.draw();
        	ball.draw();
 
        	Display.update();
        	Display.sync(60);
	    
        }
 
        Display.destroy();
    }
	public static void main(String[] args) {
		Pong pong = new Pong();
		pong.start();
	}

}
