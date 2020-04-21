package ch15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MySocketClient {
	
	Socket socket;
	BufferedWriter bw;
	BufferedReader br;
	
	public MySocketClient() throws Exception{
		//��Ʈ�� 
		socket = new Socket("192.168.0.70",15000); // ���������� accept �Լ� ȣ��  
		// "localhost"�Ǵ� 192.168.0.00 �� ��ӵ� ����
		bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

		br = new BufferedReader(new InputStreamReader(System.in));
		
		
		String msg = "";
		while((msg = br.readLine()) != null){
			bw.write(msg + "\n");
			System.out.println("���޽��� :" + msg);
			bw.flush();
		}
		br.close();
		socket.close();
		bw.close();
	}
	
	public static void main(String[] args) {
	 try {
		new MySocketClient();
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

}
