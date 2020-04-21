package burger01;


public class FrenchFried01 {
	private int price;
	private String desc;
	
	public FrenchFried01() {
		this(1200,"감자튀김");
	}
	public  FrenchFried01(int price, String desc) {
		this.price = price;
		this.desc = desc;
		System.out.println(desc+"이 만들어졌습니다.");
		System.out.println("가격은"+price+"원 입니다.");		
	}
	public static void main(String[] args) {
		FrenchFried01 ff = new FrenchFried01();
	}
}
