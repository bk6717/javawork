package coffeeshop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//Ŭ���� �ڷ��� : Beans : = table
public class MenuItem {
	private String name;
	private int price;
}
