package ch14;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

//오늘은 기사 공부 하지마라! 마! 술이나 먹어라! 어제 니 뭐했노! 

public class EventEx01 extends JFrame{
	
	public EventEx01() {
		setTitle("Action 이벤트 리스너 예제");
		//이벤트 분배스레드 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		//컨텐트패널에 접근
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		JButton btn = new JButton("Action");
		//리스너 생성
		btn.addActionListener(new MyActionListener());	//리스너는 add로 시작함
		c.add(btn);
		setSize(350,150);
		setVisible(true);  // paint() 함수 호출
	}

	class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("Action"))
				b.setText("액션");
			else {
				b.setText("Action");
			}
		}
	}
	
	public static void main(String[] args) {
		new EventEx01();
	}
}
