package dateex;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Lotto {
	public static void main(String[] args) {
		// 6개의 번호 (1~45)

		Set<Integer> lottoSet = new HashSet<>();//Set 은
		Random r = new Random();
		
		
		while (lottoSet.size() < 6 ) {
			int value = r.nextInt(45)+1 ; //1~ 45 사이의 숫자 출력
			lottoSet.add(value);
		}System.out.println(lottoSet);
	}
}
