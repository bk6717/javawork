package array03;

public class ArrayEx4 {
	public static void main(String[] args) {
		// 1부터 100까지의 수중에 3의배수의 합
		int num = 0;
		for (int i = 3; i < 101; i++) {
			if(i%3==0) {
			num = num + i;
		 }
		}
		System.out.println(num);
	}
}
