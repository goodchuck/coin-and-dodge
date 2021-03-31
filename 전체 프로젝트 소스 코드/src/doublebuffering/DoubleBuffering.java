package doublebuffering;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Rectangle;
import java.io.InputStream;
import java.util.Random;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.Timer;


import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;


public class DoubleBuffering extends JFrame implements Runnable {
    
    // 캐릭터 위치, 점수, 더블 버퍼링, 이미지 변수, 마우스 변수, 승리 판정 변수 선언
	GamePanel  gamepanel=new GamePanel();
	enemy enemy = new enemy();
	
	
    int x=0, y=0, xDirection, yDirection, score = 0,  충카 = 0, 난이도 = 0;
    int 펀x,펀y;
    int 총알x,총알y;
    boolean xm, xp, ym, yp = false;
    int 충돌시간 = 0;
    int 속 = 0;
    //펀치 딜레이 변수 선언
    int 펀딜 = 0, 펀딜2 = 200, 총알날 = 0, 총알날2 = 300;
    int 속rectX , 속rectY;
    int[] rectX =  {0,0,0,0,0,0,0,0};
    int[] rectY =  {0,0,0,0,0,0,0,0};
    int[] 적rectX = {0,0,0,0,0,0,0,0};
    int[] 적rectY = {0,0,0,0,0,0,0,0}; 
    int times =0;
    int times2 = 0;
    int timescore = 0;
	int Hp=480; // 수정
	int times3 = 0;
    
    boolean mouseOnScreen;
    boolean won = false;
    boolean punch = false;
    boolean 총 = false;
    boolean 속2 = false;
    boolean 총알 = false;
    boolean 칼 = false;
    boolean 충돌 = false;
    boolean 피버 = false;

    
    Image dbImage;
    Graphics dbg;
	
	 // 이미지
	 ImageIcon StartImage = new  ImageIcon("src/IMAGE/시작배경화면.jpg");
	 ImageIcon BackImage = new  ImageIcon("src/IMAGE/배경화면.jpg" );
	 ImageIcon 시작화면 = new  ImageIcon("src/IMAGE/시작화면.jpg");
	 ImageIcon 난이도1 = new  ImageIcon("src/IMAGE/난이도1.jpg");
	 ImageIcon 난이도2 = new  ImageIcon("src/IMAGE/시작화면.jpg");
	
	// 버튼
	JButton startButtonImage = new JButton(new ImageIcon("src/IMAGE/시작버튼.jpg"));
	JButton optionButtonImage = new JButton(new ImageIcon("src/IMAGE/endbuttons2.png"));
	JButton multiImage = new JButton(new ImageIcon("src/IMAGE/캐릭터버튼.jpg"));
	JButton scoreImage = new JButton(new ImageIcon("src/IMAGE/게임시작버튼_보통.gif"));
	JButton mainmenu = new JButton("메뉴화면으로");
	
	//체력바
	ImageIcon Hpbar1 = new ImageIcon("src/IMAGE/HpBar_wh.png");
	ImageIcon Hpbar2 = new ImageIcon("src/IMAGE/HbBark.gif");
	
	//코인
	ImageIcon coin = new ImageIcon("src/IMAGE/coin.png");
	ImageIcon coin2 = new ImageIcon("src/IMAGE/coin.png");
	
	//주인공 캐릭
	ImageIcon face = new ImageIcon("src/IMAGE/face.png");
	ImageIcon colface = new ImageIcon("src/IMAGE/맞은face.png");
	
	//펀치
	ImageIcon 펀치왼 = new ImageIcon("src/IMAGE/펀치왼.jpg");
	ImageIcon 펀치오 = new ImageIcon("src/IMAGE/펀치오.jpg");
	ImageIcon 펀치아 = new ImageIcon("src/IMAGE/펀치아.jpg");
	ImageIcon 펀치위 = new ImageIcon("src/IMAGE/펀치위.jpg");
	
	//속도
	ImageIcon 속도 = new ImageIcon("src/IMAGE/속도.jpg");
	
