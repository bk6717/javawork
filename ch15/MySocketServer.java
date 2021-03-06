package ch15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MySocketServer {

	ServerSocket serverSocket;
	Socket socket;
	BufferedReader br;

	// throws는 함수의 모든 내용이 try catch가 필요한 경우 사용하면 된다
	public MySocketServer() throws Exception { // throws 는 함수를 호출한 자에게 던지는 것이다

		serverSocket = new ServerSocket(15000); // 서버 소켓 생성 (연결을 받는)
		socket = serverSocket.accept(); // 요청을 대기 - 연결이 되면 소켓을 리턴하고 서버소켓에 연결된 선을 끊는다
		System.out.println("요청이 들어옴");
		
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		String msg = "";
		while ((msg = br.readLine()) != null) {
		System.out.println("상대방 : " + msg);
		}

		br.close();
		socket.close();
		serverSocket.close();
	}

	public static void main(String[] args) {
		
		try { // main이 함수를 호출 했기 때문에 여기서 트라이캐치를 사용
			new MySocketServer();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}