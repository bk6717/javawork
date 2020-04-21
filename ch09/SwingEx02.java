package ch09;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

//7번줄 x버튼 클리하면 매인종료
public class SwingEx02 extends JFrame {

	public SwingEx02() {
		setTitle("Contentpane과 JFrame"); // 프레임 타이틀 달기
		// 프레임 윈도우를 닫으면 메인 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 컨텐트 팬을 알아낸다
		Container contentPane = getContentPane();
		// 컨텐트팬의 색을 오랜지로
		contentPane.setBackground(Color.orange);
		// 컨텐트팬에 플로우레이아웃 배치관리자 달기
		contentPane.setLayout(new FlowLayout());
		
		contentPane.add(new JButton("ok")); // ok버튼
		contentPane.add(new JButton("Cancel")); // cancel 버튼
		contentPane.add(new JButton("Ignore")); // Ignore 버튼

		setSize(300, 150); // 프레임 크기 300*150
		setVisible(true); // 화면에 프레임 출력
	}

	public static void main(String[] args) {
		new SwingEx02();
	}
}
