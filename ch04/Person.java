package ch04;

//���¿� �ൿ
public class Person {

	String name;
	String job;
	int age;
	char gender;
	String bloodTyp;
	//����Ʈ ������ = �ʱ�ȭ �뵵�� ����Ѵ�. �Ű������� ���� ������
	public Person() {
	}
	 //�����ε� �Ű������� �ٸ���
	public Person(String name, String job, int age, char gender, String bloodTyp) {
		this.name = name;
		this.job = job;
		this.age = age;
		this.gender = gender;
		this.bloodTyp = bloodTyp;
	}

	
	
}
