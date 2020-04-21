package javastudy;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import lombok.Data;

public class Bufff {
public static void main(String[] args) {
	InputStream in = System.in;
	//캐스팅하지 않아도 문자로 받을 수 있다.
	InputStreamReader reader = new InputStreamReader(in);
	char[] data = new char[3];
	try {
		reader.read(data);
		System.out.println(data);
	} catch (IOException e) {
		System.out.println("오류 발생");
		e.printStackTrace();
	}
}
}
