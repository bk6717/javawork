package codingdojang;

import java.util.Scanner;
//!���α׷� ������� 
//1.�Է��� ������ ������ ����ڷκ��� �Է�
//2.�Է¹��� ������ ������ŭ ���� �Է�
//3.�Է¹��� ������ �հ� ��հ��� ���
//4. �޸𸮰��� ���

//!�䱸����
//1.�޸𸮰����� ������� �Է� ���� ���� �����ȴ�.
//2.����� ������ �������� ������Ѵ�.
//3. �迭�� ����ϸ� �ȵ�
public class Cd04 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	double a = 0;
	double sum = 0;
	double avg = 0;
	double count = 0;
	
	
	while (true) {
		a = sc.nextInt();
		if(a == -1) break;
		sum += a;
		count++;
		avg = sum/count;
	}System.out.println(avg);
	
		
}	
}

