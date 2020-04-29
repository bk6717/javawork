package cookirun;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.json.simple.ItemList;

public class CookiRun extends JFrame {
	MyPanel panel;

	// 배경이미지
	ImageIcon back = new ImageIcon("img/123.png");
	Image bg = back.getImage();
	//바닥 생성
	ImageIcon gr = new ImageIcon("img/ground.png");
	Image ground = gr.getImage();
	// 쿠키 생성
	ImageIcon cook = new ImageIcon("img/Tiger.gif");
	Image cr = cook.getImage();
	//캔디 이미지 
	ImageIcon can = new ImageIcon("img/candy.png");
	Image candy = can.getImage();
	//캔디 리스트
	List<Item> imgList = new ArrayList<>();
	
	int img1X = 0;
	int img2X = bg.getWidth(null);

	int cookY = 85;
	int cookX = 50;
	public CookiRun() {
		setTitle("쿠키런");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		panel = new MyPanel();
		setContentPane(panel);
		setSize(1200, 350);
		setVisible(true);
	}

	class MyPanel extends JPanel {
		
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(bg, img1X, 0, this.getWidth(), this.getHeight(), null);
			g.drawImage(bg, img2X, 0, this.getWidth(), this.getHeight(), null);
			g.drawImage(ground , 10, 100 ,1200,220, null);
			g.drawImage(cr, cookX, cookY, 200, 200, null);
			
			for (int i = 0; i < imgList.size(); i++) {
				g.drawImage(imgList.get(i).getImage(), imgList.get(i).getX(), imgList.get(i).getY(),this);
	
			}
			
		}// end of class Mypanel

		public MyPanel() {
			setFocusable(true);
			
			//아이템 추가
			imgList.add(new Item(candy , 0 , 400 , 150));
			imgList.add(new Item(candy , 0 , 500 , 50));  
			imgList.add(new Item(candy , 0 , 600 , 150));
			
			//점프 이벤트
			addKeyListener(new KeyAdapter() {

				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_SPACE) {
						
						new Thread(new Runnable() {
							@Override
							public void run() {
								int jump = 60;
								while (jump > 0) {
									 jump--;
									if (jump > 30) {
										cookY = cookY -4;
									
									} else if(jump < 30) {
										cookY = cookY  +4;
									}
									if(cookY > 67) {
										cookY = 67;
									}
									try {
										Thread.sleep(7);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
							}
						}).start();
						
					}
				}
			});
			
			new Thread(new Runnable() {

				public void run() {
					while (true) {
						
						//아이템 이동
						for (int i = 0; i < imgList.size(); i++) {
							imgList.get(i).setX( imgList.get(i).getX() - 1 );
						}
						// 아이템 제거
						for (int i = 0; i < imgList.size(); i++) {
							if(imgList.get(i).getX() > cookX
									&& imgList.get(i).getX() < cookX +150
									&& imgList.get(i).getY() > cookY
									&& imgList.get(i).getY() < cookY +150){
									
									imgList.remove(imgList.get(i));
									}
						}
						//배경화면
						img1X--;
						img2X--;

						if (img1X < -(bg.getWidth(null))) {
							img1X = bg.getWidth(null) - 1;
						}
						if (img2X < -(bg.getWidth(null))) {
							img2X = bg.getWidth(null) - 1;
						}
						repaint();
						try {
							Thread.sleep(5);
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
