package ch05;

import java.net.CookieHandler;

abstract class Į {
	abstract void kill();

	abstract void cook();

	abstract void repair(); // ����
}

abstract class �丮���� extends Į { // �߻�޼��带 ���� �� �ֱ⶧���� ������ ��������.
	@Override
	void kill() {}

	@Override
	void repair() {}
}

class ������ extends �丮���� {

	void cook() {
		System.out.println("ff");
	}

}

public class FoodEx03 {
	static void start(Į c) {
		
	}
	public static void main(String[] args) {

	}
}
