package ch01;

import java.util.Scanner;

// �����Է����α׷�
public class LogicalOperator {

	public static void main(String[] args) {
		System.out.println("������ �Է��ϼ��� :");
		Scanner sc= new Scanner(System.in);
		int point = sc.nextInt(); //���� �Է¹ޱ�
		
		if(point <=100 && point >= 90) {
			System.out.println("A�����Դϴ�.");
		}else if(point <=89 && point >= 80) {
			System.out.println("B�����Դϴ�.");
		}else if(point <=79 && point >= 70) {
			System.out.println("C�����Դϴ�.");
		}else if(point <=69 && point >= 60) {
			System.out.println("D�����Դϴ�.");
		}else if(point <=59 && point >=0){
			System.out.println("F�����Դϴ�.");
		}else {
			System.out.println("�߸��� �Է��� �ֽ��ϴ�.");
			}
		}
	}

