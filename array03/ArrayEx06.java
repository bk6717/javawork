package array03;

import java.util.Scanner;

public class Array05 {
// ���� 100000000 �� �Է¹ް� 3�ڸ����� �޸� �� ���!
// 1,000,000,000
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String tempNum = num+"";  //����(num)�� ���ڷκ�ȯ (������ ����ȯ)
		String tempNum2[] = tempNum.split("");
		//System.out.println(tempNum2[3]);
		//System.out.println("���� : "+tempNum2.length); // �迭�� ����
		for (int i = 0; i <tempNum2.length; i++) {
			System.out.print(tempNum2[i]);
			if(i % 3 == 0) {
				System.out.print(",");	
			}
		}
		
	}
}
