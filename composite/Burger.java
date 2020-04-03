package composite;

import lombok.Data;

@Data  // getter , setter 생성 
public class Burger {
	private int price;
	private String desc;
	
	public Burger() {
		this(1500, "기본 버거"); // 호출하면 자동으로 burger 를 호출하게됨
	}
	//최종 목적지.
	public Burger(int price, String desc) {
		this.price = price;
		this.desc = desc;
		System.out.println(desc +"가 만들어졌습니다.");
	}
	
	
}
