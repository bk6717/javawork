package array03;

public class ArrayEx4 {
	public static void main(String[] args) {
		// 1���� 100������ ���߿� 3�ǹ���� ��
		int num = 0;
		for (int i = 3; i < 101; i++) {
			if(i%3==0) {
			num = num + i;
		 }
		}
		System.out.println(num);
	}
}
