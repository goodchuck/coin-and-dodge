package doublebuffering;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MultiFrame {
	//-------------------------------------------------------- 멀티 관련 -------------------------------------------------------------	
		public class MultiPanel extends JPanel{
			 ImageIcon 시작화면 = new  ImageIcon("src/IMAGE/시작화면.jpg");
			 ImageIcon 도움말 = new ImageIcon("src/IMAGE/캡처.png");
			    public final Font font = new Font("맑은 고딕", Font.BOLD | Font.ITALIC, 30);
			public void paintComponent(Graphics g){
				Graphics2D g2d = (Graphics2D)g;
				//g.clearRect(0,0,WIDTH,HEIGHT);
				g.drawImage(시작화면.getImage(), 0,0,  800, 800, this);
				//g.drawImage(게임방법1.getImage(), x, y, 200,200, this);
				g.drawImage(도움말.getImage(), 45, 50, 700,500, this);
				g.setFont(font);
		        g.setColor(Color.WHITE);
		        g.drawString("팀명 : 비트코인 어드벤처" , 200, 600);
		        g.drawString("만든이들 : 양태현, 김보성, 이성진, 송태성", 100, 670);
			/*	mainmenu.setBounds(350,680,100,55);// 게임시작버튼
				mainmenu.setOpaque(false);
				mainmenu.setContentAreaFilled(false);
				mainmenu.setBorderPainted(false);
				multipanel.add(mainmenu); */
				 
				//mainmenu.addActionListener(new restartListener());
			}
		}
}
