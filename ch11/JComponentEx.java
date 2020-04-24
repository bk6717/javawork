package ch11;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class JComponentEx extends JFrame{
	//��� ������Ʈ�� private ���̰�  ������ �ۿ��� 
	private JButton b1,	b2,	b3;
	
	public JComponentEx() {
		setTitle("JComponent�� ���� �޼ҵ� ����");
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		b1 = new JButton("Magenta/Yellow Button");
		b2 = new JButton("		Disabled Button		 ");
		b3 = new JButton("getX(),getY()");
		
		b1.setBackground(Color.YELLOW); //b1�� ����
		b1.setForeground(Color.MAGENTA);//b1�� ���ڻ�
		b1.setFont(new Font("Arial", Font.ITALIC, 20)); // Arial , 20 �ȼ� ��Ʈ
		
		b2.setEnabled(false); //��ư Ȱ��ȭ  false�ϸ� ��Ȱ��ȭ ��ưŬ������.
		
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton)e.getSource(); //Objext�� �����ϱ� ������ �ٿ�ĳ����
				JComponentEx frame = (JComponentEx)b.getTopLevelAncestor();
				frame.setTitle(b.getX() + "," + b.getY());
				b.setText("hello");  //��ư�������� hello �� �ٲ��.
			}
		});
		
		c.add(b1); c.add(b2); c.add(b3);
	
		setSize(260,200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new JComponentEx();
	}
}
