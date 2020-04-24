package codingdojang;

import java.util.ArrayList;
import java.util.Scanner;

//양의정수와 음의 정수를 마지고있는 배열 
//음의 정수는 앞쪽에 양의정수는 뒷쪽에  
//양의정수와 음의정수의 순서에는 변함이 없어야 한다.
//-1 1 3 -2 2 ans -1 -2 1 3 2 
public class Cd03 {
	
	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		ArrayList<Integer> arrayList1 = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in);
		arrayList.add(sc.nextInt());
		for (int i = 0; i < 5; i++) {
			arrayList.add(sc.nextInt());
		}
		System.out.println(arrayList.toString());

		for (int i = 0; i < arrayList.size(); i++) {
			if (arrayList.get(i) < 0) {
				arrayList1.add(arrayList.get(i));
			}
		}
		System.out.println(arrayList1);
		
		for (int i = 0; i < arrayList.size(); i++) {
			if (arrayList.get(i) >= 0) {
				arrayList1.add(arrayList.get(i));
			}
		}
		System.out.println(arrayList1);
	}
}
