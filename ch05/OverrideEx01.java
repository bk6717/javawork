package ch05;

import java.util.jar.Attributes.Name;

class A{
	String name = "A";
	void run(){
		System.out.println("A 달린다.");
	}
}
class B extends A{
	String name = "B";
	@Override
	void run() {
		System.out.println(name + "달린다.");
	}
}
class C extends B{
	String name = "C";
	@Override
	void run() {
		System.out.println(name+ "달린다.");
	}
}
public class OverrideEx01 {

	public static void main(String[] args) {
		A a1 = new A();  
		a1.run();
		
		A a2 = new B();
		System.out.println(a2.name); //A
		a2.run();

		B a3 = new C();
	
		System.out.println(a3.name);
		a3.run();
		
		A aa1 = new B();
		aa1.run();
	}

}
