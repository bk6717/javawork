package db;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class BookList {
	Connection con; // 멤버변수 (인스턴스변수)
	Statement stmt;
	ResultSet rs;
	
//	1.변수
//	int bookid;
//	String bookname;
//	String publisher;
//	int price;
	
//	2.배열
//	int bookid_arr[] = new int[10];
//	String bookname_arr[] = new String[10];
//	String publisher_arr[] = new String[10];
//	int price_arr[] = new int[10];
	
//	3.객체 (내부클래스 (inner))
//	class Book{
//		int bookid;
//		String bookname;
//		String publisher;
//		int price;
//	}
	
//	3.객체
//	Book b1;
	
	//4.객체배열
//	Book [] b_array;
	public BookList() { // 생성자 : 인스턴스변수 초기화
//		3.객체방식
//		b1 = new Book();
		
//		4. 객체배열 초기화
//		b_array = new Book[10];
		
//		for (int i = 0; i < b_array.length; i++) {
//			b_array[i] = new Book();	
//		}
//		b_array[0] = new Book();
//		b_array[1] = new Book();
//		b_array[2] = new Book();
//		b_array[3] = new Book();
//		b_array[4] = new Book();
		
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
//	void printBook_Object() {
//		System.out.println(b1.bookid+ "\t");
//		System.out.println(b1.bookname+ "\t");
//		System.out.println(b1.publisher+ "\t");
//		System.out.println(b1.price+ "\t");
//	}
	 void printBook() {
		String query = "SELECT bookid,bookname,publisher,price FROM book"; // SQL문
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			System.out.println("bookid \tbookname \t\tpublisher \tprice");
			//int index = 0;
			while (rs.next()) {
				//1.변수
//				bookid = rs.getInt(1);
//				bookname = rs.getString(2);
//				publisher = rs.getString(3);
//				price = rs.getInt(4);
				
				System.out.print(rs.getInt(1));
				System.out.print("\t" + rs.getString(2));
				System.out.print("\t\t" + rs.getString(3));
				System.out.println("\t" + rs.getInt(4)); 
				
//				3.객체
//				b1.bookid = rs.getInt(1);
//				b1.bookname = rs.getString(2);
//				b1.publisher = rs.getString(3);
//				b1.price = rs.getInt(4);
				
//				4.객체배열
//				b_array[index].bookid = rs.getInt(1);
//				b_array[index].bookname = rs.getString(2);
//				b_array[index].publisher = rs.getString(3);
//				b_array[index].price = rs.getInt(4);
//				index ++;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
	}
}
