package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CustomerList {
//	1.멤버변수
	private Connection con; // 멤버변수
//	private Statement stmt;
//	private ResultSet rs;
//	
//	//1.멤버변수
//	private int custid;
//	private String name;
//	private String address;
//	private String phone;
	
//	2.배열	
//	int custid2[];
//	String name2[];
//	String address2[];
//	String phone2[];

// 3.객체  객체초기화 
	Customer cs;
	
	public CustomerList() { // 생성자 : 인스턴스변수 초기화
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		// 11g express edition은 orcl 대신 xe를 입력한다.
		String userid = "c##madang"; // sql에서 c##으로 만들었기떄문
		String pwd = "c##madang";

		try { // 드라이버를 찾는 과정
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 오타조심
			System.out.println("드라이버 로드 성공");
		} catch (Exception e) { 
			e.printStackTrace();
		}
						
		try { // 데이터베이스 연결하는 과정
			System.out.println("데이터베이스 연결준비....");
			con = DriverManager.getConnection(url, userid, pwd);
			System.out.println("데이터베이스 연결성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void printCustomer() { // 메서드 : 동작 // DB로부터 들고오는것
		// 데이터 베이스에 질문을 날려서 출력을 해준다.
		String query = "SELECT * FROM customer"; // SQL문
		try {
			Statement stmt = con.createStatement(); // 준비작업 객체 만듬
			ResultSet rs = stmt.executeQuery(query); // 데이터 결과값이 들어오게 한다.
			System.out.println("custid \tname \t\taddress \tphone");
			while (rs.next()) { // rs에 있는 메서드를 꺼낸다.
				// next 는 한 줄씩읽는다 (튜플단위로)
				
				// 꺼낼때 무슨형으로 꺼낼지
				System.out.print(rs.getInt(1));
				System.out.print("\t" + rs.getString(2));
				System.out.print("\t\t" + rs.getString(3));
				System.out.println("\t" + rs.getString(4));
				
//				custid  = rs.getInt(1);
//				name    = rs. getString(2);
//				address = rs.getString(3);
//				phone   = rs.getString(4);
				
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("=========================================================");
	}
//	1.변수
//	public void print1() {
//		System.out.println(custid);
//		System.out.println(name);
//		System.out.println(address);
//		System.out.println(phone);
//	}
 

//  2. 배열	
//	void print2(){
//		for (int index = 0; index < 5; index++) {
//
//			System.out.println(custid2[index] + "\t");
//			System.out.println(name2[index] + "\t");
//			System.out.println(address2[index] + "\t");
//			System.out.println(phone2[index] + "\t");	
//		}
//	}
public static void main(String[] args) {
	CustomerList c1 = new CustomerList();
}
}
