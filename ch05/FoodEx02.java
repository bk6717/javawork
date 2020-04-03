package ch05;

abstract class Food {
	abstract void standby();
	void eat() { // protected �� �ڽĸ� ����� �� �ִ�. ���ä�
		System.out.println("������ �Խ��ϴ�.");
	}

	abstract void cook();

	void auto() { // �̷��� ����� start�� ������ �Ǽ��� �پ��
		standby();
		cook();
		eat();
		
	}
}

class ��� extends Food {
	void cook() {
		System.out.println("���� ���δ�.");
	}

	void standby() {
		System.out.println("���� ������ ���� �غ��մϴ�.");
	}
}

class ���� extends Food {
	String name = "����";

	void cook() {
		System.out.println(name + "�����ǿ� ���´�.");
	}
	void standby() {
		System.out.println("���ǰ� ���� ���ʸ� �غ��մϴ�.");
	}
}

public class FoodEx02 {
	static void start(Food f) {   //Ÿ���� �߻�ȭ 
		f.auto(); /// !!

	}

	public static void main(String[] args) {
		start(new ���());
		System.out.println();
		start(new ����());
	}

}
