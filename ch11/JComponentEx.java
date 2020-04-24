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
	//모든 컴포넌트는 private 붙이고  생성자 밖에서 
	private JButton b1,	b2,	b3;
	
	public JComponentEx() {
		setTitle("JComponent의 공통 메소드 예제");
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		b1 = new JButton("Magenta/Yellow Button");
		b2 = new JButton("		Disabled Button		 ");
		b3 = new JButton("getX(),getY()");
		
		b1.setBackground(Color.YELLOW); //b1의 배경색
		b1.setForeground(Color.MAGENTA);//b1의 글자색
		b1.setFont(new Font("Arial", Font.ITALIC, 20)); // Arial , 20 픽셀 폰트
		
		b2.setEnabled(false); //버튼 활성화  false하면 비활성화 버튼클릭못함.
		
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton)e.getSource(); //Objext를 리턴하기 때문에 다운캐스팅
				JComponentEx frame = (JComponentEx)b.getTopLevelAncestor();
				frame.setTitle(b.getX() + "," + b.getY());
				b.setText("hello");  //버튼을누르면 hello 로 바뀐다.
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
