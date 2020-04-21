package exex;

import java.util.Scanner;

public class EXEXEXEXE {

	public static void main(String[] args) {
		int a ;
		int b ; 
		int c ; 
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자입력 >>");
		
		a = sc.nextInt();

		for (int i = 1; i < 10; i++) {
			System.out.println(Math.pow (a, i));
		}
	}
}
