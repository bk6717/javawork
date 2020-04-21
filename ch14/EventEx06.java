package ch14;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EventEx06 extends JFrame{
	
	int imgX = 260;
	int imgY = 20;
	
	public EventEx06() {
		setTitle("��ǳ ����");
		setSize(700,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // �������� ȭ�� �Ѱ�� ��ġ
		setContentPane(new MyPanel());
		setVisible(true);
	}
	//paintCompinent �Լ��� JFrame �ȿ��� �۵�����.
	class MyPanel extends JPanel{    
		
		//Ű�����̺�Ʈ
		public MyPanel(){
			setFocusable(true);
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("keycode :" + e.getKeyCode());
				System.out.println("keychar :" + e.getKeyChar());
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:	//����Ű�� Ŭ���ϸ� == 0x25
					imgX = imgX - 10;
					break;
				case KeyEvent.VK_RIGHT: //������Ű == 0x27
					imgX = imgX + 10;
					break;
				case KeyEvent.VK_UP:
					imgY = imgY -10;
					break;
				case KeyEvent.VK_DOWN:
					imgY = imgY +10;
					break;
				case KeyEvent.VK_SPACE: //0x20
					new Thread(new Runnable() {
						@Override
						public void run() {
							int time = 50 ;
							while(time >0) {
								imgX = imgX + 10;
								repaint();
								time--;
								try {
									Thread.sleep(100);
								} catch (InterruptedException e1) {
									e1.printStackTrace();
								}
								
							}
						}
					}).start();
					break;
			//	default:                default�� ������ ����Ǵ°� 
			//	break;
				}
				repaint();
			}
		});
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			ImageIcon imgRyu = new ImageIcon("img/ryu.png");
			ImageIcon imgPa = new ImageIcon("img/pa.png");

			//�̹��� ����
			Image ryu = imgRyu.getImage();  //����
			Image pa = imgPa.getImage();

			g.drawImage(ryu, 0,0 ,null);
			g.drawImage(pa, imgX,imgY,null);
		}
	}
	
	public static void main(String[] args) {
		new EventEx06();
	}
}