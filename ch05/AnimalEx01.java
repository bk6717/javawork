package ch05;

import java.util.jar.Attributes.Name;

abstract class Animal {  // abstract특징 : new 못함
	final String name = "동물";
  abstract	String getName(); 
}

class Dog extends Animal {
	final String name = "강아지";
	@Override
	String getName() {
		return name;
	}
}

class Cat extends Animal {
	final String name = "고양이";
	@Override
	String getName() {
		// TODO Auto-generated method stub
		return name;
	}
}

class Bird extends Animal {
	final String name = "새";
@Override
String getName() {
	// TODO Auto-generated method stub
	return name;
}
}

class Tiger extends Animal{
	final String name = "호랑이";
			String getName() {
		return name;
	}
}

class Mouse extends Animal{
	final String name = "쥐";
	@Override
	String getName() {
		return name;
	}
}
public class AnimalEx01 {

	/*
	 * static void attack(Dog u1, Cat u2) { System.out.println(u2.name + "가 " +
	 * u1.name + "에게 공격당했습니다."); }
	 * 
	 * static void attack(Dog u1, Bird u2) { System.out.println(u2.name + "가 " +
	 * u1.name + "에게 공격당했습니다."); }
	 * 
	 * static void attack(Cat u1, Bird u2) { System.out.println(u2.name + "가 " +
	 * u1.name + "에게 공격당했습니다."); }
	 */
	static void attack(Animal u1, Animal u2) {
		System.out.println(u2.getName() +"가 "+u1.getName() +"에게 공격당했습니다.");
	}

	public static void main(String[] args) {
		Dog d1 = new Dog();
		Cat c1 = new Cat();
		Bird b1 = new Bird();
		Tiger t1 = new Tiger();

		System.out.println(d1.name + "탄생");
		System.out.println(c1.name + "탄생");
		System.out.println(b1.name + "탄생");
		System.out.println(t1.name + "탄생");

		// 강아지 vs 고양이
		attack(d1, c1);
		
		// 강아지 vs 새
		attack(d1, b1);
		
		// 고양이 vs 새
		attack(c1, b1);
		
		// 호랑이 vs 고양이
		attack(t1, c1);
		
	}

}
