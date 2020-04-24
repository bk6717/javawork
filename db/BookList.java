package db;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class BookList {
	Connection con; // ������� (�ν��Ͻ�����)
	Statement stmt;
	ResultSet rs;
	
//	1.����
//	int bookid;
//	String bookname;
//	String publisher;
//	int price;
	
//	2.�迭
//	int bookid_arr[] = new int[10];
//	String bookname_arr[] = new String[10];
//	String publisher_arr[] = new String[10];
//	int price_arr[] = new int[10];
	
//	3.��ü (����Ŭ���� (inner))
//	class Book{
//		int bookid;
//		String bookname;
//		String publisher;
//		int price;
//	}
	
//	3.��ü
//	Book b1;
	
	//4.��ü�迭
//	Book [] b_array;
	public BookList() { // ������ : �ν��Ͻ����� �ʱ�ȭ
//		3.��ü���
//		b1 = new Book();
		
//		4. ��ü�迭 �ʱ�ȭ
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
		// 11g express edition�� orcl ��� xe�� �Է��Ѵ�.
		String userid = "c##madang"; // sql���� c##���� ������⋚��
		String pwd = "c##madang";

		try { // ����̹��� ã�� ����
			Class.forName("oracle.jdbc.driver.OracleDriver"); // ��Ÿ����
			System.out.println("����̹� �ε� ����");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try { // �����ͺ��̽� �����ϴ� ����
			System.out.println("�����ͺ��̽� �����غ�....");
			con = DriverManager.getConnection(url, userid, pwd);
			System.out.println("�����ͺ��̽� ���Ἲ��");
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
		String query = "SELECT bookid,bookname,publisher,price FROM book"; // SQL��
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			System.out.println("bookid \tbookname \t\tpublisher \tprice");
			//int index = 0;
			while (rs.next()) {
				//1.����
//				bookid = rs.getInt(1);
//				bookname = rs.getString(2);
//				publisher = rs.getString(3);
//				price = rs.getInt(4);
				
				System.out.print(rs.getInt(1));
				System.out.print("\t" + rs.getString(2));
				System.out.print("\t\t" + rs.getString(3));
				System.out.println("\t" + rs.getInt(4)); 
				
//				3.��ü
//				b1.bookid = rs.getInt(1);
//				b1.bookname = rs.getString(2);
//				b1.publisher = rs.getString(3);
//				b1.price = rs.getInt(4);
				
//				4.��ü�迭
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
