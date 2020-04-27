package ch16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SelectEx02 {
	// select �Ҷ��� object�� �����.
	public static void main(String[] args) {
		//new �ص������� �ּҰ� ����, �����ϱⰡ �����.
		//OracleDriver o = new OracleDriver();
		//JDBC����̹� ȣ��
		try { //  ?�������� �Ľ��� ���Ѵ�.
			final String SQL = "select id,name,email,password  from users";
			//�޸𸮿� �ø�
			Class.forName("oracle.jdbc.driver.OracleDriver"); //new�� �Ǿ�����.
			
			//�������̽��� �Ǿ��ִ� ��Ʈ��(��Ʈ�� ����) 
			Connection conn = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:XE","SSAR","bitc5600");//stream
			//1521�� ������Ʈ XE�� ���� �̸�
			
			//���� �ޱ�. (?�� ����ϰ� ���ش�.)
			PreparedStatement pstmt = conn.prepareStatement(SQL);    // �����(or�� ����ؼ� �մ°�) ��� �Ľ��� ���Ѵ�.  
			
			//���ۿ� ���� (���������� �ִ�) 
			ResultSet rs = pstmt.executeQuery(); //executeQuety(ResultSet�� ���Ϲ���)
			
			List<Users> users = new ArrayList<>(); 
			while(rs.next() ) {
				Users user = new Users(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("email"), 
						rs.getString("password")
						);
				users.add(user);
			}
			for (Users user : users) {
				System.out.println(user.getId());
				System.out.println(user.getName());
				System.out.println(user.getEmail());
				System.out.println(user.getPassword());
				System.out.println();
			}
			
			System.out.println("select �Ϸ�");
		
			//�����÷��� (��ä������ ���۵ȴ�.)
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

