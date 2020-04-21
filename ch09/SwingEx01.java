package ch09;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingEx01 extends JFrame{ // SwingEx01 �� �������� ��

	public SwingEx01(){
		//JFrame�� �⺻ �гο� �����ϱ�
		Container contentPane = getContentPane();
		//JFrame�� �⺻�г��� BorderLayOut  -> FlowLayOut ���� ���� 
		contentPane.setLayout(new FlowLayout());
		//�⺻ �гο� ��ư �׸���
		contentPane.add(new JButton("ù��°��ư"));
		//����׸���
		setTitle("300*300 ���� ������ �����");
		//ũ�� 300*300
		setSize(300,300);
		//ȭ�� ���
		setVisible(true); //painting  (�̶� �׸��� �׷���) ������ ���
	}
	public static void main(String[] args) {
		new SwingEx01();
		
	}
}
