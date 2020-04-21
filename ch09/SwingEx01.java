package ch09;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingEx01 extends JFrame{ // SwingEx01 이 프레임이 됨

	public SwingEx01(){
		//JFrame의 기본 패널에 접근하기
		Container contentPane = getContentPane();
		//JFrame의 기본패널은 BorderLayOut  -> FlowLayOut 으로 변경 
		contentPane.setLayout(new FlowLayout());
		//기본 패널에 버튼 그리기
		contentPane.add(new JButton("첫번째버튼"));
		//제목그리기
		setTitle("300*300 스윙 프레임 만들기");
		//크기 300*300
		setSize(300,300);
		//화면 출력
		setVisible(true); //painting  (이때 그림이 그려짐) 프레임 출력
	}
	public static void main(String[] args) {
		new SwingEx01();
		
	}
}
