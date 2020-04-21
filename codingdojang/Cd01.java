package codingdojang;

public class Cd01 {
	
public static void main(String[] args) {
	//1000미만의 자연수 , for 1~1000 
	// 3,5의 배수       if (a%3 == 0)
	//총합				sum
	int sum = 0;
	//1000미만의 자연수에서 3,5의 배수의 총합을 구하라.
	for (int i = 1; i < 1000; i++) {
		if(i%3==0 || i%5==0) {
			sum += i;
		}
	}
	System.out.println(sum);
}
}
