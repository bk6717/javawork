package ch02;

public class VarEx03 {
	public static void main(String[] args) {
		char s1 = '��'; // �⺻������ 2byte
		System.out.println(s1);

		s1 = '��';
		System.out.println(s1);

		char c1 = '��';
		char c2 = '��';
		char c3 = '��';
		System.out.print(c1); // ���տ���
		System.out.print(c2);
		System.out.print(c3);
		System.out.println();

		char[] str = { '��', '��', '��' }; // �迭 ���������͸� ������ ����
		System.out.println(str[0]);
		System.out.println(str[1]);
		System.out.println(str[2]);
		System.out.println();

		str[0] = '��';
		System.out.println(str[0]);
		//str[3] = '��' ����
	}
}