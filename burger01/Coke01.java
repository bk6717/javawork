package burger01;

import org.omg.CORBA.PUBLIC_MEMBER;

import composite.Coke;
import lombok.Data;
@Data
public class Coke01 {
	private int price;
	private String desc;
	
	public Coke01() {
		this(1000,"콜라");
	}
 	public Coke01(int price, String desc) {
		this.price = price;
		this.desc = desc;
		System.out.println(desc+"가 나왔습니다.");
		System.out.println("가격은"+price+"원 입니다.");
	
	}
 	public static void main(String[] args) {
 		Coke01 c11 = new Coke01();
	}
}
