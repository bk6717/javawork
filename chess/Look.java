package chess;

import java.awt.Color;
//ü�� ĭ���� ����
//ĭ�̵�
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
		setContentPane(panel); // MousePanel�� ���δ�
		setSize(1000,1000); // ũ������
		setVisible(true); // ���δ�
	}

	class MousePanel extends JPanel {

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(bo , 0, 0, 980,960,null);

		}

		public MousePanel() {
			setLayout(null); // ���̾ƿ� ��
			this.addMouseListener(new MyMouseListener()); // ���콺������
			this.addMouseMotionListener(new MyMouseListener()); // ��Ǹ�����
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

		
//		public void mouseClicked(MouseEvent e) { // �巡���Ͻ�
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
		//	la.setLocation(x, y); // ��ġ ����
//		}
	}

	public static void main(String[] args) {
		new Look();
	}
}
