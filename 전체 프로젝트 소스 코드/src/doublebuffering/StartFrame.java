package doublebuffering;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class StartFrame extends JFrame{
	 ImageIcon 시작화면 = new  ImageIcon("src/IMAGE/시작화면.jpg");
	JButton startButtonImage = new JButton(new ImageIcon("src/IMAGE/시작버튼.jpg"));
	JButton multiImage = new JButton(new ImageIcon("src/IMAGE/캐릭터버튼.jpg"));
	JButton scoreImage = new JButton(new ImageIcon("src/IMAGE/게임시작버튼_보통.gif"));
	 ImageIcon startButton = new  ImageIcon("src/IMAGE/시작버튼.jpg");
	 ImageIcon startButtonPressed = new  ImageIcon("src/IMAGE/시작버튼.jpg");
	 StartPanel sp = new StartPanel();
	 public StartFrame() {
		setTitle("코인먹기 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setBounds(0,0,1400,800);
		add(sp);
		setSize(800,800);
		setVisible(true);
		startButtonImage.setBounds(150,300,500,55); // 게임시작버튼
		multiImage.setBounds(150,400,500,55); // 게임시작버튼
		scoreImage.setBounds(300,500,200,55);

		startButtonImage.setOpaque(false);
		startButtonImage.setContentAreaFilled(false);
		startButtonImage.setBorderPainted(false);
		
		multiImage.setOpaque(false);
		multiImage.setContentAreaFilled(false);
		multiImage.setBorderPainted(false);

		scoreImage.setOpaque(false);
		scoreImage.setContentAreaFilled(false);
		scoreImage.setBorderPainted(false);


		sp.add(startButtonImage);
		sp.add(multiImage);
		sp.add(scoreImage);

		startButtonImage.addMouseListener(new StartListener());
		multiImage.addMouseListener(new MultiListener());
		scoreImage.addMouseListener(new ScoreListener());
	 }
	 class StartPanel extends JPanel{
			public void paintComponent(Graphics g){
				//Graphics2D g2d = (Graphics2D)g;
				//g.clearRect(0,0,WIDTH,HEIGHT);
				
				g.drawImage(시작화면.getImage(), 0,0,  800, 800, this);
			}
	 }

	
	class StartListener implements MouseListener {
		public void actionPerformed(ActionEvent e) {

		}

		public void mouseClicked(MouseEvent e) {
			startButtonImage.setIcon(startButton);
			System.out.println("마우스 클릭");
			dispose();
			Thread t1 = new Thread(new DoubleBuffering());
			t1.start();
			//new DoubleBuffering();
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
			startButtonImage.setIcon(startButtonPressed);
		}

		public void mouseReleased(MouseEvent e) {
			/*	lp.setLayer(gamepanel, 5);
				m_timer.start();
				
				gamepanel.setFocusable(true);
				gamepanel.requestFocus();
				frame.repaint(); */
			}
		}
	//****************멀티 시작 리스너****************
	class MultiListener implements MouseListener {
		public void actionPerformed(ActionEvent e) {

		}

		public void mouseClicked(MouseEvent e) {


		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {

		}

		public void mouseReleased(MouseEvent e) {
		/*	lp.setLayer(multipanel, 7);				// scorePanel 이 앞으로 나오게 함



			multipanel.setFocusable(true);					// scorePanel이 포커싱될 수 있게 함
			multipanel.requestFocus();
			frame.repaint(); */
		}
	}
	class ScoreListener implements MouseListener {
		public void actionPerformed(ActionEvent e) {

		}

		public void mouseClicked(MouseEvent e) {


		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {

		}

		public void mouseReleased(MouseEvent e) {
		/*	lp.setLayer(scorepanel, 6);				// scorePanel 이 앞으로 나오게 함



			scorepanel.setFocusable(true);					// scorePanel이 포커싱될 수 있게 함
			scorepanel.requestFocus();
			frame.repaint(); */
		}
	}
	
    // 메인 함수
    public static void main(String[] args) {
        // 클래스 인스턴스 객체 선언
   	 	StartFrame sf= new StartFrame();
		sf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // DoubleBuffering db = new DoubleBuffering();
        // 쓰레드 실행
    }

}
