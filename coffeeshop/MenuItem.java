package coffeeshop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//클래스 자료형 : Beans : = table
public class MenuItem {
	private String name;
	private int price;
}
