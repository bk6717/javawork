package ch06;

class Person {
	String name = "홍길동";
	int age = 15;
	String job = "학생";
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", job=" + job + "]";
	}


}

public class ObjectEx02 {
public static void main(String[] args) {
	Integer num = 10;
	String s = Integer.toString(num);
	System.out.println(s);
	
	Person p1 = new Person();
	System.out.println(p1.toString());
	System.out.println(p1);   //객체(주소)를 호출하면 자동으로 toString 호출

	StringBuilder sb = new StringBuilder();
	sb.append("안녕");
	sb.append("반가워");
	
	System.out.println(sb.toString());
}
}
