//package ch15;
//
//import ch15.OuterClass.InnerClass;
//
//class OuterClass{
//	int outerNum = 10; 
//	
//	class InnerClass{    //static �̾����ϱ� �Ϲݺ������ �����ϸ�ȴ�.
//		int innerNum = 20;
//	}
//}
//
////����Ŭ�������ִ� ���������� 
//public class InnerEx01 {
//public static void main(String[] args) {
//	InnerClass in = new InnerClass(); //static
//	new OuterClass.InnerClass();    //�޸𸮿� �߱������� ã������ OuterClass. �ؼ� ã�ƾ��Ѵ�
//
//	OuterClass oc = new OuterClass(); // 
//	OuterClass.InnerClass oc2 = oc2.new InnerClass(); 
//}
//}
