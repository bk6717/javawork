package ch16;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//모델 (Beans)   
//모델링 DB에있는 레코드들을 자바로 바꾸는ㄱ
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
	private int id;
	private String name;
	private String email;
	private String password;
	
}
