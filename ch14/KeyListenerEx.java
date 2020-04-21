package ch14;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class KeyListenerEx extends JFrame{
	private JLabel [] keyMessage; //3���� �޽����� ����� ���̺� ������Ʈ �迭
	
	public KeyListenerEx() {
		setTitle("keyListener ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		//c.addKeyListener(new MyKeyListener());
		
		// ���̺� �迭�� 3�� �����ϰ� �� ���̺� ������Ʈ ����
		keyMessage = new JLabel[3]; //���̺� �迭 ����
		keyMessage[0] = new JLabel("getKeyCode()");
		keyMessage[1] = new JLabel("getKeyChar()");
		keyMessage[2] = new JLabel("getKeyText()");
		
		//3���� ���̺� ������Ʈ�� ����Ʈ�ҿ� ����
		for (int i = 0; i < keyMessage.length; i++) {
			c.add(keyMessage[i]);
			keyMessage[i].setOpaque(true);
			keyMessage[i].setBackground(Color.yellow);
		}
		setSize(300, 150);
		setVisible(true);
		
		//����Ʈ���� Ű �Է��� ���� �� �ֵ��� ��Ŀ�� ���� ����
		c.setFocusable(true);
		
}
}