package ch16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateEx01 {

	public static void main(String[] args) {
		//new �ص������� �ּҰ� ����, �����ϱⰡ �����.
		//OracleDriver o = new OracleDriver();
		//JDBC����̹� ȣ��
		try { //  ?�������� �Ľ��� ���Ѵ�.
			final String SQL = "update users set password = ? where id = ?";
			//�޸𸮿� �ø�
			Class.forName("oracle.jdbc.driver.OracleDriver"); //new�� �Ǿ�����.
			//�������̽��� �Ǿ��ִ� ��Ʈ��(��Ʈ�� ����) 
			Connection conn = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:XE","SSAR","bitc5600");//stream
			//1521�� ������Ʈ XE�� ���� �̸�
			//���� �ޱ�. (?�� ����ϰ� ���ش�.)
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, "5678"); 
			pstmt.setInt(2, 2);
			//���ۿ� ���� (���������� �ִ�)  ���������� commit �� �޷��ִ�.
			pstmt.executeUpdate(); //���°� , �÷����� �ڵ����ε�
			System.out.println("update �Ϸ�");
			//�����÷��� (��ä������ ���۵ȴ�.)
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

	//DBMS�� ������ ������ �������� �ļ��� �ʿ��ϴ�. 
	//jdbc �������̽� �ڹٿ� db�� �����ϴ� 