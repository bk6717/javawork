package coffeeshop.test;

import lombok.Data;
//
class data <T>{   // 대문자로 한다
	T value;
}

class Str<K,V>{
	K k;
	V v;
}
// Generic 일반적인 - 클래스 생성시 타입 결정
public class GenericEx01 {
	public static void main(String[] args) {
        data<String>data = new data();
		data.value = "문자열";
		System.out.println(data.value);
		
		data<Integer> data2 = new data();
		data2.value = 10;
		System.out.println(data2.value);
	
		Str<String , String> s = new Str<String, String>();
		s.k = "비밀번호";
		s.v = "bitc 5500";
		
		System.out.println(s.k);
		System.out.println(s.v);
	}
}
