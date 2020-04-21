package ch08;

import java.io.IOException;
import java.io.InputStream;
//steam 은 byte --> 물의 흐름
//물이 흐를떄 수도꼭지를 담궈두면 물이 흐르지 않는다.
//물이 흐를때 수도꼭지를 열면 물이 흐른다 (통신 시작)
//물 = 바이트
public class InputEx01 {
	
	public static void main(String[] args) {
	InputStream in = System.in; //키보드에 연결된 byte 스트림 
	try {
		int data = in.read();
		System.out.println((char)data);
	} catch (IOException e) {  
	// 문제가 발생했을때 힙공간을 만들고,어떤 오류가 발생했는지 만들어준다.
		System.out.println("IO 오류가 발생");
		e.getMessage();
		// 어떤오류가 발생했는지 말해준다.
		e.printStackTrace(); 
		// 위 오류로 인해서 어떤오류가 발생했는지 부가적인것까지 말해준다
	}  
	}

}
