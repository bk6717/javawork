package ch08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

//캐스팅을 하지않고 문자로 읽는...
//한개 이상을 받고싶을때. 
public class InputEx02 {

	public static void main(String[] args) {
		InputStream in = System.in;
		InputStreamReader reader = new InputStreamReader(in); 
		BufferedReader br1 = new BufferedReader(reader);
		// 위 세줄을  아래 한줄로 변경!
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		String data = "";
		try {
			while((data = br1.readLine()) != null)
				
				System.out.println(data);
		} catch (IOException e) {
			e.printStackTrace();
		}     //배열은 레퍼런스 자료형 (힙)
	}
}
