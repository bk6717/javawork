package ch14;

import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class EventEx07 extends JFrame{
	
	int y = 100;
	
	public EventEx07() {
		JLabel la = new JLabel("hi");
		la.setLocation(30, 10);
		Container c = getContentPane();
		c.setLayout(null);
		la.setLocation(100,100);
		la.setSize(30,50);
		c.add(la);
		setSize(300, 600);
		setVisible(true);
		setSize(300,600);
		setVisible(true);
		c.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					new Thread(new Runnable() {
						
						public void run() {
							for (int i = 0; i < 10; i++) {
								y = y+10;
								la.setLocation(100,y);    //repaint
								try {
									Thread.sleep(100);
								} catch (InterruptedException e1) {
									e1.printStackTrace();
								}
							}
							
						}
					});
				}
			}
		});
	} 
	public static void main(String[] args) {
		new EventEx07();
	}
}
