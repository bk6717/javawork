package codingdojang;

import java.util.Scanner;
//!프로그램 실행순서 
//1.입력할 정수의 개숫를 사용자로부터 입력
//2.입력받은 정수의 개수만큼 정수 입력
//3.입력받은 정수의 합과 평균값을 출력
//4. 메모리공간 비움

//!요구사항
//1.메모리공간은 사용자의 입력 수의 따라 변동된다.
//2.사용한 공간은 마지막에 비워야한다.
//3. 배열을 사용하면 안됨
public class Cd04 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	double a = 0;
	double sum = 0;
	double avg = 0;
	double count = 0;
	
	
	while (true) {
		a = sc.nextInt();
		if(a == -1) break;
		sum += a;
		count++;
		avg = sum/count;
	}System.out.println(avg);
	
		
}	
}

