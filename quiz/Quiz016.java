package quiz;

import java.util.Scanner;

// 타이머를 만들려고 한다
// 숫자를 입력하면 카운트를 출력하고 카운트가 완료되면 "종료" 라고 떠야한다
// 1초 간격을 주는 코드는 Thread.sleep(1000) 이다

public class Quiz016 {
	
	public static void main(String[] args) {
		System.out.println("숫자를 입력하세요");
		Scanner sc = new Scanner(System.in);
		int a;
		a = sc.nextInt();
		
		for (int i = 0; i < a; i++) {
			try {
				Thread.sleep(a*1000);
				System.out.println("종료");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
