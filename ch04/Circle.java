package ch04;

public class Circle {
	int radius; // ���� ������ �ʵ�
	String name;

	public Circle() {
	}

	public double getArea() {
		return 3.14 * radius * radius;
	}

	public static void main(String[] args) {
		Circle pizza;
		pizza = new Circle();
		pizza.radius = 10;
		pizza.name = "�ڹ�����";
		double area = pizza.getArea();
		System.out.println(pizza.name + "�� ������" + area);
	}

}
