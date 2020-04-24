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
	//스크롤은 컨테이너이자 컨포넌트
	private ScrollPane sp;   // JScrllpane 도 있지만 textarea의 색을 잡아먹어버림.
	
	public TextFieldEx() {
		init();
		setTitle("텍스트 에디터 , 텍스트박스 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();  //컨테이너 가져오기  기본적으로 borderLayout
		tf = new JTextField("",20); //컬럼밖에없다.
		
		//텍스트필드 디자인
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
				if(e.getKeyCode() == KeyEvent.VK_ENTER) { //엔터를 눌렸을때만 입력
					String value = tf.getText();
					ta.append(value+"\n"); //엔터 누르면
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
