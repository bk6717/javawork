package composite;

import lombok.Data;

@Data  // getter , setter ���� 
public class Burger {
	private int price;
	private String desc;
	
	public Burger() {
		this(1500, "�⺻ ����"); // ȣ���ϸ� �ڵ����� burger �� ȣ���ϰԵ�
	}
	//���� ������.
	public Burger(int price, String desc) {
		this.price = price;
		this.desc = desc;
		System.out.println(desc +"�� ����������ϴ�.");
	}
	
	
}