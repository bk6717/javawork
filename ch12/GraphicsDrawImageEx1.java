package ch12;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsDrawImageEx1 extends JFrame{
	private MyPanel panel = new MyPanel(); 
	
	private GraphicsDrawImageEx1() {
		setTitle("원본 크기로 원하는 위치에 이미지 그리기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(300,400);
		setVisible(true);
	}
	
	class MyPanel extends JPanel{
		private ImageIcon icon = new ImageIcon("img/ryu.png");
		private Image img = icon.getImage();
		
		public void paintCompinent(Graphics g) {
			super.paintComponent(g);
			
			//이미지를 패널의(20,20)에 원래의 크기로 그린다.
			g.drawImage(img, 20, 20, this);
		}
	}
	public static void main(String[] args) {
		new GraphicsDrawImageEx1();
	}
}
