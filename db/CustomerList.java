package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CustomerList {
//	1.�������
	private Connection con; // �������
//	private Statement stmt;
//	private ResultSet rs;
//	
//	//1.�������
//	private int custid;
//	private String name;
//	private String address;
//	private String phone;
	
//	2.�迭	
//	int custid2[];
//	String name2[];
//	String address2[];
//	String phone2[];

// 3.��ü  ��ü�ʱ�ȭ 
	Customer cs;
	
	public CustomerList() { // ������ : �ν��Ͻ����� �ʱ�ȭ
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
	
	void printCustomer() { // �޼��� : ���� // DB�κ��� �����°�
		// ������ ���̽��� ������ ������ ����� ���ش�.
		String query = "SELECT * FROM customer"; // SQL��
		try {
			Statement stmt = con.createStatement(); // �غ��۾� ��ü ����
			ResultSet rs = stmt.executeQuery(query); // ������ ������� ������ �Ѵ�.
			System.out.println("custid \tname \t\taddress \tphone");
			while (rs.next()) { // rs�� �ִ� �޼��带 ������.
				// next �� �� �پ��д´� (Ʃ�ô�����)
				
				// ������ ���������� ������
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
//	1.����
//	public void print1() {
//		System.out.println(custid);
//		System.out.println(name);
//		System.out.println(address);
//		System.out.println(phone);
//	}
 

//  2. �迭	
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
