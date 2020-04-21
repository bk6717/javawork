package burger01;

public class Burger01 {
	private int price; // 가격
	private String desc; //버거 종류 
	
	public Burger01() {
		this(1500,"기본버거");
	}
	
	//최종 목적지
	public Burger01(int price, String desc) {
		this.price = price;
		this.desc = desc;
		System.out.println(desc + "가 나왔습니다.");
		System.out.println("가격은"+price +"원 입니다.");
	}
}
