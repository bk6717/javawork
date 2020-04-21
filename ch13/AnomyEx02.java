package ch13;

interface Dog{     //추상 메서드를 구현해주면 된다.
	void sound();
}


public class AnomyEx02 {
	
	static void start(Dog d) {
		d.sound();
	}
	public static void main(String[] args) {
	Dog d = new Dog() {  //익명클래스
		
		@Override
		public void sound() {
			System.out.println("멍멍");
		}
	};
		start(d);
	}

}
