package ch05;

import java.net.CookieHandler;

abstract class 칼 {
	abstract void kill();

	abstract void cook();

	abstract void repair(); // 수선
}

abstract class 요리사어뎁터 extends 칼 { // 추상메서드를 가질 수 있기때문에 오류가 나지않음.
	@Override
	void kill() {}

	@Override
	void repair() {}
}

class 백종원 extends 요리사어뎁터 {

	void cook() {
		System.out.println("ff");
	}

}

public class FoodEx03 {
	static void start(칼 c) {
		
	}
	public static void main(String[] args) {

	}
}
