package ch13;

interface Dog{     //�߻� �޼��带 �������ָ� �ȴ�.
	void sound();
}


public class AnomyEx02 {
	
	static void start(Dog d) {
		d.sound();
	}
	public static void main(String[] args) {
	Dog d = new Dog() {  //�͸�Ŭ����
		
		@Override
		public void sound() {
			System.out.println("�۸�");
		}
	};
		start(d);
	}

}
