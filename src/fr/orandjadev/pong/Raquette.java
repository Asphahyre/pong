package fr.orandjadev.pong;

import org.lwjgl.input.Keyboard;

public class Raquette extends Carre{

	int buttonUP;
	int buttonDOWN;
	
	public Raquette(int x, int y, int hauteur, int largeur, int buttonup, int buttondown) {
		super(x, y, hauteur, largeur);
		this.buttonUP = buttonup;
		this.buttonDOWN = buttondown;
	}
	
	public void input(){
		if (Keyboard.isKeyDown(buttonUP)){
			y+=3;
		}
		if (Keyboard.isKeyDown(buttonDOWN)){
			y-=3;
		}
		if(y>800)y=800;
		if(y<0)y=0;
	}
}
