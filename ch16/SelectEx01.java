package ch16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectEx01 {
	// select 할때는 object로 만든다.
	public static void main(String[] args) {
		//new 해도되지만 주소가 없고, 관리하기가 힘들다.
		//OracleDriver o = new OracleDriver();
		//JDBC드라이버 호출
		try { //  ?를날리면 파싱을 안한다.
			final String SQL = "select id,name,email,password  from users where id = ?";
			//메모리에 올림
			Class.forName("oracle.jdbc.driver.OracleDriver"); //new가 되어있음.
			
			//인터페이스가 되어있는 스트림(스트림 연결) 
			Connection conn = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:XE","SSAR","bitc5600");//stream
			//1521은 연결포트 XE는 서비스 이름
			
			//버퍼 달기. (?를 사용하게 해준다.)
			PreparedStatement pstmt = conn.prepareStatement(SQL);    // 인잭션(or을 사용해서 뚫는것) 방어 파싱을 안한다.  
			pstmt.setInt(1, 2); //자바는 0부터시작하지만 db는 1부터 시작한다.
			
			//버퍼에 쓰기 (프로토콜이 있는) 
			ResultSet rs = pstmt.executeQuery(); //executeQuety(ResultSet을 리턴받음)
			Users users;
			if(rs.next() ) {
				users = new Users(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("email"), 
						rs.getString("password")
						);
			}
			System.out.println("select 완료");
		
			//오토플러시 (안채워져도 전송된다.)
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

