package coffeeshop.test;

import lombok.Data;
//
class data <T>{   // �빮�ڷ� �Ѵ�
	T value;
}

class Str<K,V>{
	K k;
	V v;
}
// Generic �Ϲ����� - Ŭ���� ������ Ÿ�� ����
public class GenericEx01 {
	public static void main(String[] args) {
        data<String>data = new data();
		data.value = "���ڿ�";
		System.out.println(data.value);
		
		data<Integer> data2 = new data();
		data2.value = 10;
		System.out.println(data2.value);
	
		Str<String , String> s = new Str<String, String>();
		s.k = "��й�ȣ";
		s.v = "bitc 5500";
		
		System.out.println(s.k);
		System.out.println(s.v);
	}
}
