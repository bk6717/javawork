package cookirun;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CookiRun extends JFrame{
	private MyPanel panel = new MyPanel();
	int imgX = 0;
	int cookY =150;
	ImageIcon back = new ImageIcon("img/cookiback.jpg");
	Image bg = back.getImage();
	ImageIcon cook = new ImageIcon("img/cooki.png");
	Image cr = cook.getImage();
	public CookiRun() {
		setTitle("ÄíÅ°·±");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(panel);
		setSize(500,400);
		setVisible(true);
	}
	class MyPanel extends JPanel{
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(bg, imgX ,0,1000,200,this);
			g.drawImage(cr, 50 ,cookY , 50, 50,null);
		}
		
		public MyPanel() {
			new Thread(new Runnable() {
				public void run() {
					while(true) {
						imgX -= 1;
						repaint();
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
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
