package ch16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteEx01 {

	public static void main(String[] args) {
		//new �ص������� �ּҰ� ����, �����ϱⰡ �����.
		//OracleDriver o = new OracleDriver();
		//JDBC����̹� ȣ��
		try { //  ?�������� �Ľ��� ���Ѵ�.
			final String SQL = "delete from users where id = ?";
			//�޸𸮿� �ø�
			Class.forName("oracle.jdbc.driver.OracleDriver"); //new�� �Ǿ�����.
			//�������̽��� �Ǿ��ִ� ��Ʈ��(��Ʈ�� ����) 
			Connection conn = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:XE","SSAR","bitc5600");//stream
			//1521�� ������Ʈ XE�� ���� �̸�
			//���� �ޱ�. (?�� ����ϰ� ���ش�.)
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, 1); //�ڹٴ� 0���ͽ��������� db�� 1���� �����Ѵ�.
			//���ۿ� ���� (���������� �ִ�)  ���������� commit �� �޷��ִ�.
			pstmt.executeUpdate(); //���°� , �÷����� �ڵ����ε�
			System.out.println("delete �Ϸ�");
			//�����÷��� (��ä������ ���۵ȴ�.)
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

	//DBMS�� ������ ������ �������� �ļ��� �ʿ��ϴ�. 
	//jdbc �������̽� �ڹٿ� db�� �����ϴ� 