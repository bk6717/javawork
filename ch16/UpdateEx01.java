package ch16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateEx01 {

	public static void main(String[] args) {
		//new 해도되지만 주소가 없고, 관리하기가 힘들다.
		//OracleDriver o = new OracleDriver();
		//JDBC드라이버 호출
		try { //  ?를날리면 파싱을 안한다.
			final String SQL = "update users set password = ? where id = ?";
			//메모리에 올림
			Class.forName("oracle.jdbc.driver.OracleDriver"); //new가 되어있음.
			//인터페이스가 되어있는 스트림(스트림 연결) 
			Connection conn = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:XE","SSAR","bitc5600");//stream
			//1521은 연결포트 XE는 서비스 이름
			//버퍼 달기. (?를 사용하게 해준다.)
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, "5678"); 
			pstmt.setInt(2, 2);
			//버퍼에 쓰기 (프로토콜이 있는)  내부적으로 commit 이 달려있다.
			pstmt.executeUpdate(); //쓰는것 , 플러쉬가 자동으로됨
			System.out.println("update 완료");
			//오토플러시 (안채워져도 전송된다.)
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

	//DBMS로 문장을 날리고 읽을려면 파서가 필요하다. 
	//jdbc 인터페이스 자바와 db를 연결하는 