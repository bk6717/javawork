package ch04;

import javax.xml.stream.events.EndDocument;

class Rabbit {
	private String name; // heap���� , �������� , ������� , �ʵ� , �Ӽ� , ������Ƽ
	int power;

	public Rabbit(String name, int power) {
		this.name = name;
		this.power = power;
	}

	// �ൿ
	void drink() {
		// 100�� �Ѿ�� �������� �ʵ���

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
		Rabbit r1 = new Rabbit("�䳢", 20); // 100�� �ƽ����<tgh ����
		for (int i = 0; i < 100; i++) {
			r1.drink();
			System.out.println(r1.getPower());
		}//end of for
		// �̸� ���� �� Ȯ��
		r1.setName("���䳢");
		System.out.println(r1.getName());
	}
}