	//총
	ImageIcon 총왼 = new ImageIcon("src/IMAGE/총왼.jpg");
	ImageIcon 총오 = new ImageIcon("src/IMAGE/총오.jpg");
	ImageIcon 총아 = new ImageIcon("src/IMAGE/총아.jpg");
	ImageIcon 총위 = new ImageIcon("src/IMAGE/총위.jpg");
	
	//총알
	ImageIcon 알 = new ImageIcon("src/IMAGE/총알.jpg");
	
	// 적군
	ImageIcon 적 = new ImageIcon("src/IMAGE/enemy.png");
    ImageIcon 적2 = new ImageIcon("src/IMAGE/적2.gif");
    ImageIcon 적3 = new ImageIcon("src/IMAGE/적3.png");
	
    // 기본적인 설정
    public final int WIDTH = 800;
    public final int HEIGHT = 800;
    public final int circleSize = 50; // 주인공 크기
    public final int rectSize = 32; // 코인 크기
    public final int 적rectSize = 50; // 적 크기
    public final Font font = new Font("맑은 고딕", Font.BOLD | Font.ITALIC, 30);

	public Timer m_timer = new Timer(5, new Clock());	
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


    public  DoubleBuffering() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
        // 캐릭터 및 장애물 초기 설정
        setX(WIDTH/2);
        setY(HEIGHT / 2);
        for(int i = 0; i <= 7; i++) {
        	rectX[i] = new Random().nextInt(WIDTH - rectSize);
        	rectY[i] = new Random().nextInt(HEIGHT - rectSize);
        	enemy.setErectX1(new Random().nextInt(WIDTH - 적rectSize));
        	enemy.setErectY1(new Random().nextInt(HEIGHT - 적rectSize));
        	//적rectX[i] = new Random().nextInt(WIDTH - 적rectSize);
            //적rectY[i] = new Random().nextInt(HEIGHT - 적rectSize);	
        }
        속rectX = new Random().nextInt(WIDTH - rectSize);
        속rectY = new Random().nextInt(HEIGHT - rectSize);
        
        m_timer.start();

