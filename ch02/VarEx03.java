package ch02;

public class VarEx03 {
	public static void main(String[] args) {
		char s1 = '가'; // 기본적으로 2byte
		System.out.println(s1);

		s1 = '나';
		System.out.println(s1);

		char c1 = '가';
		char c2 = '나';
		char c3 = '다';
		System.out.print(c1); // 결합연산
		System.out.print(c2);
		System.out.print(c3);
		System.out.println();

		char[] str = { '가', '나', '다' }; // 배열 같은데이터를 여러번 연속
		System.out.println(str[0]);
		System.out.println(str[1]);
		System.out.println(str[2]);
		System.out.println();

		str[0] = '라';
		System.out.println(str[0]);
		//str[3] = '파' 오류
	}
}
