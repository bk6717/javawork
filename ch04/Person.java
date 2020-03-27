package ch04;

//상태와 행동
public class Person {

	String name;
	String job;
	int age;
	char gender;
	String bloodTyp;
	//디폴트 생성자 = 초기화 용도로 사용한다. 매개변수가 없는 생성자
	public Person() {
	}
	 //오버로딩 매개변수가 다르면
	public Person(String name, String job, int age, char gender, String bloodTyp) {
		this.name = name;
		this.job = job;
		this.age = age;
		this.gender = gender;
		this.bloodTyp = bloodTyp;
	}

	
	
}
