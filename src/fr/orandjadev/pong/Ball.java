package fr.orandjadev.pong;

public class Ball extends Carre {
	int speed;
	boolean sensx = true;
	boolean sensy = true;
	
	int basex;
	int basey;
	
	public Ball(int x, int y, int hauteur, int largeur, int speed) {
		super(x, y, hauteur, largeur);
		this.speed = speed;
		basex=x;
		basey=y;
	}
	
	public void logic(){
		x += (sensx)?speed:-speed;
		y += (sensy)?speed:-speed;
		if(y>1000-hauteur)flipY();
		if(y<0)flipY();
		if(x<-largeur){x=basex;y=basey;flipX();}
		if(x>1000){x=basex;y=basey;flipX();}
		
	}
	
	public void flipX(){
		sensx = !sensx;
	}
	public void flipY(){
		sensy = !sensy;
	}
}
