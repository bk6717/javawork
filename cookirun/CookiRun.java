package cookirun;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDateTime;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.json.simple.ItemList;

import oracle.net.aso.l;

public class CookiRun extends JFrame {
	MyPanel panel;
	// 배경이미지
	ImageIcon back = new ImageIcon("img/123.png");
	Image bg = back.getImage();
	//배경이미지2
	ImageIcon back2 = new ImageIcon("img/back2.png");
	Image bg2 = back2.getImage();
	// 바닥 생성
	ImageIcon ground = new ImageIcon("img/ground.png");
	Image gr = ground.getImage();
	// 쿠키 생성
	ImageIcon cookie = new ImageIcon("img/run.gif");
	Image co = cookie.getImage();
	// 슬라이딩 이미지
	ImageIcon slide = new ImageIcon("img/slide.gif");
	// 1단 점프
	ImageIcon jump1 = new ImageIcon("img/jump1.png");
	//2단 점프 
	ImageIcon jump2 = new ImageIcon("img/jump2.gif");
	//젤리이미지
	ImageIcon jelly1 = new ImageIcon("img/item.png");
	Image jel = jelly1.getImage();
	//젤리 터지는 이미지
	ImageIcon boom = new ImageIcon("img/boom.gif");
	//몬스터 이미지
	ImageIcon monster = new ImageIcon("img/pa.png");
	
	//젤리 리스트와 
	List<Jelly> jellyList = new ArrayList<>();
	//장애물
	List<Monster> monsters = new ArrayList<>();
	
	int[][] colorArr;  //x,y좌표의 색값을 저장하는 2차원 배열 
	int[] sizeArr; 	   // 이미지의 넓이와 높이를 가져오는 1차원 배
	
	// 배경화면 움직이게
	int bg1X1 = 0;
	int bg1X2 = bg.getWidth(null);
	int bg2X1 = 0;
	int bg2X2 = bg2.getWidth(null);
	// 캐릭터 좌표
	int cookY = -150;
	int cookX = 20;
	// 낙하가 멈추는 지점
	int field = 310;
	// 떨어지는지 확인
	boolean fall = false;
	// 점프중인지 확인
	boolean jump = false;
	//점프 카운트
	int doubleJump = 0; //2가 되면 더블점프
	// 현재시간 가져오기
	static long getTime() {
		return Timestamp.valueOf(LocalDateTime.now()).getTime();
	}

	
	public CookiRun() {
		setTitle("쿠키런");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setResizable(false);
		panel = new MyPanel();
		setContentPane(panel);
		setSize(800, 480);
		setVisible(true);
	}

	class MyPanel extends JPanel {

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			//배경이미지
			g.drawImage(bg, bg1X1, 0, null);
			g.drawImage(bg, bg1X2, 0, null);
			//배경이미지2
			g.drawImage(bg2, bg2X1, 0, null);
			g.drawImage(bg2, bg2X2, 0, null);
			//바닥
			g.drawImage(gr, bg1X1, 0, null);
			g.drawImage(gr, bg1X2, 0, null);
			//젤리그리기
			for (int i = 0; i < jellyList.size(); i++) {
				Jelly tempJelly = jellyList.get(i);
				g.drawImage(tempJelly.getImage(),tempJelly.getX(),tempJelly.getY(),tempJelly.getWidth(),tempJelly.getHeight(),null);
			}
		
			//캐릭터 
			g.drawImage(co, cookX, cookY,  null);


		}// end of class Mypanel

		public MyPanel() {
			setFocusable(true);
			//이미지 불러오기
			try {
				sizeArr = Bf2.getSize("img/haha.png");
				colorArr = Bf2.getPic("img/haha.png");
			} catch (Exception e) {
				e.printStackTrace();
			}
			int maxX = sizeArr[0];
			int maxY = sizeArr[1];
			/////////리스트에 젤리리스트 추가 ///////////
			for (int i = 0; i < maxX; i+=1) {
				for (int j = 0; j < maxY; j+=1) {
					if(colorArr[i][j] == 16776960) {
						jellyList.add(new Jelly(jelly1.getImage(), i*40 ,j*40 ,30 ,30 ,255, 0));
					}
				}
			}
		
			//////////////// 슬라이딩 이벤트////////////////
			addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_DOWN) {

						if (co == cookie.getImage()) {
							co = slide.getImage();
						}
					}

