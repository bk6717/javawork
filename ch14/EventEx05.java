package ch14;

import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

//마우스 이벤트
public class EventEx05 extends JFrame {

	private JLabel la; // 여기다가 new ㄴㄴ

	public EventEx05() {
		la = new JLabel("hello");
		setTitle("마우스이벤트 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 이벤트 분배스레드 종료
		Container c = getContentPane();
		c.addMouseListener(new MyMouseListener()); // 변수이름이 l 이면 보통 인터페이스
		c.setLayout(null);  //absoulte 레이아웃
		la.setSize(50, 20); // 라벨의 사이즈
		la.setLocation(30, 30); // 라벨의 위치
		c.add(la);
		setSize(250, 250);
		setVisible(true); // paint()
	}
	
	class MyMouseListener extends MouseAdapter { // 인터페이스를 구현했는데 메서드가너무 많을때 사용
		@Override
		public void mousePressed(MouseEvent e) { // 마우스 뗐을 때...
			int x = e.getX(); // x좌표
			int y = e.getY(); // y좌표
			// la.setLocation(x, y); //라벨 위치변경 => repanit

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
