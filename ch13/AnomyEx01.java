package ch13;

//규약!!
interface Animal{
	void move();  //추상 메서드 (new 못함!!)
	// 추상 메서드가 있으면 new 못함 오브젝트가 될 수 없다.
}
abstract class Person{
	abstract void eat();
}
public class AnomyEx01 {

	public static void main(String[] args) {
		//Animal a = new Animal : 추상메서드가 구현되어 있지 않아서 new 못함
		//Person p = new Person : 추상메서드가 구현되어 있지 않아서 new 못함
		//추상클래스는 추상메서드가 들어올 수 있기 때문에 new를 막아둠 
		
	}

}
