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
	
	ServerSocket severSocket;   //넓은공간에서 쓸거면 전역으로 
	Vector<NewSocketThread> vt;   // 전역이기때문에 외부클래스에서 쓸수있다.
	
	public MySocketServer() throws IOException {
		vt =new Vector<>(); 
		severSocket = new ServerSocket(3000);
	
	while(true) {  
		Socket socket = severSocket.accept();    //서버소켓을만들고 대기한다
		System.out.println("요청이 들어옴");    
		NewSocketThread nt = new NewSocketThread(socket); // 만들어진 소켓을 넘긴다.
		Thread newWorker = new Thread(nt);
		newWorker.start();
		vt.add(nt);    // 벡터에 클래스를 담아둠.
	}
	
	}
	//새로운 쓰레드에게 버퍼를 연결할 수 있게 socket을 전달!1
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
				System.out.println("클라이언트 : " + msg);
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
//새로운스래드 역할
//  버퍼를 달고 통신함
// 상대방으로부터 메세지가오면 누구에게 보내줄지 결정