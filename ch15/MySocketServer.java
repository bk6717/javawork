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

	// throws�� �Լ��� ��� ������ try catch�� �ʿ��� ��� ����ϸ� �ȴ�
	public MySocketServer() throws Exception { // throws �� �Լ��� ȣ���� �ڿ��� ������ ���̴�

		serverSocket = new ServerSocket(15000); // ���� ���� ���� (������ �޴�)
		socket = serverSocket.accept(); // ��û�� ��� - ������ �Ǹ� ������ �����ϰ� �������Ͽ� ����� ���� ���´�
		System.out.println("��û�� ����");
		
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		String msg = "";
		while ((msg = br.readLine()) != null) {
		System.out.println("���� : " + msg);
		}

		br.close();
		socket.close();
		serverSocket.close();
	}

	public static void main(String[] args) {
		
		try { // main�� �Լ��� ȣ�� �߱� ������ ���⼭ Ʈ����ĳġ�� ���
			new MySocketServer();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}