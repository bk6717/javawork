
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
// �׸��� ������� 200 , 12 
// �ٴ��� ����10px�� ��ġ      
// 1ĭ¥�� ��ֹ��� ���� 8px 
// ������ ���������  255,255,0 --> 16776960

// ��ֹ� �������
// 2����ֹ� 255.0.150== 16711830
// 3����ֹ� 255.0.255== 16711935
// �¾����� HIT
// �ǹ��� 255.100.0 ==16737280
// �̹��� �ֱ�
public class CookiRun extends JFrame {
	MyPanel panel;
	// ����̹���
	ImageIcon back = new ImageIcon("img/backTest.png");
	Image bg = back.getImage();
	//����̹���2
	ImageIcon back2 = new ImageIcon("img/back2.png");
	Image bg2 = back2.getImage();
	// �ٴ� ����
	ImageIcon ground = new ImageIcon("img/footTest.png");
	Image gr = ground.getImage();
	// ��Ű ����
	ImageIcon cookie = new ImageIcon("img/cookieTest.png");
	Image co = cookie.getImage();
	// �����̵� �̹���
	ImageIcon slide = new ImageIcon("img/slideTest.png");
	// 1�� ����
	ImageIcon jump1 = new ImageIcon("img/jumpTest.png");
	//2�� ���� 
	ImageIcon jump2 = new ImageIcon("img/doubleJumpTest.png");
	//�������� �̹���
	ImageIcon falling = new ImageIcon("img/fallTest.png");
	//�����̹���
	ImageIcon jelly1 = new ImageIcon("img/jellyTest.png");
	Image jel = jelly1.getImage();
	//���� ������ �̹���
	ImageIcon boom = new ImageIcon("img/effectTest.png");
	//��ֹ� �̹��� 1ĭ
	ImageIcon tacle = new ImageIcon("img/tacleTest10.png");
	//��ֹ� �̹��� 2ĭ
	ImageIcon tacle2 = new ImageIcon("img/tacleTest20.png");
	
	//���� ����Ʈ 
	List<Jelly> jellyList = new ArrayList<>();
	//���� ����Ʈ
	List<Field> fieldList = new ArrayList<>();
	//��ֹ� ����Ʈ
	List<Tacle> tacleList = new ArrayList<>();
	
	int[][] colorArr;  // x,y��ǥ�� ������ �����ϴ� 2���� �迭 
	int[] sizeArr; 	   // �̹����� ���̿� ���̸� �������� 1���� ��
	
	//���ȭ�� ��ǥ
	int bg1X1 = 0;
	int bg1X2 = bg.getWidth(null); // ���ȭ���� ���� 
	int bg2X1 = 0;
	int bg2X2 = bg2.getWidth(null);

	//ĳ���� ��ǥ
	int cookY = 20;
	int cookX = 160;

	//���ϰ� ���ߴ� ����
	int field = 400;
	//���������� Ȯ��
	boolean fall = false;
	// ���������� Ȯ��
	boolean jump = false;
	//���� ī��Ʈ (2�������Ҷ� ���)
	int doubleJump = 0; //2�� �Ǹ� ��������

	//����ð� ��������
	int nowField = 2000;
	static long getTime() {
		return Timestamp.valueOf(LocalDateTime.now()).getTime(); //1970.01.01 ���� �ʷ� ���
	}

