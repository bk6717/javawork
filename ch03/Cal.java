package ch03;

public class Cal {
	 static int add(int n1,int n2) {
		  int result = n1 +n2;
		 // System.out.println("result :"+result);
		  return result;   //retrun 은 가장 마지막에
	  }
	 
	//minus (매개변수는 int형 두개)
	 static int minus(int a,int b){
		 int sum = a - b;
		 return sum;
	 }
	 
	 //multi
	 static int multi(int a1,int a2) {
		 int mul = a1 * a2;
		 return mul;
	 }
	 //main
	 static int devide(int d1,int d2) {
		 int hap = d1 / d2;
		 return hap;
	 }
	public static void main(String[] args) {


	}

}
