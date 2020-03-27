package array03;

import java.util.Scanner;

public class ArrayEx07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("6자리 숫자를 입력하세요.");
		int num = sc.nextInt(); // 6자리 수 입력

		String strNum = num + "";
		//System.out.println(strNum.charAt(0)); // charAt : 배열찾기
		//System.out.println(strNum.length());
		
		int len = strNum.length();
		boolean check = false;
		for (int i = 0; i < len; i++) {
			if(strNum.charAt(i)=='3') {
				check = true;
			}
		}
		
		
		if (check) {
				
					System.out.println("========");
				}else {
					System.out.println("3이없습니다.");
				}
		}
	}

