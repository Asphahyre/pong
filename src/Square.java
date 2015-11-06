import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class Square {
	
	int x, y, width, height;
	boolean isCircle;
	
	public Square(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.isCircle = false;
	}
	
	public Square(int x, int y, int width, int height, boolean isCircle){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.isCircle = isCircle;
	}

	public void draw() {
		if (!this.isCircle)
		{
			GL11.glBegin(GL11.GL_QUADS);
			GL11.glVertex2f(this.x,this.y);
			GL11.glVertex2f(this.x+this.width,this.y);
			GL11.glVertex2f(this.x+this.width,this.y+this.height);
			GL11.glVertex2f(this.x,this.y+this.height);
			GL11.glEnd();
		} else {
			float[] vertexes = getFilledArcVertexes(this.x, this.y, this.height/2, 0, 360, 10);
			for (int i=0; i < 11 ; i++)
			{
				GL11.glBegin(GL11.GL_TRIANGLES);
				GL11.glVertex2f(vertexes[i*6], vertexes[i*6+1]);
				GL11.glVertex2f(vertexes[i*6+2], vertexes[i*6+3]);
				GL11.glVertex2f(vertexes[i*6+4], vertexes[i*6+5]);
				GL11.glEnd();
			}
		}
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
	
	public static float[] getFilledArcVertexes(float x, float y, float r, double startingAngleDeg, double endAngleDeg, int slices) {
        if(startingAngleDeg < 0)
            System.out.println("Starting angle cannot be smaller than 0");
        if(endAngleDeg >= 720)
        	System.out.println("End angle cannot be greater or equal to than 720");
        if(endAngleDeg < startingAngleDeg)
        	System.out.println("End angle cannot be smaller than starting angle");
        int radius = (int) r;

        double arcAngleLength = (endAngleDeg - startingAngleDeg) / 360f;

        float[] vertexes = new float[slices*6+6];

        double initAngle = Math.PI / 180f * startingAngleDeg;
        float prevXA = (float) Math.sin(initAngle) * radius;
        float prevYA = (float) Math.cos(initAngle) * radius;

        for(int arcIndex = 0; arcIndex < slices+1; arcIndex++) {
            double angle = Math.PI * 2 * ((float)arcIndex) / ((float)slices);
            angle += Math.PI / 180f;
            angle *= arcAngleLength;
            int index = arcIndex * 6;
            float xa = (float) Math.sin(angle) * radius;
            float ya = (float) Math.cos(angle) * radius;
            vertexes[index] = x;
            vertexes[index+1] = y;
            vertexes[index+2] = x+prevXA;
            vertexes[index+3] = y+prevYA;
            vertexes[index+4] = x+xa;
            vertexes[index+5] = y+ya;
            prevXA = xa;
            prevYA = ya;
        }

        return vertexes;
    }

}
