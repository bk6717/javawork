package CookieRun;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Run extends JFrame{
	
	Mypanel panel;
	//배경 생성
	ImageIcon back = new ImageIcon("img/123.png");
	Image bg = back.getImage();
	//쿠키 이미지 생성
	ImageIcon co = new ImageIcon("img/Tiger.gif");
	Image cookie = co.getImage();
	
	public Run() {
		
		setTitle("쿠키런");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new Mypanel();
		setContentPane(panel);
		setSize(1200, 350);
		setVisible(true);
		
	}
	
	class Mypanel extends JPanel{

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(bg, 0 , 0 ,1200, 350, null);
			g.drawImage(cookie , 30 , 80 , 200, 200, this);
		}
		public Mypanel() {
			
		}
	}
	
	public static void main(String[] args) {
		new Run();
	}
}
