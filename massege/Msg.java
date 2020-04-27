package massege;

import java.awt.Button;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Msg extends JFrame {
	JTextField tf;
	JTextArea ta;
	JButton jb;
	
	class click extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			new SendMsg(tf.getText(), ta.getText());
			System.out.println("전송완료");
		}
	}
	
	public Msg() {
		setTitle("문자 전송");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(new JLabel("번호"));
		c.add(tf = new JTextField(20));
		
		c.add(new JLabel("내용"));
		c.add(ta = new JTextArea(7,20));
		
		jb = new JButton("전송");
		jb.addMouseListener(new click());
		c.add(jb);
		

		setSize(300, 300);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new Msg();
	}
}
