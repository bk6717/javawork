package CookieRun;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CookieRun {
	private JFrame frame;

	JPanel panel; // �г�
	Button escButton;
	// ��� �̹��� ����
	private ImageIcon back = new ImageIcon("img/backTest.png"); // ���� �޹��
	private ImageIcon back2 = new ImageIcon(); // �ι�° ���

	// ��Ű �̹���
	private ImageIcon cookie = new ImageIcon("img/cookieTest.png"); // �⺻
	private ImageIcon jump = new ImageIcon("img/jumpTest.png"); // �������
	private ImageIcon jump2 = new ImageIcon("img/doubleJumpTest.png"); // ��������
	private ImageIcon slide = new ImageIcon("img/slideTest.png"); // �����̵�
	private ImageIcon fall = new ImageIcon("img/fallTest.png"); // �������� ���
	private ImageIcon hit = new ImageIcon("img/hitTest.png"); // �¾��������

	// ���� �̹���
	private ImageIcon jelly1 = new ImageIcon("img/jellyTest.png"); // �⺻����1
	private ImageIcon jelly2 = new ImageIcon(); // �⺻����2
	private ImageIcon jelly3 = new ImageIcon(); // �⺻����3
	private ImageIcon jellyHp = new ImageIcon(); // �⺻����3

	private ImageIcon jellyeffect = new ImageIcon("img/effectTest.png"); // ���� ������

	// �����̹���
	private ImageIcon field1 = new ImageIcon("img/footTest.png"); // ����
	private ImageIcon field2 = new ImageIcon("img/footTest2.png"); // ���߹���

	// ��ֹ� �̹��� ������
	private ImageIcon tacle1 = new ImageIcon("img/tacleTest10.png"); // 1ĭ��ֹ�
	private ImageIcon tacle2 = new ImageIcon("img/tacleTest20.png"); // 2ĭ��ֹ�
	private ImageIcon tacle3 = new ImageIcon("img/tacleTest30.png"); // 3ĭ��ֹ�
	private ImageIcon tacle4 = new ImageIcon("img/tacleTest35.png"); // 4ĭ��ֹ�

	private List<Jelly> jellyList = new ArrayList<>();
	private List<Field> fieldList = new ArrayList<>();
	private List<Tacle> tacleList = new ArrayList<>();

	private int runPage = 0; // �̵��Ҷ����� ü���� ������� ����
	private int runStage = 1; // ���������� Ȯ���ϴ� ����
	private int resultScore = 0; // ��������� �����ϴ� ����
	private int gameSpeed = 3; // ���Ӽӵ�
	private int nowField = 2000; // ���� ���� ����.

	private boolean esckeyOn = false; // �Ͻ������� ���� Ű Ȯ��
	private boolean downkeyOn = false; // �ٿ�Ű �������� ����

	int face; // ��Ű�� ����
	int foot; // ��Ű�� ��

	// �̹��� ���Ϸ� �� ���� �����´�.
	private int[] sizeArr; // �̹��� ���̿� ���̸� �������� 1�����迭
	private int[][] colorArr; // x,y ��ǥ�� �ȼ� ������ �����ϴ� 2�����迭

	private Image buffImage; // ������� �̹���
	private Graphics buffg; // ������� g

	private AlphaComposite alphaComposite; // ���� ����

	Cookie c1; // ��Ű������Ʈ
	Back b11; // ��� 1-1
	Back b12;

	class MyPanel extends JPanel {

		public MyPanel() {
			setFocusable(true); // ���콺 �������� �켱��
			// ��Ű �ν��Ͻ� ���� / �⺻�ڷ�� Ŭ�����ȿ� ����� �־ �̹����� �ִ´�.
			c1 = new Cookie(cookie.getImage());

			// ��Ű�� ���� ��ġ / ��Ű x���� ���̸� ���Ѱ�
			face = c1.getX() + c1.getWidth();

			// ��Ű�� �߹���ġ
			foot = c1.getY() + c1.getHeight();

			// ��� 1-1 �ν��Ͻ� ����
			b11 = new Back(back.getImage(),0,0,back.getImage().getWidth(null), back.getImage().getHeight(null));
			// ��� 1-2 �ν��Ͻ� ����
			b12 = new Back(back.getImage(), back.getImage().getWidth(null),0,
					back.getImage().getWidth(null),back.getImage().getHeight(null));

			// �� ���� �ҷ�����
			try {
				sizeArr = Util.getSize("img/firstMap1.png");
				colorArr = Util.getPic("img/firstMap1.png");
			} catch (Exception e) {
				e.printStackTrace();
			}
			int maxX = sizeArr[0];
			int maxY = sizeArr[1];

			//////////////////// ������ü ����//////////////////////////////
			for (int i = 0; i < maxX; i++) {
				for (int j = 0; j < maxY; j++) {
					if (colorArr[i][j] == 16776960) { // �⺻����
						jellyList.add(new Jelly(jelly1.getImage(), i * 40, j * 40, 30, 30, 1234));
					} else if (colorArr[i][j] == 13158400) { // �⺻����
						jellyList.add(new Jelly(jelly2.getImage(), i * 40, j * 40, 30, 30, 2345));
					} else if (colorArr[i][j] == 9868800) { // �⺻����
						jellyList.add(new Jelly(jelly3.getImage(), i * 40, j * 40, 30, 30, 3456));
					} else if (colorArr[i][j] == 16737288) { // �⺻����
						jellyList.add(new Jelly(jellyHp.getImage(), i * 40, j * 40, 30, 30, 4567));
					}
				}
			}
			//////////////////////// ���ǰ�ü ����/////////////////////////////////
			for (int i = 0; i < maxX; i += 2) {
				for (int j = 0; j < maxY; j += 2) {
					if (colorArr[i][j] == 0) {
						fieldList.add(new Field(field1.getImage(), i * 40, j * 40, 80, 80));
					} else if (colorArr[i][j] == 6579300) {
						fieldList.add(new Field(field2.getImage(), i * 40, j * 40, 80, 80));
					}
				}
			}
			////////////////////// ��ֹ� ��ü ����///////////////////////////////
			for (int i = 0; i < maxX; i++) {
				for (int j = 0; j < maxY; j++) {
					if (colorArr[i][j] == 16711680) {
						tacleList.add(new Tacle(tacle1.getImage(), i * 40, j * 40, 80, 80, 0));
					} else if (colorArr[i][j] == 16711680) {
						tacleList.add(new Tacle(tacle2.getImage(), i * 40, j * 40, 80, 80, 0));
					} else if (colorArr[i][j] == 16711680) {
						tacleList.add(new Tacle(tacle3.getImage(), i * 40, j * 40, 80, 80, 0));
					}
				}
			}
			new Thread(new Runnable() {

				@Override
				public void run() {
					while (true) {
						repaint();

						if (esckeyOn) {
							while (esckeyOn) {
								try {
									Thread.sleep(10);
								} catch (Exception e2) {
									e2.printStackTrace();
								}
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
			
			mapMove(); // ��� ���� ��ֹ� �۵� �ż���
			
			fall(); // ���� ������ �ߵ� �޼���
			
			addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_ESCAPE) { // �����̽�Ű �̺�Ʈ
						if(!esckeyOn) {
							esckeyOn = true;
							add(escButton);
							repaint();
						}else {
							remove(escButton);
							esckeyOn = false;
						}
					}
					if(!esckeyOn) {
						if(e.getKeyCode() == KeyEvent.VK_SPACE && c1.getCountJump()<2) {
							jump();
						}
						if(e.getKeyCode() == KeyEvent.VK_DOWN) {
							downkeyOn = true; 
							if(c1.getImage() != slide.getImage()
									&&!c1.isJump()
									&&!c1.isFall()) {
								c1.setImage(slide.getImage());
							}
						}
					}
				}
				@Override
				public void keyReleased(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_DOWN) {
						downkeyOn = false;
						
						if(c1.getImage() != cookie.getImage()
								&&!c1.isJump()
								&&!c1.isFall()) {
							c1.setImage(cookie.getImage());
						}
					}
					super.keyReleased(e);
				}
			});
		}// end public Mypanel

		@Override
		protected void paintComponent(Graphics g) {

			
			// ������۴� �׸��� �̸��׷����� ȭ�鿡 ����Ѵ�.
			
			// ������� ����
			if (buffg == null) {
				buffImage = createImage(this.getWidth(), this.getHeight());
				if (buffImage == null) {
					System.out.println("���� ���۸��� ���� ��ũ�� ���� ����");
				} else {
					buffg = buffImage.getGraphics();
				}
			}
			
			//���� ����
			Graphics2D g2 = (Graphics2D)buffg; 
			
			super.paintComponent(buffg); // ���� �̹����� �����.
			
			// ����̹����� �׸���
			buffg.drawImage(b11.getImage(), b11.getX(), 0, null);
			buffg.drawImage(b12.getImage(), b12.getX(), 0, null);

			// ������ �׸���
			for (int i = 0; i < fieldList.size(); i++) {

				Field tempFoot = fieldList.get(i);

				// ����� �� ��Ƹ԰� �ϱ����� ��ġ
				if (tempFoot.getX() > -90 && tempFoot.getX() < 810) { // x���� -90~810�� ��ü�鸸 �׸���.
					
					buffg.drawImage(
						tempFoot.getImage(), 
						tempFoot.getX(), 
						tempFoot.getY(), 
						tempFoot.getWidth(),
						tempFoot.getHeight(), 
						null);
				}

			}
			
			// ������ �׸���
			for (int i = 0; i < jellyList.size(); i++) {

				Jelly tempJelly = jellyList.get(i);

				if (tempJelly.getX() > -90 && tempJelly.getX() < 810) {
					
					buffg.drawImage(
						tempJelly.getImage(), 
						tempJelly.getX(), 
						tempJelly.getY(), 
						tempJelly.getWidth(),
						tempJelly.getHeight(), 
						null);
				}
			}
			
			// ��ֹ��� �׸���
			for (int i = 0; i < tacleList.size(); i++) {

				Tacle tempTacle = tacleList.get(i);

				if (tempTacle.getX() > -90 && tempTacle.getX() < 810) {
					
					buffg.drawImage(
						tempTacle.getImage(), 
						tempTacle.getX(), 
						tempTacle.getY(), 
						tempTacle.getWidth(),
						tempTacle.getHeight(), 
						null);
				}
			}
			
			if(c1.isInvincible()) {
				// ��Ű�� alpha���� �޾ƿ´�
				alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)c1.getAlpha()/255);
				g2.setComposite(alphaComposite);
				
				// ��Ű�� �׸���
				buffg.drawImage(c1.getImage(), c1.getX(), c1.getY(), c1.getWidth(), c1.getHeight(), null);
				
				// alpha���� �ǵ�����
				alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)255/255);
				g2.setComposite(alphaComposite);
			} else {
				// ��Ű�� �׸���
				buffg.drawImage(c1.getImage(), c1.getX(), c1.getY(), c1.getWidth(), c1.getHeight(), null);
			}
		    
		    buffg.setColor(Color.BLACK);
		    buffg.drawString(Integer.toString(resultScore), 700, 40); // ����
		    
		    buffg.setColor(Color.GREEN);
		    buffg.fillRect(50, 40, c1.getHealth()/2, 30); // ü�°�����
		    
		    if(esckeyOn) { // escŰ�� ������� ȭ���� �帮�� �����
		    	
		    	// alpha���� �������ϰ� �����
				alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)100/255);
			    g2.setComposite(alphaComposite);
			    
			    buffg.setColor(Color.BLACK);
			    
		    	buffg.fillRect(0, 0, 850, 550);
		    	
				// alpha���� �ǵ�����
				alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)255/255);
			    g2.setComposite(alphaComposite);
		    }
			
			// �����̹����� ȭ�鿡 ����Ѵ�
			g.drawImage(buffImage, 0, 0, this);
			
		}
 


	}// end class MyPanel
	void mapMove() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (true) {
					
					if(runPage > 800) { // 800�ȼ� �̵� ���� ü���� 10�� �����Ѵ� (���� �ʱ��̿� ���߾� ���ҷ� ����)
						c1.setHealth(c1.getHealth()-10);
						runPage = 0;
					}
					
					runPage +=gameSpeed; // ȭ���� �̵��ϸ� runPage�� �̵��� ��ŭ ����ȴ�.
					
					
					if (b11.getX() < -(b11.getWidth()-1)) { // ���1-1 �� -(������)���� ������, �� ȭ������� ��γ����� ��� 1-2�ڿ� ����
						b11.setX(b11.getWidth());
					}
					if (b12.getX() < -(b12.getWidth()-1)) { // ���1-2 �� -(������)���� ������, �� ȭ������� ��γ����� ��� 1-1�ڿ� ����
						b12.setX(b12.getWidth());
					}
					
					
					// ����� x��ǥ�� -1 ���ش� (�������� �帣�� ȿ��)
					b11.setX(b11.getX()-gameSpeed/3); 
					b12.setX(b12.getX()-gameSpeed/3);
					
					
					// ������ġ�� -4 �� ���ش�. (�������� �帣�� ȿ��)
					for (int i = 0; i < fieldList.size(); i++) {
						
						Field tempField = fieldList.get(i); // �ӽ� ������ ����Ʈ �ȿ� �ִ� ���� ������ �ҷ�����
						
						if(tempField.getX() < -90) { // ������  x��ǥ�� -90 �̸��̸� �ش� ������ �����Ѵ�.(����ȭ)
							
							fieldList.remove(tempField);
							
						} else {
							
							tempField.setX(tempField.getX() - gameSpeed);  // �� ���ǿ� �ش��� �ȵǸ� x��ǥ�� ������
							
						}
					}
					
					// ������ġ�� -4 �� ���ش�.
					for (int i = 0; i < jellyList.size(); i++) {
						
						Jelly tempJelly = jellyList.get(i); // �ӽ� ������ ����Ʈ �ȿ� �ִ� ���� ������ �ҷ�����
						
						if(tempJelly.getX() < -90) { // ������ x ��ǥ�� -90 �̸��̸� �ش� ������ �����Ѵ�.(����ȭ)
							
							fieldList.remove(tempJelly);
							
						} else {
							
							tempJelly.setX(tempJelly.getX() - gameSpeed); // �� ���ǿ� �ش��� �ȵǸ� x��ǥ�� ������
							
							foot = c1.getY() + c1.getHeight(); // ĳ���� �� ��ġ �罺ĵ
							
							if( // ĳ������ ���� �ȿ� ������ ������ �������� �Դ´�.
								c1.getImage() != slide.getImage()
								&& tempJelly.getX() + tempJelly.getWidth()*20/100 >= c1.getX()
								&& tempJelly.getX() + tempJelly.getWidth()*80/100 <= face
								&& tempJelly.getY() + tempJelly.getWidth()*20/100 >= c1.getY()
								&& tempJelly.getY() + tempJelly.getWidth()*80/100 <= foot
								&& tempJelly.getImage() != jellyeffect.getImage()) {
								
								tempJelly.setImage(jellyeffect.getImage()); // ������ �̹����� ����Ʈ�� �ٲ۴�
								resultScore = resultScore + tempJelly.getScore(); // �������� ���� ������ ���Ѵ�
								
								
							} else if( // �����̵� �ϴ� ĳ������ ���� �ȿ� ������ ������ �������� �Դ´�.
								c1.getImage() == slide.getImage()
								&& tempJelly.getX() + tempJelly.getWidth()*20/100 >= c1.getX()
								&& tempJelly.getX() + tempJelly.getWidth()*80/100 <= face
								&& tempJelly.getY() + tempJelly.getWidth()*20/100 >= c1.getY() + c1.getHeight()*1/3
								&& tempJelly.getY() + tempJelly.getWidth()*80/100 <= foot
								&& tempJelly.getImage() != jellyeffect.getImage()) {
								
								tempJelly.setImage(jellyeffect.getImage()); // ������ �̹����� ����Ʈ�� �ٲ۴�
								resultScore = resultScore + tempJelly.getScore(); // �������� ���� ������ ���Ѵ�
								
							}
						}
					}
					
					// ��ֹ���ġ�� - 4 �� ���ش�.
					for (int i = 0; i < tacleList.size(); i++) {
						
						Tacle tempTacle = tacleList.get(i); // �ӽ� ������ ����Ʈ �ȿ� �ִ� ���� ��ֹ��� �ҷ�����
						
						if(tempTacle.getX() < -90) { 
							
							fieldList.remove(tempTacle); // ��ֹ��� x ��ǥ�� -90 �̸��̸� �ش� ������ �����Ѵ�.(����ȭ)
							
						} else {
							
							tempTacle.setX(tempTacle.getX() - gameSpeed);	// �� ���ǿ� �ش��� �ȵǸ� x��ǥ�� ������
							
							face = c1.getX() + c1.getWidth(); // ĳ���� ���� ��ġ �罺ĵ
							foot = c1.getY() + c1.getHeight(); // ĳ���� �� ��ġ �罺ĵ
							
							if( // �������°� �ƴϰ� �����̵� ���� �ƴϸ� ĳ������ ���� �ȿ� ��ֹ��� ������ �ε�����
									!c1.isInvincible()
									&& c1.getImage() != slide.getImage()
									&& tempTacle.getX() + tempTacle.getWidth()/2 >= c1.getX()
									&& tempTacle.getX() + tempTacle.getWidth()/2 <= face
									&& tempTacle.getY() + tempTacle.getHeight()/2 >= c1.getY()
									&& tempTacle.getY() + tempTacle.getHeight()/2 <= foot) {
								
								hit(); // �ǰ� + ���� ������ �޼���
								
							} else if( // �����̵� �ƴҽ� ������ֹ�
									!c1.isInvincible()
									&& c1.getImage() != slide.getImage()
									&& tempTacle.getX() + tempTacle.getWidth()/2 >= c1.getX()
									&& tempTacle.getX() + tempTacle.getWidth()/2 <= face
									&& tempTacle.getY() <= c1.getY()
									&& tempTacle.getY() + tempTacle.getHeight()*95/100 > c1.getY()) {
								
								
								hit(); // �ǰ� + ���� ������ �޼���
								
							}else if( // �������°� �ƴϰ� �����̵� ���̸� ĳ������ ���� �ȿ� ��ֹ��� ������ �ε�����
									!c1.isInvincible()
									&& c1.getImage() == slide.getImage()
									&& tempTacle.getX() + tempTacle.getWidth()/2 >= c1.getX()
									&& tempTacle.getX() + tempTacle.getWidth()/2 <= face
									&& tempTacle.getY() + tempTacle.getHeight()/2 >= c1.getY() + c1.getHeight()*2/3
									&& tempTacle.getY() + tempTacle.getHeight()/2 <= foot) {
								
								hit(); // �ǰ� + ���� ������ �޼���
								
							} else if( // �����̵��� ������ֹ�
									!c1.isInvincible()
									&& c1.getImage() == slide.getImage()
									&& tempTacle.getX() + tempTacle.getWidth()/2 >= c1.getX()
									&& tempTacle.getX() + tempTacle.getWidth()/2 <= face
									&& tempTacle.getY() < c1.getY()
									&& tempTacle.getY() + tempTacle.getHeight()*95/100 > c1.getY() + c1.getHeight()*2/3) {
								
								hit(); // �ǰ� + ���� ������ �޼���
							}
						}
					}
					
					// ��Ű�� ���� ������ ����ϴ� �ڵ�
					int tempField; // ������ġ�� ��� ��ĵ�ϴ� ��������
					int tempNowField; // ĳ���Ϳ� ������ ���̿� ���� ����Ǵ� ��������, ����� nowField�� �����Ѵ�
					
					
					// ��Ű�� �������¶�� ���� ���� �ʱ� ������ 400���� ���� / ������ �ƴ϶�� 2000(��������);
					if (c1.isInvincible()) {
						tempNowField = 400;
					} else {
						tempNowField = 2000;
					}

					for (int i = 0; i < fieldList.size(); i++) { // ������ ������ŭ �ݺ�

						int tempX = fieldList.get(i).getX(); // ������ x��

						if (tempX > c1.getX()-60 && tempX <= face) { // ������ ĳ�� ���� ���̶�� 

							tempField = fieldList.get(i).getY(); // ������ y���� tempField�� �����Ѵ�

							
							foot = c1.getY() + c1.getHeight(); // ĳ���� �� ��ġ �罺ĵ
							
							// ������ġ�� tempNowField���� ����, �߹ٴ� ���� �Ʒ� �ִٸ�
							// ��, ĳ���� �� �Ʒ���  ���� ���� �ִ� �����̶�� tempNowField�� �����Ѵ�.
							if (tempField < tempNowField && tempField >= foot) {

								tempNowField = tempField;

							}
						}
					}

					nowField = tempNowField; // ����� nowField�� ������Ʈ �Ѵ�.
					
					
					
					if(esckeyOn) { // escŰ�� ������ ������ �����
						while (esckeyOn) {
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
			}
		}).start();
	}
 
	void hit() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				c1.setInvincible(true); // ��Ű�� �������·� ��ȯ
				
				System.out.println("�ǰݹ�������");
				
				c1.setHealth(c1.getHealth() - 100); // ��Ű�� ü���� 100 ��´�
				
				c1.setImage(hit.getImage()); // ��Ű�� �ε��� ������� ����
				
				c1.setAlpha(80); // ��Ű�� ������ 80���� ����
				
				try { // 0.5�� ���
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				if(c1.getImage() == hit.getImage()) { // 0.5�� ���� �̹����� �ٲ��� �ʾҴٸ� �⺻�̹����� ����
					
					c1.setImage(cookie.getImage());
					
				}
				
				
				for (int j = 0; j < 11; j++) { // 2.5�ʰ� ĳ���Ͱ� �����δ�. (�ǰ��� ���� ���¸� �ν�)
					
					if(c1.getAlpha() == 80) { // �̹����� ���İ��� 80�̸� 160���� 
						
						c1.setAlpha(160);
						
					} else { // �ƴϸ� 80����
						
						c1.setAlpha(80);
						
					}
					try {
						Thread.sleep(250);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				c1.setAlpha(255); // ��Ű�� ������ �������� ����
				
				c1.setInvincible(false);
				System.out.println("�ǰݹ�������");
			}
		}).start();
	}
 



	void fall() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (true) {
					
					foot = c1.getY() + c1.getHeight(); // ĳ���� �� ��ġ �罺ĵ
					
					// �߹ٴ��� ���Ǻ��� ���� ������ �۵�
					if (
						!esckeyOn // �Ͻ������� �ߵ� �ȵ��� ��
					    &&foot < nowField  // ���߿� ������
						&& !c1.isJump() // ���� ���� �ƴϸ�
						&& !c1.isFall()) { // �������� ���� �ƴ� ��
					
						c1.setFall(true);  // �������� ������ ��ȯ
						System.out.println("����");

						if (c1.getCountJump() == 2) { // ���������� ������ ��� ���� �̹����� ����
							c1.setImage(fall.getImage());
						}

						long t1 = Util.getTime(); // ����ð��� �����´�
						long t2;
						int set = 1; // ó�� ���Ϸ� (0~10) ���� �׽�Ʈ�غ���
					
						while (foot < nowField) { // ���� ���ǿ� ��� ������ �ݺ�
							
							t2 = Util.getTime() - t1; // ���� �ð����� t1�� ����
							
							int fallY = set + (int) ((t2) / 40); // ���Ϸ��� �ø���.
							
							foot = c1.getY() + c1.getHeight(); // ĳ���� �� ��ġ �罺ĵ
							
							if (foot + fallY >= nowField) { // �߹ٴ�+���Ϸ� ��ġ�� ���Ǻ��� ���ٸ� ���Ϸ��� �����Ѵ�.
								fallY = nowField - foot;
							}

							c1.setY(c1.getY()+fallY); // Y��ǥ�� ���Ϸ��� ���Ѵ�

							if (c1.isJump()) { // �������ٰ� ���� ������ �ϸ� ��������
								break;
							}
							
							if (esckeyOn) {
								long tempT1 = Util.getTime();
								long tempT2 = 0;
								while (esckeyOn) {
									tempT2 = Util.getTime() -tempT1;
									try {
										Thread.sleep(10);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
								}
								t1 = t1 + tempT2;
							}
							
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}

						}
						c1.setFall(false);

						if (
							downkeyOn // �ٿ�Ű�� �������°�
							&& !c1.isJump() // ���� ���°� �ƴϰ�
							&& !c1.isFall() // ���� ���°� �ƴϰ�
							&& c1.getImage() != slide.getImage()) { // ��Ű �̹����� �����̵� �̹����� �ƴ� ���
							
							c1.setImage(slide.getImage()); // ��Ű �̹����� �����̵�� ����
							
						} else if (
							!downkeyOn // �ٿ�Ű�� �������°� �ƴϰ�
							&& !c1.isJump() // ���� ���°� �ƴϰ�
							&& !c1.isFall() // ���� ���°� �ƴϰ�
							&& c1.getImage() != cookie.getImage()) { // ��Ű �̹����� �⺻ �̹����� �ƴ� ���
							
							c1.setImage(cookie.getImage());
						}

						if (!c1.isJump()) { // ���� ���� ��� ���� ���� �ƴ� �� �������� ī��Ʈ�� 0���� ����
							c1.setCountJump(0);
						}
					}
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
 



	void jump() {
		new Thread(new Runnable() {

			@Override
			public void run() {

				c1.setCountJump(c1.getCountJump()+1); // ���� Ƚ�� ����

				int nowJump = c1.getCountJump(); // �̹������� �������� ������������ ����

				c1.setJump(true); // ���������� ����

				if (c1.getCountJump() == 1) { // ���� Ƚ���� 1�̶��
					
					System.out.println("����");
					c1.setImage(jump.getImage());
					
				} else if (c1.getCountJump() == 2) { // ���� Ƚ���� 2���
					
					System.out.println("��������");
					c1.setImage(jump2.getImage());
					
				}

				long t1 = Util.getTime(); // ����ð��� �����´�
				long t2;
				int set = 8; // ���� ��� ����(0~20) ������ �ٲ㺸��
				int jumpY = 1; // 1�̻����θ� �����ϸ� �ȴ�.(while�� ���� ����)
				
				while (jumpY >= 0) { // ��� ���̰� 0�϶����� �ݺ�
					
					t2 = Util.getTime() - t1; // ���� �ð����� t1�� ����
					
					jumpY = set - (int) ((t2) / 40); // jumpY �� �����Ѵ�.
					
					c1.setY(c1.getY()-jumpY); // Y���� �����Ѵ�.

					if (nowJump != c1.getCountJump()) { // ������ �ѹ� ���Ǹ� ù��° ������ �����.
						break;
					}
					
					if (esckeyOn) {
						long tempT1 = Util.getTime();
						long tempT2 = 0;
						while (esckeyOn) {
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						tempT2 = Util.getTime() - tempT1;
						t1 = t1 + tempT2;
					}
					
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				if (nowJump == c1.getCountJump()) { // ������ ��¥ ������ ���� Ȯ��
					c1.setJump(false); // �������¸� false�� ����
				}

			}
		}).start();
	}
 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					CookieRun window = new CookieRun();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CookieRun() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new MyPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		escButton = new Button("�����");
		escButton.setBounds(350, 240, 50, 30);
		escButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.remove(escButton);
				esckeyOn = false;
			}
		});

	}
}