					/////////////////// 점프 이벤트//////////////////
					if (e.getKeyCode() == KeyEvent.VK_SPACE && doubleJump < 2 ) {
						new Thread(new Runnable() {
							@Override
							public void run() {
								doubleJump ++;
								
								int nowJump = doubleJump;
								// 발바닥의 위치
								int foot = cookY + co.getHeight(null);

								
									jump = true;
								
									if(doubleJump == 1) {
										System.out.println("점프");
										co = jump1.getImage();
										
									}if(doubleJump == 2) {
										System.out.println("더블점프");
										co = jump2.getImage();
									}
									
								
									long t1 = getTime();// 현재시간을 가져온다.
									long t2;
									int set = 8; //
									int jumpY = 1; // 1로만 설정하면된다
									while (jumpY > 0) { // 높이가 0보다 클때까지
										t2 = getTime() - t1; // 현재시간에서 - t1
										jumpY = set - (int) ((t2) / 40);// Jump 세팅
										cookY = cookY - jumpY; // 이미지 Y값 변경
										foot = cookY + co.getHeight(null);
										repaint();
										
										if (nowJump != doubleJump) { // 점프가 한번 더되면 첫번째 점프는 멈춘다.
											break;
										}
										try {
											Thread.sleep(10);
										} catch (InterruptedException e) {
											e.printStackTrace();
										}
									}
									if(nowJump == doubleJump) {
									jump = false;
									
									}
							}
						}).start();
					}
				}

				////////////////// 키 뗏을때 원래대로 돌아오는/////////////////
				public void keyReleased(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					if(co != cookie.getImage() && !fall && !jump) {
						co = cookie.getImage();
					}
				}
				}
			});
			////////////////// 낙하하는//////////////////////////
			new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
						
						int foot = cookY + co.getHeight(null);
						//발바닥이 땅보다 위에 있으면 작동
						if (jump == false && foot < field && fall == false) {
							fall = true; // 떨어지는 중
							System.out.println("낙하");
							long t1 = getTime();
							long t2;
							int set = 1;

							while (foot < field) { // 바닥에 닿기전까지
								t2 = getTime() - t1; // 현재시간에서 -t1
								int fallY = set + (int) ((t2) / 60); // 낙하량
								
								if(foot + fallY >= field) {// 떨어지는 양 보정
									cookY = field - cookie.getImage().getHeight(null);
									break;
								}else {
									cookY = cookY + fallY; // y에  낙하량 더하기
								}
								
								foot = cookY + co.getHeight(null);
								repaint();
								
								if(jump == true) { //떨어지다 더블 점프시 낙하중지
									break;
								}
								try {
									Thread.sleep(10);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							fall = false;
							if(jump == false) { //발이 땅에 닿고 점프중이 아닐때 
								doubleJump = 0;
								co = cookie.getImage();
							}
						}
						try {
							Thread.sleep(10);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}).start();

			new Thread(new Runnable() {

				public void run() {
					while (true) {
						// 배경화면 이동
						bg1X1--;
						bg1X2--;
						
						bg2X1--;
						bg2X2--;
						if (bg1X1 < -(bg.getWidth(null))) {
							bg1X1 = bg.getWidth(null) - 1;
						}
						if (bg1X2 < -(bg.getWidth(null))) {
							bg1X2 = bg.getWidth(null) - 1;
						}
						if (bg2X1 < -(bg2.getWidth(null))) {
							bg2X1 = bg2.getWidth(null) - 1;
						}
						if (bg2X2 < -(bg2.getWidth(null))) {
							bg2X2 = bg2.getWidth(null) - 1;
						}
						//젤리위치
						for (int i = 0; i < jellyList.size(); i++) {
							jellyList.get(i).setX(jellyList.get(i).getX()-4);
						}
					
						//이미지 먹기
						for (int j = 0; j < jellyList.size(); j++) {
							if(jellyList.get(j).getX() > cookX
								&&jellyList.get(j).getX() < cookX + 200 
								&&jellyList.get(j).getY() > cookY + 220
								&&jellyList.get(j).getY() < cookY + co.getHeight(null)) {
								
								jellyList.get(j).setImage(boom.getImage());
//								jellyList.remove(j);
							}
						}
						 //캐릭터가 서있을 수 있는 위치
						List<Integer> countList = new ArrayList<>();
						
						int tempField; //
						repaint();
						try {
							Thread.sleep(10);
						} catch (Exception e) {
							e.printStackTrace();
						}

					}
				}
			}).start();

		}
	}

	public static void main(String[] args) {
		new CookiRun();
	}
}
