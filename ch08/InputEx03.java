package ch08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputEx03 {
	public static void main(String[] args) {

		InputStream in = System.in; // 키보드에 연결된 byte 스트림
		
		InputStreamReader reader = new InputStreamReader(in);

		BufferedReader br = new BufferedReader(reader);

		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));

		String data = "";
		try {
			while((data = br2.readLine()) != null) { // 버퍼에 아무것도 없을때 실행된다.는의미
				
				System.out.println(data); // 초기화 해주지 않으면 오류가 난다.
				// 버퍼를 비울때 readLine
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}