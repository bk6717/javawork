package coffeeshop;

import java.util.ArrayList;

public class CoffeeApp {
	public static void main(String[] args) {
		//메뉴, 바리스타, 손님 
		Consumer consumer = new Consumer();
		Barista barista = new Barista();
		

		ArrayList<MenuItem> menuItems = 
				new ArrayList<>();
	//	menuItems.add(m1);
	//	menuItems.add(m2);
	//	menuItems.add(m3);
		//menuItems.add(menuItems.get(1).getName());
		Menu menu = new Menu(menuItems);
		consumer.주문("아메리카노", menu, barista);
	}
}