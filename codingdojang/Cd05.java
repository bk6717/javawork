package codingdojang;

import java.util.Scanner;
// 5���� ������ �Է¹ް� ����� �����ϰ��� ���� 
public class Cd05 {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a;
		int sum = 0;
		
		for (int i = 0; i < 5; i++) {
			a = sc.nextInt();
			if (a <0) {
				continue;
			}else
			sum += a;
		}System.out.println(sum);
	}
}
