//package simple;
//
//abstract class Ani {
//	abstract void sound();
//}
//
//class Cat extends Ani {
//	@Override
//	void sound() {
//		System.out.println("�߿�");
//	}
//}
//
//class Bird extends Ani {
//	@Override
//	void sound() {
//		System.out.println("±±");
//	}
//}
//
//class Fish extends Ani {
//	@Override
//	void sound() {
//		System.out.println("��������");
//	}
//}
//
//public class AnomyEx04 {
//
//	static void start(Ani a) {
//		a.sound();
//	}
//
//	public static void main(String[] args) {
//		start(new Fish());
//		
//		start(new Ani() { // �ѹ����� �ٽô� �Ⱦ� �� ���� ���� �͸�Ŭ������ �̿��Ѵ�
//			
//			@Override
//			void sound() {
//				System.out.println("����");
//				
//			}
//		});
//	}
//}
