package quiz;

import java.util.HashSet;

// Math.random() �� HashSet�� �̿��Ͽ�  6�ڸ��� �ζǹ�ȣ�� ���弼��

// ����ϴ� �� System.out.println(arr);

// ���� : [1,4,15,26,36,41]

public class Quiz022 {
	public static void main(String[] args) {
		
		HashSet<Integer> arr = new HashSet<>();
	
		
		while(arr.size() < 6) {
			double a =(int) (Math.random() * 45) +1;
			arr.add((int)a);
		}System.out.println(arr);
		
		
	}
	

}
