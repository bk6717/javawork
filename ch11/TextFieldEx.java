package ch11;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.DimensionUIResource;


public class TextFieldEx extends JFrame{
	private JTextField tf;
	private JTextArea ta;
	//��ũ���� �����̳����� ������Ʈ
	private ScrollPane sp;   // JScrllpane �� ������ textarea�� ���� ��ƸԾ����.
	
	public TextFieldEx() {
		init();
		setTitle("�ؽ�Ʈ ������ , �ؽ�Ʈ�ڽ� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();  //�����̳� ��������  �⺻������ borderLayout
		tf = new JTextField("",20); //�÷��ۿ�����.
		
		//�ؽ�Ʈ�ʵ� ������
		tf.setFont(new Font("Arial",Font.BOLD,20));
		tf.setPreferredSize(new Dimension(100, 100));
		
		sp = new ScrollPane();
		
		ta = new JTextArea("",5,20);
		ta.setBackground(Color.orange);
		ta.setForeground(Color.blue);
		
		sp.add(ta);
		
		tf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) { //���͸� ���������� �Է�
					String value = tf.getText();
					ta.append(value+"\n"); //���� ������
					tf.setText("");
				}
			}
		});
		c.add(tf, BorderLayout.SOUTH);
		c.add(sp, BorderLayout.CENTER);
		
		
		setSize(300, 300);
		setVisible(true);
	}
	private void init() {
		
	}
	public static void main(String[] args) {
		new TextFieldEx();
	}
}
