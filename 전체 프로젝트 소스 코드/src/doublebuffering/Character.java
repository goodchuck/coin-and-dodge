package doublebuffering;

public class Character {
    // 실제로 캐릭터가 이동하는 함수
	private int x=0;
	private int y=0;
	private int XDirection = 0;
	private int YDirection = 0;
	int WIDTH = 800;
	int HEIGHT = 800;
	int circleSize = 50; // 주인공 크기
    public void move() {
    	setX(getX()+ getXDirection());
    	setY(getY()+ getYDirection());
        if(getX() <= 0)
        	setX(0);
        if(getX() >= WIDTH - circleSize) {
        	setX(WIDTH - circleSize);
        }
        if(getY() <= circleSize) {
        	setY(circleSize);
        }
        if(getY() >= WIDTH - circleSize)
        {
        	setY(WIDTH - circleSize);
        }
    }


	public int getXDirection() {
		return XDirection;
	}


	public void setXDirection(int XDirection) {
		this.XDirection = XDirection;
	}


	public int getYDirection() {
		return YDirection;
	}


	public void setYDirection(int YDirection) {
		this.YDirection = YDirection;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}
    
    
}
