package ch05;

class Car {
	void run() {
		System.out.println("�⺻ ������");
	}
}

class Sonata extends Car {
	void run() {
		super.run();
		System.out.println("�ҳ�Ÿ���� ������");
	}
}
class Santafe extends Car{
	void run() {
		System.out.println("��Ÿ�丸�� ������");
	}
}

public class CarEx01 {
	public static void main(String[] args) {
		Car s1 = new Sonata();
		s1.run();
		Car s2 = new Santafe();
		s2.run();
	}
}
