package array03;

import java.util.Random;
import java.util.Scanner;

public class UpDown {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			Random random = new Random();
			int k = random.nextInt(100); //Random class �� 0~99������ ������ ���� ����
			System.out.println("");
			System.out.println("0~99");
			int i = 1;
			
			while(true) {     //��������  n �� �Է��ϱ� ������ �ݺ��Ѵ�
				System.out.println(i + ">>");
				int input = scanner . nextInt();
				
				while(input != k) {    // ����ڰ� ������ ������ ���ߴٸ�
					if(input < k)		// ����ڰ� �Է��� �� < ������ �� (����)
						System.out.println("��ũ��");
					else if(input > k)
						System.out.println("���۰�");
					i++;
					break; // while(input != k)�� ���������� break ��
					
				}
				if(input ==k) {    // ������ ��������
					System.out.println("�¾ҽ��ϴ�.");
					System.out.println("�ٽ��Ͻðڽ��ϱ�? (y/n) >>");
					
					if(scanner.next().equals("n"))   // ���α׷� ����
						System.out.println("���ڸ��߱⸦ �����մϴ�.");
						System.exit(0);
				}
				else {  //��� ������ �Ѵٸ� 
					break;  
					//  break �� �;� �ϴ� ������ 
					//  (if(input ==k)�� ����� ��� ������ �����ؾ��ϱ� ����
				}
			}
		}//while
	}
}
