package ch02;

class 동물  {
	 String name = "사자";
	 String color = "노랑";
	 int speed = 100;
	 char gender = '여';
}


public class VarEx05 {
	static int num = 10;    //num 처럼 글씨체가 이태릭이면 static 변수
	
	public static void main(String[] args) {
		System.out.println("동물 생성 준비");	
		System.out.println(num);
		
		동물 a = new 동물();   // 동물에 있는 static 이아닌 모든것이 뜬다.
		// 동물이라는 클래스를 만들어 준다.
		System.out.println(a.name);
		System.out.println(a.color);
		System.out.println(a.speed);
		System.out.println(a.gender);
	}
}