		add(gamepanel);
		setTitle("코인 빨리 줍자!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setResizable(false); // 창 늘리기 가능/불가
		

        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new AL());
        gamepanel.addMouseListener(new MO());

    }

    // 쓰레드 실행 함수
    public void run() {
        try {
            while(true) {
                move();
                Thread.sleep(5);
            }
        }
        catch(Exception e) {
            System.out.println("오류가 발생했습니다.");
        }
    }
    // 실제로 캐릭터가 이동하는 함수
    public void move() {
        x += xDirection;
        y += yDirection;
        if(x <= 0)
            x = 0;
        if(x >= WIDTH - circleSize)
            x = WIDTH - circleSize;
        if(y <= circleSize)
            y = circleSize;
        if(y >= WIDTH - circleSize)
            y = WIDTH - circleSize;
    }
    
    // 방향 지정
    public void setXDirection(int xdir) {
        xDirection = xdir;
    }
    
    public void setYDirection(int ydir) {
        yDirection = ydir;
    }
    
    //게임 테스트를 위한 마우스 리스너
    public class MO extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            int xCoord = e.getX();
            int yCoord = e.getY();
            x = xCoord - circleSize / 2;
            y = yCoord - circleSize / 2;
            
        }
        @Override
        public void mouseReleased(MouseEvent e) {
            
        }
        @Override
        public void mouseEntered(MouseEvent e) {
            mouseOnScreen = true;
        }
        @Override
        public void mouseExited(MouseEvent e) {
            mouseOnScreen = false;
        }        
    }
    
	
    //캐릭을 움직이게하는 키 리스너
    public class AL implements KeyEventDispatcher {
        public boolean dispatchKeyEvent(KeyEvent e) {
            if(e.getID() == KeyEvent.KEY_PRESSED) {
                int keyCode = e.getKeyCode();
                if(keyCode == e.VK_LEFT)
                {
                    setXDirection(-3);
                    if(속2 == true)
                    {
                    	setXDirection(-5);
                    }
                }
                if(keyCode == e.VK_RIGHT)
                {
                    setXDirection(+3);
                    if(속2 == true)
                    {
                    	setXDirection(+5);
                    }
                }            
                if(keyCode == e.VK_UP)
                {
                    setYDirection(-3);
                    if(속2 == true)
                    {
                    	setYDirection(-5);
                    }
                }    
                if(keyCode == e.VK_DOWN)
                {
                    setYDirection(+3);
                    if(속2 == true)
                    {
                    	setYDirection(+5);
                    }
                }
                if(keyCode == e.VK_SPACE)
                {
                	punch = true;	
                }
                if(keyCode == e.VK_SHIFT)
                {
                	총 = true;
                }
            }
            if(e.getID() == KeyEvent.KEY_RELEASED) {
                int keyCode = e.getKeyCode();
                if(keyCode == e.VK_LEFT)
                {
                    setXDirection(0);
                }
                if(keyCode == e.VK_RIGHT)
                {
                    setXDirection(0);
                }            
                if(keyCode == e.VK_UP)
                {
                    setYDirection(0);
                }    
                if(keyCode == e.VK_DOWN)
                {
                    setYDirection(0);
                }
                if(keyCode == e.VK_SHIFT)
                {
                	총 = false;
                }
            }
            return false;
        }
    }
    
	public class Clock implements ActionListener{
	
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			times++;
			//System.out.println(times);
//******************* 체력 감소 ******************
			if(times % 100 == 0) {
	        	Hp -=5;
	        }
//******************* 체력 감소 ******************
	        // 적군이 주인공을 따라올수있도록
		        if(times % 10 == 0) {
			    	if(enemy.getErectX1() < x)
			    	{
			    			enemy.setErectX1(enemy.getErectX1()+3); 

			    			if(enemy.getErectY1()<y)
			    			{
			    				enemy.setErectY1(enemy.getErectY1()+3);
			    			} else if(enemy.getErectY1() > y) {
			    				enemy.setErectY1(enemy.getErectY1()-3);
			    			}
				    		/*if(적rectY[l] < y)
				    			적rectY[l] += 3;
				    		else if(적rectY[l] >y)
				    			적rectY[l] -= 3; */	
			    	/*	if(l==1) {
			    			적rectX[l] += 3;
				    		if(적rectY[l] < y)
				    			적rectY[l] += 3;
				    		else if(적rectY[l] >y)
				    			적rectY[l] -= 3;	
			    		} else if(l==2) {
			    			적rectX[l] += 4;
				    		if(적rectY[l] < y)
				    			적rectY[l] += 4;
				    		else if(적rectY[l] >y)
				    			적rectY[l] -= 4;	
			    		} else if(l==3) {
			    			적rectX[l] += 5;
				    		if(적rectY[l] < y)
				    			적rectY[l] += 5;
				    		else if(적rectY[l] >y)
				    			적rectY[l] -= 5;	
			    		} */
			    	} else if (enemy.getErectX1() >=x)
			    	{
				    		//적rectX[l] -=3;
			    			enemy.setErectX1(enemy.getErectX1()-3); 
				    	/*	if(적rectY[l] < y)
				    			적rectY[l] += 3;
				    		else if(적rectY[l] >y)
				    			적rectY[l] -= 3;	 */
			    			if(enemy.getErectY1()<y)
			    			{
			    				enemy.setErectY1(enemy.getErectY1()+3);
			    			} else if(enemy.getErectY1() > y) {
			    				enemy.setErectY1(enemy.getErectY1()-3);
			    			}
			    		}
			    	/*	if(l==1) {
				    		적rectX[l] -=3;
				    		if(적rectY[l] < y)
				    			적rectY[l] += 3;
				    		else if(적rectY[l] >y)
				    			적rectY[l] -= 3;	
			    		} else if(l==2) {
				    		적rectX[l] -=4;
				    		if(적rectY[l] < y)
				    			적rectY[l] += 4;
				    		else if(적rectY[l] >y)
				    			적rectY[l] -= 4;
			    		} else if(l==3) {
				    		적rectX[l] -=5;
				    		if(적rectY[l] < y)
				    			적rectY[l] += 5;
				    		else if(적rectY[l] >y)
				    			적rectY[l] -= 5;
			    		} */
			    	} 
//******************* 속도  관련 ******************
		        if(속2 == true && 속 == 0) {
		        	속 = times;
		        }
		        if(속 == times-500) {
		        		속2 = false;
		        		속 = 0;
		        		속rectX  = new Random().nextInt(800 - rectSize);
		        		속rectY  = new Random().nextInt(800 - rectSize-200) +300;
		        	}
//******************* 속도  관련 ******************
//******************* 충돌  관련 ******************
		        if(충돌 == true && 충돌시간 == 0) {
		        	충돌시간 = times;
		        }
		        if(충돌시간 == times-200) {
		        	충돌 = false;
		        	충돌시간 = 0;
		        }
//******************* 충돌  관련 ******************
//******************* 펀치  관련 ******************
		        if(punch == true && 펀딜 == 0) {
		        	펀딜 = times;
		        } if(펀딜 == times - 100) {
		        	punch = false;
		        	펀딜 = 0;
		        }
//******************* 펀치  관련 ******************
//******************* 피버  관련 ******************
   		        if (Hp <= 200 && Hp >= 50) {
   		        	피버 = true;
   		        } else {
   		        	피버 = false;
   		        }
//******************* 피버  관련 ******************
			}
		}
