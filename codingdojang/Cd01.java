package codingdojang;

public class Cd01 {
	
public static void main(String[] args) {
	//1000�̸��� �ڿ��� , for 1~1000 
	// 3,5�� ���       if (a%3 == 0)
	//����				sum
	int sum = 0;
	//1000�̸��� �ڿ������� 3,5�� ����� ������ ���϶�.
	for (int i = 1; i < 1000; i++) {
		if(i%3==0 || i%5==0) {
			sum += i;
		}
	}
	System.out.println(sum);
}
}
