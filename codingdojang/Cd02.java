package codingdojang;

import java.util.Scanner;

//�Խù��� �ѰǼ��� �� �������� ������ �Խù����� �Է����� �־��� �� ������������ ����
public class Cd02 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		if(m%n ==0) {
			System.out.println(m/n + "������ �ʿ�");
		}else {
			System.out.println(m/n+1 + "�������ʿ�");
		}
	}
}