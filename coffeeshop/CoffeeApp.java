package coffeeshop;

import java.util.ArrayList;

public class CoffeeApp {
	public static void main(String[] args) {
		//�޴�, �ٸ���Ÿ, �մ� 
		Consumer consumer = new Consumer();
		Barista barista = new Barista();
		

		ArrayList<MenuItem> menuItems = 
				new ArrayList<>();
	//	menuItems.add(m1);
	//	menuItems.add(m2);
	//	menuItems.add(m3);
		//menuItems.add(menuItems.get(1).getName());
		Menu menu = new Menu(menuItems);
		consumer.�ֹ�("�Ƹ޸�ī��", menu, barista);
	}
}