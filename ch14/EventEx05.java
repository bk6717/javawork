package ch14;

import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

//���콺 �̺�Ʈ
public class EventEx05 extends JFrame {

	private JLabel la; // ����ٰ� new ����

	public EventEx05() {
		la = new JLabel("hello");
		setTitle("���콺�̺�Ʈ ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �̺�Ʈ �й轺���� ����
		Container c = getContentPane();
		c.addMouseListener(new MyMouseListener()); // �����̸��� l �̸� ���� �������̽�
		c.setLayout(null);  //absoulte ���̾ƿ�
		la.setSize(50, 20); // ���� ������
		la.setLocation(30, 30); // ���� ��ġ
		c.add(la);
		setSize(250, 250);
		setVisible(true); // paint()
	}
	
	class MyMouseListener extends MouseAdapter { // �������̽��� �����ߴµ� �޼��尡�ʹ� ������ ���
		@Override
		public void mousePressed(MouseEvent e) { // ���콺 ���� ��...
			int x = e.getX(); // x��ǥ
			int y = e.getY(); // y��ǥ
			// la.setLocation(x, y); //�� ��ġ���� => repanit

			for (int i = 0; i > x; i++) {
				try {
					Thread.sleep(1000);
					la.setLocation(i, y);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		new EventEx05();
	}
}
