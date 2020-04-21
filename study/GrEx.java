package study;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GrEx extends JFrame{
	private MyPanel panel = new MyPanel();

	public GrEx() {
		setTitle("±×·¡ÇÁ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(500,500);
		setVisible(true);
	}
	class MyPanel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.black);
			
			g.drawString("2019.10",100, 400);
			g.fillRect(110,200,20,180);
			g.drawString("35", 110, 190);
			
			g.drawString("2019.11",200, 400);
			g.fillRect(210,150,20,230);
			g.drawString("40", 210, 140);
			
			g.drawString("2019.12",300, 400);
			g.fillRect(310,250,20,130);
			g.drawString("25", 310, 240);
		}
	}
	public static void main(String[] args) {
		new GrEx();
	}
}
