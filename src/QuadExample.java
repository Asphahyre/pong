import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
 
public class QuadExample {
	
	public static boolean collision(Square r1,Square r2){
	    if((r2.getX() >= r1.getX() + r1.getWidth()) // trop à droite
	     || (r2.getX() + r2.getWidth() <= r1.getX()) // trop à gauche
	     || (r2.getY() >= r1.getY() + r1.getHeight()) // trop en bas
	     || (r2.getY() + r2.getHeight() <= r1.getY())) // trop en haut
	     return false; 
	    else
	     return true;
	}
	public static boolean screenCollision(Ball ball) {
		if((10 >= ball.getY()) || (990 <= ball.getY() + ball.getHeight()))
			return true;
		else
			return false;
	}
	
	public static int gameOver(Ball ball) {
	    if((10 >= ball.getX() + ball.getWidth()))
	    	return 2; 
	   	else if((990 <= ball.getX()))
	   		return 1;
	   	else
	   		return 0;
	}
	
 
    public void start() {
        try {
        	Display.setDisplayMode(new DisplayMode(800,600));
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
	
        boolean opened = true;
        Square player1 = new Square(50,375,30,250);
        Square player2 = new Square(920,375,30,250);
        Ball ball = new Ball(490,490,20,20);
        Square window = new Square(0,0,1000,1000);
        
        ball.setMove(1, 1);
 
        while (opened) {
        	
        	opened = !Display.isCloseRequested();
        	if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){opened = false;}
        	if(gameOver(ball) != 0){opened = false;}
        
            if(Keyboard.isKeyDown(Keyboard.KEY_UP)){player2.yMove(4);}
            if(Keyboard.isKeyDown(Keyboard.KEY_DOWN)){player2.yMove(-4);}
            if(Keyboard.isKeyDown(Keyboard.KEY_Z)){player1.yMove(4);}
            if(Keyboard.isKeyDown(Keyboard.KEY_S)){player1.yMove(-4);}
        	
        	// Clear the screen and depth buffer
        	GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);	
 
        	// set the color of the quad (R,G,B,A)
        	GL11.glColor3f(1.0f,1.0f,1.0f);
        	
        	ball.move();
        	
        	if(collision(ball,player1)) {
        		ball.changeMove(1);
        	}
        	if(collision(ball,player2)) {
        		ball.changeMove(2);
        	}
        	
        	if(screenCollision(ball)) {
        		ball.changeMove(3);
        	}
 
        	// draw quad
        	player1.draw();
        	player2.draw();
        	ball.draw();
        	
        	//player1.yMove(1);
 
        	Display.update();
        	Display.sync(60);
	    
        }
 
        Display.destroy();
    }
 
    public static void main(String[] argv) {
        QuadExample quadExample = new QuadExample();
        quadExample.start();
    }
}