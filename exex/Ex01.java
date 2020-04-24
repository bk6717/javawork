package exex;
//과목과 점수가 짝이되도록 아래와 같이 배열을 만들어
//과목이름으로 점수를 반복하여 조회할수 있도록

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		String course[] = {"Java", "C++" , "HTML5" , "컴퓨터구조", "안드로이드"};
		int score[] = {95,88,76,62,55};
		int a;
		
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println();
		for (int i = 0; i < score.length; i++) {
			a= sc.nextInt();
			System.out.println(course[a]+"의 점수는"+score[a]+ "입니다.");
		}
	}
}

