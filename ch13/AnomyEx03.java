package ch13;

class Car{
	void run() {
		System.out.println("자동차는 달린다.");
	}
}

class Sonata extends Car{
	
}
class Granger extends Car{
	
}
public class AnomyEx03 {
	static void start(Car c) {
		c.run();
	}
	
	public static void main(String[] args) {
	start(new Car());
	start(new Sonata());
	}
}
