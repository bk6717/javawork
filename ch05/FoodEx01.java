package ch05;
abstract class Food1{   // new 못함 abstract
	abstract void eat();   // 추상메서드 
}
class 라면1 extends Food1{
	String name = "라면";
	void eat() {
		System.out.println(name+"을 먹었습니다.");
	}  
	
}
class 불고기1 extends Food1{
	String name ="불고기";
	void eat() {
		System.out.println(name+"을 먹었습니다.");
	}
}
class 갈비1 extends Food1{
	String name = "갈비";
	void eat() {
		System.out.println(name +"을 먹었습니다.");
	}
}
public class FoodEx01 {
	static void start(Food1 f) { //타입을 추상화   Food로 만들지않고 음식이름으로하면 3개를 만들어야함
		f.eat();
	}
	public static void main(String[] args) {
		start(new 라면1());
		
		}
}
