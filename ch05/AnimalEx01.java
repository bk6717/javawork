package ch05;

import java.util.jar.Attributes.Name;

abstract class Animal {  // abstractƯ¡ : new ����
	final String name = "����";
  abstract	String getName(); 
}

class Dog extends Animal {
	final String name = "������";
	@Override
	String getName() {
		return name;
	}
}

class Cat extends Animal {
	final String name = "�����";
	@Override
	String getName() {
		// TODO Auto-generated method stub
		return name;
	}
}

class Bird extends Animal {
	final String name = "��";
@Override
String getName() {
	// TODO Auto-generated method stub
	return name;
}
}

class Tiger extends Animal{
	final String name = "ȣ����";
			String getName() {
		return name;
	}
}

class Mouse extends Animal{
	final String name = "��";
	@Override
	String getName() {
		return name;
	}
}
public class AnimalEx01 {

	/*
	 * static void attack(Dog u1, Cat u2) { System.out.println(u2.name + "�� " +
	 * u1.name + "���� ���ݴ��߽��ϴ�."); }
	 * 
	 * static void attack(Dog u1, Bird u2) { System.out.println(u2.name + "�� " +
	 * u1.name + "���� ���ݴ��߽��ϴ�."); }
	 * 
	 * static void attack(Cat u1, Bird u2) { System.out.println(u2.name + "�� " +
	 * u1.name + "���� ���ݴ��߽��ϴ�."); }
	 */
	static void attack(Animal u1, Animal u2) {
		System.out.println(u2.getName() +"�� "+u1.getName() +"���� ���ݴ��߽��ϴ�.");
	}

	public static void main(String[] args) {
		Dog d1 = new Dog();
		Cat c1 = new Cat();
		Bird b1 = new Bird();
		Tiger t1 = new Tiger();

		System.out.println(d1.name + "ź��");
		System.out.println(c1.name + "ź��");
		System.out.println(b1.name + "ź��");
		System.out.println(t1.name + "ź��");

		// ������ vs �����
		attack(d1, c1);
		
		// ������ vs ��
		attack(d1, b1);
		
		// ����� vs ��
		attack(c1, b1);
		
		// ȣ���� vs �����
		attack(t1, c1);
		
	}

}
