package doublebuffering;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class ScoreFrame {
	public class scorePanel extends JPanel{
		public void paintComponent(Graphics g){
			Graphics2D g2d = (Graphics2D)g;
			g.clearRect(0,0,WIDTH,HEIGHT);
			g.drawString("score", 300, 300);

		}
	}
}
