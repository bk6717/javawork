package coffeeshop;

import java.util.ArrayList;

import lombok.Data;

// å���� �޴�����
@Data
public class Menu {
	
	// �޴� �����۵��� �������վ�� �Ѵ�.  (�÷���)
	private ArrayList<MenuItem> menuItems;
	
	
	
	public Menu(ArrayList<MenuItem> menuItems) {
		super();
		this.menuItems = menuItems;
	}



	public MenuItem �޴�����(String menuName) {
		for (MenuItem menuItem : menuItems) {  // �迭�� ó������ ������ ����������� ���
			if(menuItem.getName().equals(menuName)) {
				return menuItem;
			}
		}
		return null;
	}
	
}
