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
	// ����̹���
	ImageIcon back = new ImageIcon("img/123.png");
	Image bg = back.getImage();
	//����̹���2
	ImageIcon back2 = new ImageIcon("img/back2.png");
	Image bg2 = back2.getImage();
	// �ٴ� ����
	ImageIcon ground = new ImageIcon("img/ground.png");
	Image gr = ground.getImage();
	// ��Ű ����
	ImageIcon cookie = new ImageIcon("img/run.gif");
	Image co = cookie.getImage();
	// �����̵� �̹���
	ImageIcon slide = new ImageIcon("img/slide.gif");
	// 1�� ����
	ImageIcon jump1 = new ImageIcon("img/jump1.png");
	//2�� ���� 
	ImageIcon jump2 = new ImageIcon("img/jump2.gif");
	//�����̹���
	ImageIcon jelly1 = new ImageIcon("img/item.png");
	Image jel = jelly1.getImage();
	//���� ������ �̹���
	ImageIcon boom = new ImageIcon("img/boom.gif");
	//���� �̹���
	ImageIcon monster = new ImageIcon("img/pa.png");
	
	//���� ����Ʈ�� 
	List<Jelly> jellyList = new ArrayList<>();
	//��ֹ�
	List<Monster> monsters = new ArrayList<>();
	
	int[][] colorArr;  //x,y��ǥ�� ������ �����ϴ� 2���� �迭 
	int[] sizeArr; 	   // �̹����� ���̿� ���̸� �������� 1���� ��
	
	// ���ȭ�� �����̰�
	int bg1X1 = 0;
	int bg1X2 = bg.getWidth(null);
	int bg2X1 = 0;
	int bg2X2 = bg2.getWidth(null);
	// ĳ���� ��ǥ
	int cookY = -150;
	int cookX = 20;
	// ���ϰ� ���ߴ� ����
	int field = 310;
	// ���������� Ȯ��
	boolean fall = false;
	// ���������� Ȯ��
	boolean jump = false;
	//���� ī��Ʈ
	int doubleJump = 0; //2�� �Ǹ� ��������
	// ����ð� ��������
	static long getTime() {
		return Timestamp.valueOf(LocalDateTime.now()).getTime();
	}

	
	public CookiRun() {
		setTitle("��Ű��");
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
			//����̹���
			g.drawImage(bg, bg1X1, 0, null);
			g.drawImage(bg, bg1X2, 0, null);
			//����̹���2
			g.drawImage(bg2, bg2X1, 0, null);
			g.drawImage(bg2, bg2X2, 0, null);
			//�ٴ�
			g.drawImage(gr, bg1X1, 0, null);
			g.drawImage(gr, bg1X2, 0, null);
			//�����׸���
			for (int i = 0; i < jellyList.size(); i++) {
				Jelly tempJelly = jellyList.get(i);
				g.drawImage(tempJelly.getImage(),tempJelly.getX(),tempJelly.getY(),tempJelly.getWidth(),tempJelly.getHeight(),null);
			}
		
			//ĳ���� 
			g.drawImage(co, cookX, cookY,  null);


		}// end of class Mypanel

		public MyPanel() {
			setFocusable(true);
			//�̹��� �ҷ�����
			try {
				sizeArr = Bf2.getSize("img/haha.png");
				colorArr = Bf2.getPic("img/haha.png");
			} catch (Exception e) {
				e.printStackTrace();
			}
			int maxX = sizeArr[0];
			int maxY = sizeArr[1];
			/////////����Ʈ�� ��������Ʈ �߰� ///////////
			for (int i = 0; i < maxX; i+=1) {
				for (int j = 0; j < maxY; j+=1) {
					if(colorArr[i][j] == 16776960) {
						jellyList.add(new Jelly(jelly1.getImage(), i*40 ,j*40 ,30 ,30 ,255, 0));
					}
				}
			}
		
			//////////////// �����̵� �̺�Ʈ////////////////
			addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_DOWN) {

						if (co == cookie.getImage()) {
							co = slide.getImage();
						}
					}

					/////////////////// ���� �̺�Ʈ//////////////////
					if (e.getKeyCode() == KeyEvent.VK_SPACE && doubleJump < 2 ) {
						new Thread(new Runnable() {
							@Override
							public void run() {
								doubleJump ++;
								
								int nowJump = doubleJump;
								// �߹ٴ��� ��ġ
								int foot = cookY + co.getHeight(null);

								
									jump = true;
								
									if(doubleJump == 1) {
										System.out.println("����");
										co = jump1.getImage();
										
									}if(doubleJump == 2) {
										System.out.println("��������");
										co = jump2.getImage();
									}
									
								
									long t1 = getTime();// ����ð��� �����´�.
									long t2;
									int set = 8; //
									int jumpY = 1; // 1�θ� �����ϸ�ȴ�
									while (jumpY > 0) { // ���̰� 0���� Ŭ������
										t2 = getTime() - t1; // ����ð����� - t1
										jumpY = set - (int) ((t2) / 40);// Jump ����
										cookY = cookY - jumpY; // �̹��� Y�� ����
										foot = cookY + co.getHeight(null);
										repaint();
										
										if (nowJump != doubleJump) { // ������ �ѹ� ���Ǹ� ù��° ������ �����.
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

				////////////////// Ű ������ ������� ���ƿ���/////////////////
				public void keyReleased(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					if(co != cookie.getImage() && !fall && !jump) {
						co = cookie.getImage();
					}
				}
				}
			});
			////////////////// �����ϴ�//////////////////////////
			new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
						
						int foot = cookY + co.getHeight(null);
						//�߹ٴ��� ������ ���� ������ �۵�
						if (jump == false && foot < field && fall == false) {
							fall = true; // �������� ��
							System.out.println("����");
							long t1 = getTime();
							long t2;
							int set = 1;

							while (foot < field) { // �ٴڿ� ���������
								t2 = getTime() - t1; // ����ð����� -t1
								int fallY = set + (int) ((t2) / 60); // ���Ϸ�
								
								if(foot + fallY >= field) {// �������� �� ����
									cookY = field - cookie.getImage().getHeight(null);
									break;
								}else {
									cookY = cookY + fallY; // y��  ���Ϸ� ���ϱ�
								}
								
								foot = cookY + co.getHeight(null);
								repaint();
								
								if(jump == true) { //�������� ���� ������ ��������
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
						//������ġ
						for (int i = 0; i < jellyList.size(); i++) {
							jellyList.get(i).setX(jellyList.get(i).getX()-4);
						}
					
						//�̹��� �Ա�
						for (int j = 0; j < jellyList.size(); j++) {
							if(jellyList.get(j).getX() > cookX
								&&jellyList.get(j).getX() < cookX + 200 
								&&jellyList.get(j).getY() > cookY + 220
								&&jellyList.get(j).getY() < cookY + co.getHeight(null)) {
								
								jellyList.get(j).setImage(boom.getImage());
//								jellyList.remove(j);
							}
						}
						 //ĳ���Ͱ� ������ �� �ִ� ��ġ
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
