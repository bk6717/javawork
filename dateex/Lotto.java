package dateex;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Lotto {
	public static void main(String[] args) {
		// 6���� ��ȣ (1~45)

		Set<Integer> lottoSet = new HashSet<>();//Set ��
		Random r = new Random();
		
		
		while (lottoSet.size() < 6 ) {
			int value = r.nextInt(45)+1 ; //1~ 45 ������ ���� ���
			lottoSet.add(value);
		}System.out.println(lottoSet);
	}
}