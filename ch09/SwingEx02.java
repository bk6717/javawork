package ch09;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

//7���� x��ư Ŭ���ϸ� ��������
public class SwingEx02 extends JFrame {

	public SwingEx02() {
		setTitle("Contentpane�� JFrame"); // ������ Ÿ��Ʋ �ޱ�
		// ������ �����츦 ������ ���� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ����Ʈ ���� �˾Ƴ���
		Container contentPane = getContentPane();
		// ����Ʈ���� ���� ��������
		contentPane.setBackground(Color.orange);
		// ����Ʈ�ҿ� �÷ο췹�̾ƿ� ��ġ������ �ޱ�
		contentPane.setLayout(new FlowLayout());
		
		contentPane.add(new JButton("ok")); // ok��ư
		contentPane.add(new JButton("Cancel")); // cancel ��ư
		contentPane.add(new JButton("Ignore")); // Ignore ��ư

		setSize(300, 150); // ������ ũ�� 300*150
		setVisible(true); // ȭ�鿡 ������ ���
	}

	public static void main(String[] args) {
		new SwingEx02();
	}
}
