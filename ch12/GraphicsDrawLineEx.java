package ch12;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsDrawLineEx  extends JFrame{
	private MyPanel panel = new MyPanel();
	
	public GraphicsDrawLineEx() {
		setTitle("DrawLine 사용예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(200,170);
		setVisible(true);
	}
	
	class MyPanel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.red);
			g.drawLine(20, 20, 100, 100);
		}
	}
	public static void main(String[] args) {
		new GraphicsDrawLineEx();
	}
}
