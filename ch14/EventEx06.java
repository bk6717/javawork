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
		setTitle("장풍 예제");
		setSize(700,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // 프레임이 화면 한가운데 배치
		setContentPane(new MyPanel());
		setVisible(true);
	}
	//paintCompinent 함수는 JFrame 안에서 작동안함.
	class MyPanel extends JPanel{    
		
		//키보드이벤트
		public MyPanel(){
			setFocusable(true);
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("keycode :" + e.getKeyCode());
				System.out.println("keychar :" + e.getKeyChar());
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:	//왼쪽키를 클릭하면 == 0x25
					imgX = imgX - 10;
					break;
				case KeyEvent.VK_RIGHT: //오른쪽키 == 0x27
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
			//	default:                default는 무조건 실행되는것 
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

			//이미지 추출
			Image ryu = imgRyu.getImage();  //공식
			Image pa = imgPa.getImage();

			g.drawImage(ryu, 0,0 ,null);
			g.drawImage(pa, imgX,imgY,null);
		}
	}
	
	public static void main(String[] args) {
		new EventEx06();
	}
}
