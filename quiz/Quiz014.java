package quiz;

import java.util.Scanner;

// while �� ������ ������ ���� ������ �ݺ��Ͽ� ����Ѵ�.

// ���ڸ� �Է��ϸ� �Է��� ���ڸ�ŭ "�ȳ��ϼ���"�� ����϶�

public class Quiz014 {
	
	public static void main(String[] args) {
		System.out.println("���ڸ� �Է��ϼ���");
		Scanner sc = new Scanner(System.in);
		int a;
		a = sc.nextInt();
		
		while(a > 0) {
			for (int i = 0; i < a; i++) {
				System.out.println("�ȳ��ϼ���");
			}break;
		}
		
		
	}
}
