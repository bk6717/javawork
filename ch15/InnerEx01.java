//package ch15;
//
//import ch15.OuterClass.InnerClass;
//
//class OuterClass{
//	int outerNum = 10; 
//	
//	class InnerClass{    //static 이없으니까 일반변수라고 생각하면된다.
//		int innerNum = 20;
//	}
//}
//
////내부클래스에있는 전역변수를 
//public class InnerEx01 {
//public static void main(String[] args) {
//	InnerClass in = new InnerClass(); //static
//	new OuterClass.InnerClass();    //메모리에 뜨긴하지만 찾을때는 OuterClass. 해서 찾아야한다
//
//	OuterClass oc = new OuterClass(); // 
//	OuterClass.InnerClass oc2 = oc2.new InnerClass(); 
//}
//}
