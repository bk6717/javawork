package burger01;

import org.omg.CORBA.PUBLIC_MEMBER;

import composite.Coke;
import lombok.Data;
@Data
public class Coke01 {
	private int price;
	private String desc;
	
	public Coke01() {
		this(1000,"�ݶ�");
	}
 	public Coke01(int price, String desc) {
		this.price = price;
		this.desc = desc;
		System.out.println(desc+"�� ���Խ��ϴ�.");
		System.out.println("������"+price+"�� �Դϴ�.");
	
	}
 	public static void main(String[] args) {
 		Coke01 c11 = new Coke01();
	}
}
