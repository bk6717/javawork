package composite;

public class ShBurger extends Burger{

	public ShBurger(){
		super(5000,"쉬림프 버거");
	}
	public ShBurger(int price, String desc) {
		
		super(price, desc);
		System.out.println();
	}
	public static void main(String[] args) {
		ShBurger s1 = new ShBurger();
		System.out.println(s1.getPrice());
		
	}
}
