package array03;

import java.util.Scanner;

public class ArrayEx08 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("대문자를 입력하세요.");
		String input =  sc.next();
		
		int num = (int)(input.charAt(0));
		
		for (int i = num+1; i < 91; i++) {
			System.out.print((char)i+" ");
		}
		}
	}