/*
    // 더블 버퍼링을 이용해 실제로 그리는 함수
    public void paint(Graphics g) {
        dbImage = createImage(WIDTH, HEIGHT);
        dbg = dbImage.getGraphics();
        paintComponent(dbg);

        dbg.drawImage(시작화면.getImage(), 0,0,  800, 800, this);
        dbg.drawImage(난이도1.getImage(), 0,0,  800, 800, this);
		dbg.drawImage(face.getImage(), x, y, 50,50, this);
		dbg.drawImage(coin2.getImage(), rectX[2], rectY[2], this);
		dbg.drawImage(Hpbar1.getImage(), 0, 50, 580, 50, this);
		dbg.drawImage(Hpbar2.getImage(), 87, 70, Hp, 15, this);
		dbg.drawImage(속도.getImage(),속rectX,속rectY,this);
		dbg.drawImage(coin.getImage(), rectX[1], rectY[1], this);	
		dbg.setFont(font);
		dbg.setColor(Color.WHITE);
		dbg.drawString("점수 : " + score + " 충돌 횟수 : " + 충카 + "현재 난이도 : "+ 난이도 +" 타이머 : " + times/100 + "초", 2, 62);

        g.drawImage(dbImage, 0, 0, this);
        
    }
    public void paintComponent(Graphics g) {
    	repaint();
    } */
    
