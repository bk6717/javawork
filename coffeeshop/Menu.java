package coffeeshop;

import java.util.ArrayList;

import lombok.Data;

// 책임은 메뉴선택
@Data
public class Menu {
	
	// 메뉴 아이템들을 가지고잇어야 한다.  (컬렉션)
	private ArrayList<MenuItem> menuItems;
	
	
	
	public Menu(ArrayList<MenuItem> menuItems) {
		super();
		this.menuItems = menuItems;
	}



	public MenuItem 메뉴선택(String menuName) {
		for (MenuItem menuItem : menuItems) {  // 배열을 처음부터 끝까지 돌리고싶을때 사용
			if(menuItem.getName().equals(menuName)) {
				return menuItem;
			}
		}
		return null;
	}
	
}
