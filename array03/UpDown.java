package array03;

import java.util.Random;
import java.util.Scanner;

public class UpDown {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			Random random = new Random();
			int k = random.nextInt(100); //Random class 로 0~99까지의 임의의 정수 생성
			System.out.println("");
			System.out.println("0~99");
			int i = 1;
			
			while(true) {     //마지막에  n 을 입력하기 전까지 반복한다
				System.out.println(i + ">>");
				int input = scanner . nextInt();
				
				while(input != k) {    // 사용자가 정답을 맞추지 못했다면
					if(input < k)		// 사용자가 입력한 수 < 임의의 수 (정답)
						System.out.println("더크게");
					else if(input > k)
						System.out.println("더작게");
					i++;
					break; // while(input != k)를 빠져나가는 break 문
					
				}
				if(input ==k) {    // 정답을 맞췄을때
					System.out.println("맞았습니다.");
					System.out.println("다시하시겠습니까? (y/n) >>");
					
					if(scanner.next().equals("n"))   // 프로그램 종료
						System.out.println("숫자맞추기를 종료합니다.");
						System.exit(0);
				}
				else {  //계속 게임을 한다면 
					break;  
					//  break 가 와야 하는 이유는 
					//  (if(input ==k)를 벗어나서 계속 게임을 진행해야하기 때문
				}
			}
		}//while
	}
}
