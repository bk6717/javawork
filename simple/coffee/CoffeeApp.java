package simple.coffee;

import java.util.ArrayList;

public class CoffeeApp {
	public static void main(String[] args) {

		// �ٸ���Ÿ, �մ�
		Comsumer comsumer = new Comsumer();
		Barista barista = new Barista();
		

		// �޴� ������ �޴��� ����Ʈ�� �ڷḦ �ִ� ���� �ٸ���Ÿ�� ��������
		// �����ϰ� �ϱ����ؼ� ���ο��� �ۼ��Ѵ�
		
		// ���� �޴� ����
		MenuItem m1 = new MenuItem("�Ƹ޸�ī��", 1500);
		MenuItem m2 = new MenuItem("ī���", 2500);
		MenuItem m3 = new MenuItem("īǪġ��", 4000);

		// ��� ����Ʈ�� �ڷ� �Է� .add
		ArrayList<MenuItem> menuItems = new ArrayList<>();
		menuItems.add(m1);
		menuItems.add(m2);
		menuItems.add(m3);

		// ��̸���Ʈ �ڷḦ ����Ҷ� .get
		System.out.println(menuItems.get(1).getName());
		System.out.println();
		
		
		// �޴� ����
		Menu menu = new Menu(menuItems);
		
		comsumer.�ֹ�("�Ƹ޸�ī��", menu, barista);
	}
}