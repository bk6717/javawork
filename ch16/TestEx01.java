package ch16;

class MyConnection{
	
}

class MyJDBC extends MyConnection{
	
	
	static MyConnection conn;
	
	public MyJDBC() {
		
		
		System.out.println("������ ȣ��");
	}
	//new �Ҷ� static ���ΰ� ȣ���.
	static{ //static �� �̸��̾����� ��ü������ �ʱ�ȭ
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
