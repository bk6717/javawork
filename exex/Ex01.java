package exex;
//����� ������ ¦�̵ǵ��� �Ʒ��� ���� �迭�� �����
//�����̸����� ������ �ݺ��Ͽ� ��ȸ�Ҽ� �ֵ���

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		String course[] = {"Java", "C++" , "HTML5" , "��ǻ�ͱ���", "�ȵ���̵�"};
		int score[] = {95,88,76,62,55};
		int a;
		
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println();
		for (int i = 0; i < score.length; i++) {
			a= sc.nextInt();
			System.out.println(course[a]+"�� ������"+score[a]+ "�Դϴ�.");
		}
	}
}

