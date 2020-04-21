package codingdojang;

import java.util.Scanner;

//게시물의 총건수와 한 페이지에 보여줄 게시물수를 입력으로 주었을 떄 총페이지수를 리턴
public class Cd02 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		if(m%n ==0) {
			System.out.println(m/n + "페이지 필요");
		}else {
			System.out.println(m/n+1 + "페이지필요");
		}
	}
}