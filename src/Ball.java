public class Ball extends Square {
	
	int[] move;
	int multiplier = 2;
	
	public Ball(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.setRandomMove();
	}
	
	public void setRandomMove() {
		this.move = new int[]{1,1};
	}
	
	public void move() {
		this.xMove(this.move[0]*this.multiplier);
		this.yMove(this.move[1]*this.multiplier);
	}
	
	public void setMove(int x, int y) {
		this.move[0] = x;
		this.move[1] = y;
		
	}

	public void changeMove(int i) {
		switch(i) {
		case 1:
			this.move[0] = 1;
			break;
		case 2:
			this.move[0] = -1;
			break;
		case 3:
			if(this.move[1] == 1)
				this.move[1] = -1;
			else
				this.move[1] = 1;
			break;
		}
		
	}
	

}
