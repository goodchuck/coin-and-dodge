package doublebuffering;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class EndFrame {
	 ImageIcon 끝화면 = new  ImageIcon("src/IMAGE/끝화면.png");
	class endPanel extends JPanel{
		public void paintComponent(Graphics g){
			Graphics2D g2d = (Graphics2D) g;
			g.drawImage(끝화면.getImage(), 0,0,  800, 800, this);
			//m_timer.stop();
		}
		}
}
