package array03;

import java.util.Scanner;

public class Array05 {
// 숫자 100000000 을 입력받고 3자리마다 콤마 찍어서 출력!
// 1,000,000,000
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String tempNum = num+"";  //숫자(num)를 문자로변환 (묵시적 형변환)
		String tempNum2[] = tempNum.split("");
		//System.out.println(tempNum2[3]);
		//System.out.println("길이 : "+tempNum2.length); // 배열의 길이
		for (int i = 0; i <tempNum2.length; i++) {
			System.out.print(tempNum2[i]);
			if(i % 3 == 0) {
				System.out.print(",");	
			}
		}
		
	}
}
