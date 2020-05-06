
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
// 그림판 사이즈는 200 , 12 
// 바닥은 세로10px에 위치      
// 1칸짜리 장애물은 세로 8px 
// 젤리는 노란색으로  255,255,0 --> 16776960

// 장애물 더만들고
// 2단장애물 255.0.150== 16711830
// 3단장애물 255.0.255== 16711935
// 맞았을때 HIT
// 피물약 255.100.0 ==16737280
// 이미지 넣기
public class CookiRun extends JFrame {
	MyPanel panel;
	// 배경이미지
	ImageIcon back = new ImageIcon("img/backTest.png");
	Image bg = back.getImage();
	//배경이미지2
	ImageIcon back2 = new ImageIcon("img/back2.png");
	Image bg2 = back2.getImage();
	// 바닥 생성
	ImageIcon ground = new ImageIcon("img/footTest.png");
	Image gr = ground.getImage();
	// 쿠키 생성
	ImageIcon cookie = new ImageIcon("img/cookieTest.png");
	Image co = cookie.getImage();
	// 슬라이딩 이미지
	ImageIcon slide = new ImageIcon("img/slideTest.png");
	// 1단 점프
	ImageIcon jump1 = new ImageIcon("img/jumpTest.png");
	//2단 점프 
	ImageIcon jump2 = new ImageIcon("img/doubleJumpTest.png");
	//떨어지는 이미지
	ImageIcon falling = new ImageIcon("img/fallTest.png");
	//젤리이미지
	ImageIcon jelly1 = new ImageIcon("img/jellyTest.png");
	Image jel = jelly1.getImage();
	//젤리 터지는 이미지
	ImageIcon boom = new ImageIcon("img/effectTest.png");
	//장애물 이미지 1칸
	ImageIcon tacle = new ImageIcon("img/tacleTest10.png");
	//장애물 이미지 2칸
	ImageIcon tacle2 = new ImageIcon("img/tacleTest20.png");
	
	//젤리 리스트 
	List<Jelly> jellyList = new ArrayList<>();
	//발판 리스트
	List<Field> fieldList = new ArrayList<>();
	//장애물 리스트
	List<Tacle> tacleList = new ArrayList<>();
	
	int[][] colorArr;  // x,y좌표의 색값을 저장하는 2차원 배열 
	int[] sizeArr; 	   // 이미지의 넓이와 높이를 가져오는 1차원 배
	
	//배경화면 좌표
	int bg1X1 = 0;
	int bg1X2 = bg.getWidth(null); // 배경화면의 넓이 
	int bg2X1 = 0;
	int bg2X2 = bg2.getWidth(null);

	//캐릭터 좌표
	int cookY = 20;
	int cookX = 160;

	//낙하가 멈추는 지점
	int field = 400;
	//떨어지는지 확인
	boolean fall = false;
	// 점프중인지 확인
	boolean jump = false;
	//점프 카운트 (2단점프할때 사용)
	int doubleJump = 0; //2가 되면 더블점프

	//현재시간 가져오기
	int nowField = 2000;
	static long getTime() {
		return Timestamp.valueOf(LocalDateTime.now()).getTime(); //1970.01.01 부터 초로 계산
	}

	public CookiRun() {
		setTitle("쿠키런");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false); // 창크기 조절못하게함 
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
//			g.drawImage(bg2, bg2X1, 0, null);
//			g.drawImage(bg2, bg2X2, 0, null);
			//바닥
//			g.drawImage(gr, 0, 0, null);
//			g.drawImage(gr, 0, 0, null);
			//젤리그리기
			for (int i = 0; i < jellyList.size(); i++) {
				Jelly tempJelly = jellyList.get(i); 
				g.drawImage(tempJelly.getImage(),tempJelly.getX(),tempJelly.getY(),tempJelly.getWidth(),tempJelly.getHeight(),null);
			}
			
