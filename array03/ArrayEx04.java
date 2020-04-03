package array03;

import java.awt.font.TextHitInfo;
import java.util.Scanner;

import javax.xml.transform.Templates;

public class ArrayEx04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String tempNum = num + ""; // 숫자(num)를 문자로변환 (묵시적 형변환)
		String tempNum2[] = tempNum.split("");

		/*int len = tempNum2.length;
		for (int i = 0; i < len; i++) {
			if ((len - i) % 3 == 0 && i != 0) {
				System.out.print(",");
			}
			System.out.print(tempNum2[i]);
		}*/
		
		int p = (tempNum2.length % 3);
		
		for (int i = 0; i < tempNum2.length; i++) {
			
			if (i == 0) {
				tempNum2[i] = "" + tempNum2[i];
			}else if(i%3==p) {
				tempNum2[i] = ","+tempNum2[i];
			}
			System.out.print(tempNum2[i]);
		}
	}

}