//------------------------ 이클립스 게임 스타트 누를시 화면 ------------------------------------------------------------
	class GamePanel extends JPanel{
		public void paintComponent(Graphics g){
			//Graphics2D g2d = (Graphics2D) g;
			g.drawImage(시작화면.getImage(), 0,0,  800, 800, this);

			g.drawImage(난이도1.getImage(), 0,0,  800, 800, this);
			g.drawImage(face.getImage(), x, y, 50,50, this);
			g.drawImage(coin2.getImage(), rectX[2], rectY[2], this);
			g.drawImage(Hpbar1.getImage(), 0, 50, 580, 50, this);
			g.drawImage(Hpbar2.getImage(), 87, 70, Hp, 15, this);
			g.drawImage(속도.getImage(),속rectX,속rectY,this);
			g.drawImage(coin.getImage(), rectX[1], rectY[1], this);	
			g.setFont(font);
			g.setColor(Color.WHITE);
			g.drawString("점수 : " + score + " 충돌 횟수 : " + 충카 + "현재 난이도 : "+ 난이도 +" 타이머 : " + times/100 + "초", 2, 62);

	        //게임이 끝나지않앗을경우
	        if(won == false) {
	            repaint();
	        } if(won == true) {
	        	m_timer.stop();
	        }
	        //체력이 0보다 작아지면 게임 끝
	        	if(Hp <= 0) {
					//lp.setLayer(endpanel, 6);				// gamePanel 이 앞으로 나오게 함
					//endpanel.setFocusable(true);					// gamePanel이 포커싱될 수 있게 함
					//endpanel.requestFocus();
					won = true;
	        	} 

//-------------------------------------------------------- 적 관련 -------------------------------------------------------------	
	    	    // 기본 적
		     /*   for(int l = 0; l <=1 ; l++) {
				    //g.drawImage(적.getImage(), 적rectX[0], 적rectY[0], this);
				    //g.drawImage(적.getImage(), 적rectX[1], 적rectY[1], this);
		        	g.drawImage(enemy.적.getImage(), enemy.getErectX1(), enemy.getErectY1(), this);
		        if(적rectX[l] - circleSize < x && x < 적rectX[l] + rectSize && 적rectY[l] - circleSize < y && y < 적rectY[l] + rectSize)
		    {
		        충돌 = true;
		        Hp -= 10;
		        적rectX[l] = new Random().nextInt(800 - rectSize);
		        if(적rectX[l] <=400) {
			        적rectY[l] = 0;
		        } else {
		        	적rectY[l] = 800;
		        };
		        충카 ++;
		    } 
		        } */
	        	g.drawImage(enemy.적.getImage(), enemy.getErectX1(), enemy.getErectY1(), this);
	        	if(enemy.getErectX1() - circleSize < x && x < enemy.getErectX1() + circleSize && enemy.getErectY1() - circleSize < y
	        			&& y < enemy.getErectY1() + circleSize)
	        	{
	        		충돌 = true;
	        		Hp -= 10;
	        		enemy.setErectX1(new Random().nextInt(800-rectSize));
	        		enemy.setErectY1(new Random().nextInt(800-rectSize));
	        		/*if(enemy.getErectX1() <= 400) {
	        			enemy.setErectY1(0);
	        		} else {
	        			enemy.setErectY1(800);
	        		}; */
	        		충카 ++;
	        	}
//--------------------------------------- 난이도 1------------------------------------------------------------------------
		        if(score >= 10 || times >=1000)
		        {
		        	난이도 = 1;
		        	//적 생성
				    g.drawImage(적2.getImage(), 적rectX[2], 적rectY[2], this);
				    //적군이 주인공이랑 닿을때 조건문
			        if(적rectX[2] - circleSize < x && x < 적rectX[2] + rectSize && 적rectY[2] - circleSize < y && y < 적rectY[2] + rectSize)
				    {
			        	충돌 = true;
				        Hp -= 20;	
				        적rectX[2] = new Random().nextInt(800 - rectSize);
				        if(적rectX[2] <=400) {
					        적rectY[2] = 0;
				        } else {
				        	적rectY[2] = 800;
				        }
				        충카 ++;
				    }  
				   }
//--------------------------------------- 난이도 1 ------------------------------------------------------------------------		        
//--------------------------------------- 난이도 2 ------------------------------------------------------------------------
		        if(score >= 20 || times >=2000) {
		        	난이도 = 2;
		        	//적군 생성
				    g.drawImage(적3.getImage(), 적rectX[3], 적rectY[3], this);
				    //적군이 주인공이랑 닿을때
			        if(적rectX[3] - circleSize < x && x < 적rectX[3] + rectSize && 적rectY[3] - circleSize < y && y < 적rectY[3] + rectSize)
				    {
			        	충돌 = true;
				        Hp -= 30;
				        적rectX[3] = new Random().nextInt(800 - rectSize);
				        if(적rectX[3] <=400) {
					        적rectY[3] = 0;
				        } else {
				        	적rectY[3] = 800;
				        }
				        충카 ++;
				    } 
				    }
//--------------------------------------- 난이도 2 ------------------------------------------------------------------------
//-------------------------------------------------------- 적 관련 -------------------------------------------------------------	
//-----------------------------------------------------캐릭터랑 코인관련-----------------------------------------------------
		        for(int i = 0; i <= 7; i++) {
			        if(rectX[i] - circleSize < x && x < rectX[i] + rectSize && rectY[i] - circleSize < y && y < rectY[i] + rectSize)
			        {
			            score++;
			            rectX[i] = new Random().nextInt(800 - rectSize);
			            rectY[i] = new Random().nextInt(800 - rectSize);
			            if(rectY[i] <= 200) {
			            	rectY[i] = new Random().nextInt(800 - rectSize);	
			            }
			        } 
		        }
//-----------------------------------------------------캐릭터랑 코인관련-----------------------------------------------------
//-------------------------------------------------------- 속도 관련 -------------------------------------------------------------		        
		        // 속도 아이콘과 캐릭터 충돌 감지
		        if(속rectX  - circleSize < x && x < 속rectX  + rectSize && 속rectY  - circleSize < y && y < 속rectY  + rectSize)
		        {
		        	속2 = true;
		        	속rectX = 800;
		        	속rectY = 800;
		        }
		        // 속도 아이콘을 먹엇을경우 속2가 true가되고 그동안 속++가되어 타이머같은 역할을 수행 그리고 

//-------------------------------------------------------- 속도 관련 -------------------------------------------------------------
//-------------------------------------------------------- 충돌 관련 -------------------------------------------------------------
		        if(충돌 == true) {
		        	g.drawImage(colface.getImage(), x, y, this);	
		        }
//-------------------------------------------------------- 충돌 관련 -------------------------------------------------------------		        
//-------------------------------------------------------- 펀치 관련 -------------------------------------------------------------	        
	        //펀치 구현
	        if(punch == true)
	        {
	        	if(xDirection<0){
	        		g.drawImage(펀치왼.getImage(), x-40,y,this);
	        		repaint();
	        	}
	        	if(xDirection>0) {
		        	g.drawImage(펀치오.getImage(), x+40,y,this);
		        	repaint();
	        	}
	        	if(yDirection>0) {
		        	g.drawImage(펀치아.getImage(), x,y+40,this);
		        	repaint();
	        	}
	        	if(yDirection<0) {
		        	g.drawImage(펀치위.getImage(), x,y-40,this);
		        	repaint();
	        	}
        	}
	        
        	
        	//펀치를 맞았을때 밀릴수있게
	        for(int i = 0; i <=5; i++) {
	        //왼쪽으로 맞음
	        if(punch == true && (적rectX[i] - 50 < x) &&  x-100 < 적rectX[i] + 50 && 적rectY[i] - 50 < y && y < 적rectY[i] + 50 )
	        {
	        	적rectX[i] -= 100;
	        }
	        //오른쪽
	        if(punch == true && (적rectX[i] - 50 < x+100) &&  x < 적rectX[i] + 50 && 적rectY[i] - 50 < y && y< 적rectY[i] + 50 )
	        {
	        	적rectX[i] += 100;
	        }
	        //위
	        if(punch == true && (적rectX[i] - 50 < x) &&  x < 적rectX[i] + 50 && 적rectY[i] - 50 < y&& y-100< 적rectY[i] + 50 )
	        {
	        	적rectY[i] -= 100;
	        }
	        //아래
	        if(punch == true && (적rectX[i] - 50 < x) &&  x < 적rectX[i] + 50 && 적rectY[i] - 50 < y+100 && y< 적rectY[i] + 50 )
	        {
	        	적rectY[i] += 100;
	        }
	        }
//-------------------------------------------------------- 펀치 관련 -------------------------------------------------------------	       	
//-------------------------------------------------------- 총 관련 -------------------------------------------------------------	 
	        //총이 켜졌을경우
	        if(총 == true)
	        {
	        	if(xDirection<0){
	        		//왼쪽으로 총이 켜졌을 경우 왼쪽 총을 구현
	        		g.drawImage(총왼.getImage(), x-40,y,this);
	        		총알x = x-70;
	        		총알y = y;
	        		
	        		//총알이 왼쪽으로 날라갔음을 알려주는 boolean
	        		xm = true;
	        		// 총알을 그림
	        		총알 = true;
	        	}
	        	if(xDirection>0) {
		        	g.drawImage(총오.getImage(), x+40,y,this);
	        		총알x = x+70;
	        		총알y = y;
	        		xp = true;
	        		총알 = true;
	        	}
	        	if(yDirection>0) {
		        	g.drawImage(총아.getImage(), x,y+40,this);
	        		총알x = x;
	        		총알y = y+70;
	        		yp = true;
	        		총알 = true;
	        	}
	        	if(yDirection<0) {
		        	g.drawImage(총위.getImage(), x,y-40,this);
	        		총알x = x;
	        		총알y = y-70;
	        		ym = true;
	        		총알 = true;
	        	
	        	}
	        }
	        
	        //왼쪽 총알 발사
    		if(xm == true) {
    			총알x -= 2; 	//총알이 이동하는 좌표
    			g.drawImage(알.getImage(), 총알x, 총알y, this);	 			
    			//총알x가 게임의 좌표를 벗어나거나 총알이 적이 닿았을때 조건문 수행
    			if(총알x <= 0 || 총알 == false) {
    				//총알들을 다시 쓸수 있게 세팅
    				xm = false;	
    			}
    		}
    		if(xp == true) {
        		총알x += 2;
    			g.drawImage(알.getImage(), 총알x, 총알y, this);	
        		if(총알x >= 800 || 총알 == false) {
    				xp = false;
        			}
        		}
    		if(yp == true) {
        		총알y += 2;
    			g.drawImage(알.getImage(), 총알x, 총알y, this);	
        		if(총알y >= 800 || 총알 == false) {
    				yp = false;
        			}
        		}
    		if(ym == true) {
        		총알y -= 2;
    			g.drawImage(알.getImage(), 총알x, 총알y, this);	
        		if(총알y <= 0 || 총알 == false) {
    				ym = false;
        			}
        		}
	        
	        //총을 맞았을때 적이 사라짐
	        for(int j = 0; j <=5; j++) {
	        //왼쪽으로 총 맞음
	        if(총알 == true &&(적rectX[j] - 50 < 총알x) &&  총알x < 적rectX[j] + 50 && 적rectY[j] - 50 < 총알y && 총알y < 적rectY[j] + 50 )
	        {
		        if(적rectX[j] <=400) {
			        적rectY[j] = 0;
		        } else {
		        	적rectY[j] = 800;
		        }
		        총알 =false;
	        }
	        //오른쪽
	        if(총알 == true &&(적rectX[j] - 50 < 총알x) &&  총알x < 적rectX[j] + 50 && 적rectY[j] - 50 < 총알y && 총알y< 적rectY[j] + 50 )
	        {
		        적rectX[j] = new Random().nextInt(800 - rectSize);
		        if(적rectX[j] <=400) {
			        적rectY[j] = 0;
		        } else {
		        	적rectY[j] = 800;
		        }
		        총알 = false;
	        }
	        //위
	        if(총알 == true &&(적rectX[j] - 50 < 총알x) &&  총알x < 적rectX[j] + 50 && 적rectY[j] - 50 < 총알y&& 총알y< 적rectY[j] + 50 )
	        {
		        if(적rectX[j] <=400) {
			        적rectY[j] = 0;
		        } else {
		        	적rectY[j] = 800;
		        }
		        총알 = false;
	        }
	        //아래
	        if(총알 == true &&(적rectX[j] - 50 < 총알x) &&  총알x < 적rectX[j] + 50 && 적rectY[j] - 50 < 총알y && 총알y< 적rectY[j] + 50 )
	        {
		        if(적rectX[j] <=400) {
			        적rectY[j] = 0;
		        } else {
		        	적rectY[j] = 800;
		        }
		        총알 = false;
	        }
	        }
	        // 피버타임 구현
			if  (Hp <= 200 && Hp >= 50 && 피버 == true) { //체력이 일정 수준 이하로 떨어졌을 시 발동
	        	g.drawImage(coin2.getImage(), rectX[0], rectY[0], this);
	        	g.drawImage(coin2.getImage(), rectX[3], rectY[3], this);
	        	g.drawImage(coin2.getImage(), rectX[4], rectY[4], this);
	        	g.drawImage(coin2.getImage(), rectX[5], rectY[5], this);
	        	g.drawImage(coin2.getImage(), rectX[6], rectY[6], this);
	        	g.drawImage(coin2.getImage(), rectX[7], rectY[7], this);
	        	속2 = true;   // 코인 생성 4배 + 속도 증가
	        	g.drawString("FEVER TIME!!!", 300, 700);
	        } else {
	        	
	        }
		}
	}
//-------------------------------------------------------- 총 관련 -------------------------------------------------------------




	}
	