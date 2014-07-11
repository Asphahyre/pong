import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class Square {
	
	int x, y, width, height;
	
	public Square(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public void draw() {
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glVertex2f(this.x,this.y);
		GL11.glVertex2f(this.x+this.width,this.y);
		GL11.glVertex2f(this.x+this.width,this.y+this.height);
		GL11.glVertex2f(this.x,this.y+this.height);
		GL11.glEnd();
	}
	
	public void yMove(int i) {
		this.y+=i;
	}
	
	public void xMove(int i) {
		this.x+=i;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	

}
