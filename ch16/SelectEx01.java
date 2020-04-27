package ch16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectEx01 {
	// select �Ҷ��� object�� �����.
	public static void main(String[] args) {
		//new �ص������� �ּҰ� ����, �����ϱⰡ �����.
		//OracleDriver o = new OracleDriver();
		//JDBC����̹� ȣ��
		try { //  ?�������� �Ľ��� ���Ѵ�.
			final String SQL = "select id,name,email,password  from users where id = ?";
			//�޸𸮿� �ø�
			Class.forName("oracle.jdbc.driver.OracleDriver"); //new�� �Ǿ�����.
			
			//�������̽��� �Ǿ��ִ� ��Ʈ��(��Ʈ�� ����) 
			Connection conn = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:XE","SSAR","bitc5600");//stream
			//1521�� ������Ʈ XE�� ���� �̸�
			
			//���� �ޱ�. (?�� ����ϰ� ���ش�.)
			PreparedStatement pstmt = conn.prepareStatement(SQL);    // �����(or�� ����ؼ� �մ°�) ��� �Ľ��� ���Ѵ�.  
			pstmt.setInt(1, 2); //�ڹٴ� 0���ͽ��������� db�� 1���� �����Ѵ�.
			
			//���ۿ� ���� (���������� �ִ�) 
			ResultSet rs = pstmt.executeQuery(); //executeQuety(ResultSet�� ���Ϲ���)
			Users users;
			if(rs.next() ) {
				users = new Users(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("email"), 
						rs.getString("password")
						);
			}
			System.out.println("select �Ϸ�");
		
			//�����÷��� (��ä������ ���۵ȴ�.)
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