			//발판그리기
			for (int i = 0; i < fieldList.size();i++) {
				Field tempField = fieldList.get(i);
				g.drawImage(tempField.getImage(), tempField.getX(), tempField.getY(), tempField.getWidth(), tempField.getHeight(), null);
			}
			
			//장애물 그리기
			for (int i = 0; i < tacleList.size(); i++) {
				Tacle tempTacle = tacleList.get(i);
				g.drawImage(tempTacle.getImage(), tempTacle.getX(), tempTacle.getY(), tempTacle.getWidth(), tempTacle.getHeight(), null);
				
			}
			
			//캐릭터 
			g.drawImage(co, cookX, cookY,  null);


		}// end of class Mypanel

		public MyPanel() {
			setFocusable(true);
			
			//이미지 불러오기
			try {
				sizeArr = Bf2.getSize("img/Map2.png");
				colorArr = Bf2.getPic("img/Map2.png");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			int maxX = sizeArr[0];
			int maxY = sizeArr[1];
			
			/////////////////////리스트에 젤리리스트 추가/////////////////////////
			for (int i = 0; i < maxX; i+=1) {
				for (int j = 0; j < maxY; j+=1) {
					if(colorArr[i][j] == 16776960) { // 노란색 255.255.0
						jellyList.add(new Jelly(jelly1.getImage(), i*40 ,j*40 ,30 ,30 ,255, 0));
					}
				}
			}
			
			/////////////////////발판리스트 추가////////////////////////////
			for (int i = 0; i < maxX; i+=2) {
				for (int j = 0; j < maxY; j+=2) {
					if(colorArr[i][j] == 0) { //검은색
						fieldList.add(new Field(ground.getImage(), i*40 ,j*40 ,80 ,80));
					}
				}
			}
			
			//////////////////장애물리스트 추가///////////////////////////
			for (int i = 0; i < maxX; i+=2) {
				for (int j = 0; j < maxY; j+=2) {
					//1칸 크기 장애물 
					if(colorArr[i][j] == 16711680) { //빨강색
						tacleList.add(new Tacle(tacle.getImage(), i*40 ,j*40 ,80 ,80));	
					//2칸 크기 장애물
					}else if(colorArr[i][j] == 16711830) { // 255.0.150
						tacleList.add(new Tacle(tacle2.getImage(), i*40, j*40,80,80));
					}
				}
			}
			
			////////////////////슬라이딩 이벤트/////////////////////
			addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_DOWN) { 

						if (co == cookie.getImage()) {
							co = slide.getImage();         
						}
					}

					////////////////////////점프 이벤트////////////////////
					if (e.getKeyCode() == KeyEvent.VK_SPACE && doubleJump < 2 ) { 
						new Thread(new Runnable() {
							@Override
							public void run() {
								doubleJump ++;
								
								int nowJump = doubleJump;
								
								// 발바닥의 위치  
								int foot = cookY + co.getHeight(null);
									jump = true; //점프상태
								
									if(doubleJump == 1) { //스페이스 한번누를시 
										System.out.println("점프");
										co = jump1.getImage();
										
									}if(doubleJump == 2) { // 더블점프 
										System.out.println("더블점프");
										co = jump2.getImage();
									}
																	
									long t1 = getTime();// 현재시간을 가져온다.
									long t2;
									int set = 8; // 점프의 높이
									int jumpY = 1; // 0만 아니면된다.
									
									while (jumpY > 0) { // 높이가 0보다 클때까지
										t2 = getTime() - t1; // 현재시간에서 - t1
										jumpY = set - (int) ((t2) / 40);// Jump 세팅
										cookY = cookY - jumpY; // 쿠키가 jumpY 값만큼 올라간다.
										foot = cookY + co.getHeight(null); // 쿠키의 발위치  
										repaint();//다시 그리기
										
										if (nowJump != doubleJump) { // 점프가 한번 더되면 첫번째 점프는 멈춘다.
											break;
										}
										try {
											Thread.sleep(10);
										} catch (InterruptedException e) {
											e.printStackTrace();
										}
									}
									if(nowJump == doubleJump) { //2단점프를 하면 점프상태 X
									jump = false;
									
									}
							}
						}).start();
					}
				}

				////////////////// 키 뗏을때 원래대로 돌아오는/////////////////
				public void keyReleased(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_DOWN) { // 방향키아래를 눌럿다가 뗏을때
					if(co != cookie.getImage() && !fall && !jump) { //쿠키가 원래이미지가 아니거나 점프중이나 떨어지는 중이 아닐때
						co = cookie.getImage();
					}
				}
				}
			});
			////////////////// 낙하 스레드//////////////////////////
			new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
						
						int foot = cookY + co.getHeight(null);
						//발바닥이 땅보다 위에 있으면 작동
						if (jump == false && foot < nowField && fall == false) {
							fall = true; // 떨어지는 중
							System.out.println("낙하");
							co = falling.getImage();
							long t1 = getTime();
							long t2;
							int set = 1;
							
							if(foot < nowField && !jump && !fall) { // 발의 위치가 땅보다 위에있고 , 점프나 떨어지는중이아닐때
								fall = true;                        // 떨어진다  
							}
							
							while (foot < nowField) { // 바닥에 닿기전까지
								t2 = getTime() - t1; // 현재시간에서 -t1
								int fallY = set + (int) ((t2) / 40); // 낙하량
								
//								if(foot + fallY >= nowField) {// 떨어지는 양 보정
//									cookY = nowField - cookie.getImage().getHeight(null);
//									break;
//								}else {
//									cookY = cookY + fallY; // y에  낙하량 더하기
//								}
								if(foot + fallY >= nowField) {// 떨어지는 양 보정
									fallY = nowField - foot;
								}
								cookY = cookY + fallY; // y에  낙하량 더하기
								
//								System.out.println(nowField);
								
								foot = cookY + co.getHeight(null);
								
								repaint();
								
								if(jump == true) { //떨어지다 더블 점프시 낙하중지
									break;
								}
								try {
									Thread.sleep(10);
								} catch (InterruptedException e) {
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
						bg1X1 --;
						bg1X2 --;
						
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
						//발판위치
						for (int j = 0; j < fieldList.size(); j++) {
							fieldList.get(j).setX(fieldList.get(j).getX()-4);
						}
						//장애물 위치
						for (int i = 0; i < tacleList.size(); i++) {
							tacleList.get(i).setX(tacleList.get(i).getX()-4);
						}
						
						List<Integer> countList = new ArrayList<>(); // 스레드안에 임시적으로 선언한 리스트
						
						
						int tempField; // 발판위치를 스캔하는 변수
						int tempNowField = 2000;; // nowField를 세팅해주는 임시변수
					
						for (int i = 0; i < fieldList.size(); i++) {
							int tempX = fieldList.get(i).getX();   //발판의 x값
							if(tempX >= cookX-60 && tempX <= 240) { // 발판이  쿠키의 범위 안이라면
								
								tempField = fieldList.get(i).getY(); //발판의 Y값
								 //발판위치가 tempNowField보다 작고 , 박바닥의 위치가 tempField 위에 있다면.
								if(tempField < tempNowField && cookY + co.getHeight(null) <= tempField) {
									tempNowField = tempField;
								}
							}
						} nowField = tempNowField; // 결과를 nowfield에 업데이트 한다.
						System.out.println(nowField);
						
						
						///////////////젤리먹기///////////////////////
						for (int j = 0; j < jellyList.size(); j++) {
							if(jellyList.get(j).getX() >= cookX 
								&&jellyList.get(j).getX() <= cookX + co.getWidth(null)
								&&jellyList.get(j).getY() >= cookY  
								&&jellyList.get(j).getY() <= cookY + co.getHeight(null)) {
								
								jellyList.get(j).setImage(boom.getImage());
//								jellyList.remove(j);  닿으면 젤리를 삭제한다.
							}
						}
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