	public CookiRun() {
		setTitle("��Ű��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false); // âũ�� �������ϰ��� 
		panel = new MyPanel();
		setContentPane(panel);
		setSize(800, 480);
		setVisible(true); 
	}

	class MyPanel extends JPanel {

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			//����̹���
			g.drawImage(bg, bg1X1, 0, null);
			g.drawImage(bg, bg1X2, 0, null);
			//����̹���2
//			g.drawImage(bg2, bg2X1, 0, null);
//			g.drawImage(bg2, bg2X2, 0, null);
			//�ٴ�
//			g.drawImage(gr, 0, 0, null);
//			g.drawImage(gr, 0, 0, null);
			//�����׸���
			for (int i = 0; i < jellyList.size(); i++) {
				Jelly tempJelly = jellyList.get(i); 
				g.drawImage(tempJelly.getImage(),tempJelly.getX(),tempJelly.getY(),tempJelly.getWidth(),tempJelly.getHeight(),null);
			}
			
			//���Ǳ׸���
			for (int i = 0; i < fieldList.size();i++) {
				Field tempField = fieldList.get(i);
				g.drawImage(tempField.getImage(), tempField.getX(), tempField.getY(), tempField.getWidth(), tempField.getHeight(), null);
			}
			
			//��ֹ� �׸���
			for (int i = 0; i < tacleList.size(); i++) {
				Tacle tempTacle = tacleList.get(i);
				g.drawImage(tempTacle.getImage(), tempTacle.getX(), tempTacle.getY(), tempTacle.getWidth(), tempTacle.getHeight(), null);
				
			}
			
			//ĳ���� 
			g.drawImage(co, cookX, cookY,  null);


		}// end of class Mypanel

		public MyPanel() {
			setFocusable(true);
			
			//�̹��� �ҷ�����
			try {
				sizeArr = Bf2.getSize("img/Map2.png");
				colorArr = Bf2.getPic("img/Map2.png");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			int maxX = sizeArr[0];
			int maxY = sizeArr[1];
			
			/////////////////////����Ʈ�� ��������Ʈ �߰�/////////////////////////
			for (int i = 0; i < maxX; i+=1) {
				for (int j = 0; j < maxY; j+=1) {
					if(colorArr[i][j] == 16776960) { // ����� 255.255.0
						jellyList.add(new Jelly(jelly1.getImage(), i*40 ,j*40 ,30 ,30 ,255, 0));
					}
				}
			}
			
			/////////////////////���Ǹ���Ʈ �߰�////////////////////////////
			for (int i = 0; i < maxX; i+=2) {
				for (int j = 0; j < maxY; j+=2) {
					if(colorArr[i][j] == 0) { //������
						fieldList.add(new Field(ground.getImage(), i*40 ,j*40 ,80 ,80));
					}
				}
			}
			
			//////////////////��ֹ�����Ʈ �߰�///////////////////////////
			for (int i = 0; i < maxX; i+=2) {
				for (int j = 0; j < maxY; j+=2) {
					//1ĭ ũ�� ��ֹ� 
					if(colorArr[i][j] == 16711680) { //������
						tacleList.add(new Tacle(tacle.getImage(), i*40 ,j*40 ,80 ,80));	
					//2ĭ ũ�� ��ֹ�
					}else if(colorArr[i][j] == 16711830) { // 255.0.150
						tacleList.add(new Tacle(tacle2.getImage(), i*40, j*40,80,80));
					}
				}
			}
			
			////////////////////�����̵� �̺�Ʈ/////////////////////
			addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_DOWN) { 

						if (co == cookie.getImage()) {
							co = slide.getImage();         
						}
					}

					////////////////////////���� �̺�Ʈ////////////////////
					if (e.getKeyCode() == KeyEvent.VK_SPACE && doubleJump < 2 ) { 
						new Thread(new Runnable() {
							@Override
							public void run() {
								doubleJump ++;
								
								int nowJump = doubleJump;
								
								// �߹ٴ��� ��ġ  
								int foot = cookY + co.getHeight(null);
									jump = true; //��������
								
									if(doubleJump == 1) { //�����̽� �ѹ������� 
										System.out.println("����");
										co = jump1.getImage();
										
									}if(doubleJump == 2) { // �������� 
										System.out.println("��������");
										co = jump2.getImage();
									}
																	
									long t1 = getTime();// ����ð��� �����´�.
									long t2;
									int set = 8; // ������ ����
									int jumpY = 1; // 0�� �ƴϸ�ȴ�.
									
									while (jumpY > 0) { // ���̰� 0���� Ŭ������
										t2 = getTime() - t1; // ����ð����� - t1
										jumpY = set - (int) ((t2) / 40);// Jump ����
										cookY = cookY - jumpY; // ��Ű�� jumpY ����ŭ �ö󰣴�.
										foot = cookY + co.getHeight(null); // ��Ű�� ����ġ  
										repaint();//�ٽ� �׸���
										
										if (nowJump != doubleJump) { // ������ �ѹ� ���Ǹ� ù��° ������ �����.
											break;
										}
										try {
											Thread.sleep(10);
										} catch (InterruptedException e) {
											e.printStackTrace();
										}
									}
									if(nowJump == doubleJump) { //2�������� �ϸ� �������� X
									jump = false;
									
									}
							}
						}).start();
					}
				}

				////////////////// Ű ������ ������� ���ƿ���/////////////////
				public void keyReleased(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_DOWN) { // ����Ű�Ʒ��� �����ٰ� ������
					if(co != cookie.getImage() && !fall && !jump) { //��Ű�� �����̹����� �ƴϰų� �������̳� �������� ���� �ƴҶ�
						co = cookie.getImage();
					}
				}
				}
			});
			////////////////// ���� ������//////////////////////////
			new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
						
						int foot = cookY + co.getHeight(null);
						//�߹ٴ��� ������ ���� ������ �۵�
						if (jump == false && foot < nowField && fall == false) {
							fall = true; // �������� ��
							System.out.println("����");
							co = falling.getImage();
							long t1 = getTime();
							long t2;
							int set = 1;
							
							if(foot < nowField && !jump && !fall) { // ���� ��ġ�� ������ �����ְ� , ������ �����������̾ƴҶ�
								fall = true;                        // ��������  
							}
							
							while (foot < nowField) { // �ٴڿ� ���������
								t2 = getTime() - t1; // ����ð����� -t1
								int fallY = set + (int) ((t2) / 40); // ���Ϸ�
								
//								if(foot + fallY >= nowField) {// �������� �� ����
//									cookY = nowField - cookie.getImage().getHeight(null);
//									break;
//								}else {
//									cookY = cookY + fallY; // y��  ���Ϸ� ���ϱ�
//								}
								if(foot + fallY >= nowField) {// �������� �� ����
									fallY = nowField - foot;
								}
								cookY = cookY + fallY; // y��  ���Ϸ� ���ϱ�
								
//								System.out.println(nowField);
								
								foot = cookY + co.getHeight(null);
								
								repaint();
								
								if(jump == true) { //�������� ���� ������ ��������
									break;
								}
								try {
									Thread.sleep(10);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							fall = false;
							if(jump == false) { //���� ���� ��� �������� �ƴҶ� 
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
						// ���ȭ�� �̵�
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
						//������ġ
						for (int i = 0; i < jellyList.size(); i++) {
							jellyList.get(i).setX(jellyList.get(i).getX()-4);
						}
						//������ġ
						for (int j = 0; j < fieldList.size(); j++) {
							fieldList.get(j).setX(fieldList.get(j).getX()-4);
						}
						//��ֹ� ��ġ
						for (int i = 0; i < tacleList.size(); i++) {
							tacleList.get(i).setX(tacleList.get(i).getX()-4);
						}
						
						List<Integer> countList = new ArrayList<>(); // ������ȿ� �ӽ������� ������ ����Ʈ
						
						
						int tempField; // ������ġ�� ��ĵ�ϴ� ����
						int tempNowField = 2000;; // nowField�� �������ִ� �ӽú���
					
						for (int i = 0; i < fieldList.size(); i++) {
							int tempX = fieldList.get(i).getX();   //������ x��
							if(tempX >= cookX-60 && tempX <= 240) { // ������  ��Ű�� ���� ���̶��
								
								tempField = fieldList.get(i).getY(); //������ Y��
								 //������ġ�� tempNowField���� �۰� , �ڹٴ��� ��ġ�� tempField ���� �ִٸ�.
								if(tempField < tempNowField && cookY + co.getHeight(null) <= tempField) {
									tempNowField = tempField;
								}
							}
						} nowField = tempNowField; // ����� nowfield�� ������Ʈ �Ѵ�.
						System.out.println(nowField);
						
						
						///////////////�����Ա�///////////////////////
						for (int j = 0; j < jellyList.size(); j++) {
							if(jellyList.get(j).getX() >= cookX 
								&&jellyList.get(j).getX() <= cookX + co.getWidth(null)
								&&jellyList.get(j).getY() >= cookY  
								&&jellyList.get(j).getY() <= cookY + co.getHeight(null)) {
								
								jellyList.get(j).setImage(boom.getImage());
//								jellyList.remove(j);  ������ ������ �����Ѵ�.
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
