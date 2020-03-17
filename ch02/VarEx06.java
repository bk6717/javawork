package ch02;

class person {
	String name = "이병근";
	int age = 25;
	char gender = '남';
	String email = "bk6717@naver.com";
	String phone = "01012345678";
}

public class VarEx06 {

	public static void main(String[] args) {
		person a = new person();

		System.out.println(a.name);
		System.out.println(a.age);
		System.out.println(a.gender);
		System.out.println(a.email);
		System.out.println(a.phone);
	}
}
