package ch05;
abstract class Food1{   // new ���� abstract
	abstract void eat();   // �߻�޼��� 
}
class ���1 extends Food1{
	String name = "���";
	void eat() {
		System.out.println(name+"�� �Ծ����ϴ�.");
	}  
	
}
class �Ұ��1 extends Food1{
	String name ="�Ұ��";
	void eat() {
		System.out.println(name+"�� �Ծ����ϴ�.");
	}
}
class ����1 extends Food1{
	String name = "����";
	void eat() {
		System.out.println(name +"�� �Ծ����ϴ�.");
	}
}
public class FoodEx01 {
	static void start(Food1 f) { //Ÿ���� �߻�ȭ   Food�� �������ʰ� �����̸������ϸ� 3���� ��������
		f.eat();
	}
	public static void main(String[] args) {
		start(new ���1());
		
		}
}
