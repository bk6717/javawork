package burger01;


public class FrenchFried01 {
	private int price;
	private String desc;
	
	public FrenchFried01() {
		this(1200,"����Ƣ��");
	}
	public  FrenchFried01(int price, String desc) {
		this.price = price;
		this.desc = desc;
		System.out.println(desc+"�� ����������ϴ�.");
		System.out.println("������"+price+"�� �Դϴ�.");		
	}
	public static void main(String[] args) {
		FrenchFried01 ff = new FrenchFried01();
	}
}
