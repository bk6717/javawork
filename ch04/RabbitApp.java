package ch04;

import javax.xml.stream.events.EndDocument;

class Rabbit {
	private String name; // heap변수 , 전역변수 , 멤버변수 , 필드 , 속성 , 프로퍼티
	int power;

	public Rabbit(String name, int power) {
		this.name = name;
		this.power = power;
	}

	// 행동
	void drink() {
		// 100이 넘어가면 동작하지 않도록

		if (power < 100) {
			power++;
		}
	}

	public int getPower() {
		return power;
	}
	void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
} // end of class Rabbit

public class RabbitApp {
	public static void main(String[] args) {
		Rabbit r1 = new Rabbit("토끼", 20); // 100이 맥스라고<tgh 가정
		for (int i = 0; i < 100; i++) {
			r1.drink();
			System.out.println(r1.getPower());
		}//end of for
		// 이름 변경 후 확인
		r1.setName("산토끼");
		System.out.println(r1.getName());
	}
}
