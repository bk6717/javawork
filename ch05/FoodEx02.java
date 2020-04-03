package ch05;

abstract class Food {
	abstract void standby();
	void eat() { // protected 는 자식만 사용할 수 있다. 따ㅓㄴ
		System.out.println("음식을 먹습니다.");
	}

	abstract void cook();

	void auto() { // 이렇게 만들고 start에 넣으면 실수가 줄어듬
		standby();
		cook();
		eat();
		
	}
}

class 라면 extends Food {
	void cook() {
		System.out.println("냄비에 끓인다.");
	}

	void standby() {
		System.out.println("라면과 가스와 냄비를 준비합니다.");
	}
}

class 삼겹살 extends Food {
	String name = "삼겹살";

	void cook() {
		System.out.println(name + "을불판에 굽는다.");
	}
	void standby() {
		System.out.println("불판과 고기와 버너를 준비합니다.");
	}
}

public class FoodEx02 {
	static void start(Food f) {   //타입을 추상화 
		f.auto(); /// !!

	}

	public static void main(String[] args) {
		start(new 라면());
		System.out.println();
		start(new 삼겹살());
	}

}
