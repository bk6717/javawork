package ch16;

class MyConnection{
	
}

class MyJDBC extends MyConnection{
	
	
	static MyConnection conn;
	
	public MyJDBC() {
		
		
		System.out.println("생성자 호출");
	}
	//new 할때 static 내부가 호출됨.
	static{ //static 에 이름이없으면 객체생성시 초기화
		conn = new MyJDBC();
	}
}

public class TestEx01 {
	public static void main(String[] args) {
		//MyJDBC mj = new MyJDBC();
		try {
			Class.forName("ch16.MyJDBC");
			MyConnection conn = MyJDBC.conn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
