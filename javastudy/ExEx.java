package javastudy;

import lombok.Getter;

//��踦 ��ӹ޾Ƽ� ī��, �ʶ��Ʈ, ����, ������ Ŭ������ �����϶�

//ī���� 5000�� , �ʶ��Ʈ�� 4000��, ������ 3000��, �����δ� 3500���̴�.

//��� �̸��� ������ private ��

//���ο��� sysout�� �̿��ؼ� ��� 4������ ����϶�  ����) ī���� 5000�� �Դϴ�.



abstract class ��� {
	abstract String getName();
	abstract int getPrice();
}

class ī�� extends ���{
	private String name = "ī��";
	private int price = 5000;
	@Override
	String getName() {
		
		return name ;
	}
	@Override
	int getPrice() {
		// TODO Auto-generated method stub
		return price;
	}
}

class �ʶ��Ʈ extends ���{
	private String name = "�ʶ��Ʈ";
	private int price = 4000;
	@Override
	String getName() {
		// TODO Auto-generated method stub
		return name ;
	}
	@Override
	int getPrice() {
		// TODO Auto-generated method stub
		return price;
	}
}

class ���� extends ���{
	private String name = "����";
	private int price = 3000;
	@Override
	String getName() {
		// TODO Auto-generated method stub
		return name ;
	}
	@Override
	int getPrice() {
		// TODO Auto-generated method stub
		return price;
	}
}

class ������ extends ���{
	private String name = "������";
	private int price = 3500;
	@Override
	String getName() {
		// TODO Auto-generated method stub
		return name ;
	}
	@Override
	int getPrice() {
		// TODO Auto-generated method stub
		return price;
	}
}
//���ο��� sysout�� �̿��ؼ� ��� 4������ ����϶�  ����) ī���� 5000�� �Դϴ�.
public class ExEx {

	public static void main(String[] args) {
		��� a = new ī��();
		��� b = new �ʶ��Ʈ();
		��� c= new ����();
		��� d = new ������();
		
		System.out.println(a.getName() + "��" + a.getPrice()+"�Դϴ�.");
		System.out.println(b.getName() + "��" + b.getPrice()+"�Դϴ�.");
		System.out.println(c.getName() + "��" + c.getPrice()+"�Դϴ�.");
		System.out.println(d.getName() + "��" + d.getPrice()+"�Դϴ�.");

	}

}
