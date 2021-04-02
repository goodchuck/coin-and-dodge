package doublebuffering;

import java.awt.Font;

import javax.swing.ImageIcon;

public class Enemy {
	ImageIcon 적 = new ImageIcon("src/IMAGE/enemy.png");
    ImageIcon 적2 = new ImageIcon("src/IMAGE/적2.gif");
    ImageIcon 적3 = new ImageIcon("src/IMAGE/적3.png");
    public final Font font = new Font("맑은 고딕", Font.BOLD | Font.ITALIC, 30);
    int[] 적rectX = {0,0,0,0,0,0,0,0};
    int[] 적rectY = {0,0,0,0,0,0,0,0}; 
    private int ErectX1 = 0;
    private int ErectY1 = 0;
    private int ErectX2 = 0;
    private int ErectY2 = 0;
    public final int 적rectSize = 50; // 적 크기
    
    
    
	public int getErectX1() {
		return ErectX1;
	}

	public void setErectX1(int erectX1) {
		ErectX1 = erectX1;
	}

	public int getErectY1() {
		return ErectY1;
	}

	public void setErectY1(int erectY1) {
		ErectY1 = erectY1;
	}

	public int getErectX2() {
		return ErectX2;
	}

	public void setErectX2(int erectX2) {
		ErectX2 = erectX2;
	}

	public int getErectY2() {
		return ErectY2;
	}

	public void setErectY2(int erectY2) {
		ErectY2 = erectY2;
	}

	public ImageIcon get적() {
		return 적;
	}

	public void set적(ImageIcon 적) {
		this.적 = 적;
	}

	public ImageIcon get적2() {
		return 적2;
	}

	public void set적2(ImageIcon 적2) {
		this.적2 = 적2;
	}

	public ImageIcon get적3() {
		return 적3;
	}

	public void set적3(ImageIcon 적3) {
		this.적3 = 적3;
	}

	public int[] get적rectX() {
		return 적rectX;
	}

	public void set적rectX(int[] 적rectX) {
		this.적rectX = 적rectX;
	}

	public int[] get적rectY() {
		return 적rectY;
	}

	public void set적rectY(int[] 적rectY) {
		this.적rectY = 적rectY;
	}

	public Font getFont() {
		return font;
	}

	public int get적rectSize() {
		return 적rectSize;
	}





}
