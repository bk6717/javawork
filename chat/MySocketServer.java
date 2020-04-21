package chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class MySocketServer {
	
	ServerSocket severSocket;   //������������ ���Ÿ� �������� 
	Vector<NewSocketThread> vt;   // �����̱⶧���� �ܺ�Ŭ�������� �����ִ�.
	
	public MySocketServer() throws IOException {
		vt =new Vector<>(); 
		severSocket = new ServerSocket(3000);
	
	while(true) {  
		Socket socket = severSocket.accept();    //��������������� ����Ѵ�
		System.out.println("��û�� ����");    
		NewSocketThread nt = new NewSocketThread(socket); // ������� ������ �ѱ��.
		Thread newWorker = new Thread(nt);
		newWorker.start();
		vt.add(nt);    // ���Ϳ� Ŭ������ ��Ƶ�.
	}
	
	}
	//���ο� �����忡�� ���۸� ������ �� �ְ� socket�� ����!1
class NewSocketThread implements Runnable{
	
	Socket socket;
	
	public  NewSocketThread(Socket socket) {
		this.socket = socket;
	}
	BufferedWriter bw;
	BufferedReader br;
	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		
			String msg = "";
			while((msg = br.readLine()) != null) {
				System.out.println("Ŭ���̾�Ʈ : " + msg);
				for(NewSocketThread newSocketThread : vt) {
					if(newSocketThread != this) {
						newSocketThread.bw.write(msg + "\n");
						newSocketThread.bw.flush();
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	}
public static void main(String[] args) {
	
}
}
//���ο���� ����
//  ���۸� �ް� �����
// �������κ��� �޼��������� �������� �������� ����