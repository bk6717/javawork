package burger01;

public class Burger01 {
	private int price; // ����
	private String desc; //���� ���� 
	
	public Burger01() {
		this(1500,"�⺻����");
	}
	
	//���� ������
	public Burger01(int price, String desc) {
		this.price = price;
		this.desc = desc;
		System.out.println(desc + "�� ���Խ��ϴ�.");
		System.out.println("������"+price +"�� �Դϴ�.");
	}
}
