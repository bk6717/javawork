package chess;

import java.awt.Color;
//체스 칸마다 고정
//칸이동
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Look extends JFrame {
	MousePanel panel;
	int imgX = 20;
	int imgY = 10;
	
	boolean clicked = false;
	ImageIcon bor = new ImageIcon("img/cookiback.jpg");
	Image bo = bor.getImage(); 


	public Look() {
		panel = new MousePanel();
		setContentPane(panel); // MousePanel을 붙인다
		setSize(1000,1000); // 크기조정
		setVisible(true); // 보인다
	}

	class MousePanel extends JPanel {

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(bo , 0, 0, 980,960,null);

		}

		public MousePanel() {
			setLayout(null); // 레이아웃 널
			this.addMouseListener(new MyMouseListener()); // 마우스리스너
			this.addMouseMotionListener(new MyMouseListener()); // 모션리스너
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					while (true) {
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

	class MyMouseListener extends MouseAdapter{

		
//		public void mouseClicked(MouseEvent e) { // 드래그일시
//			int x = e.getX();
//			int y = e.getY();
//			if(x > imgX && x < (imgX + look.getWidth(null))  && y > imgY 
//					&& y < (imgY + look.getHeight(null))){				
////				imageUpdate(look, infoflags, x, y, w, h);
//				clicked = true;
//				
//			}else if (clicked) {
//				imgX = x - (int)(look.getWidth(null)/3);
//				imgY = y - (int)(look.getHeight(null)/3);
//				clicked = false;
//			}
			
//			imgX = e.getX() - (int) (look.getWidth(panel) / 2);
//			imgY = e.getY() - (int) (look.getHeight(panel) / 2);
		//	la.setLocation(x, y); // 위치 조정
//		}
	}

	public static void main(String[] args) {
		new Look();
	}
}
