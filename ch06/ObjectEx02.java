package ch06;

class Person {
	String name = "ȫ�浿";
	int age = 15;
	String job = "�л�";
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
	System.out.println(p1);   //��ü(�ּ�)�� ȣ���ϸ� �ڵ����� toString ȣ��

	StringBuilder sb = new StringBuilder();
	sb.append("�ȳ�");
	sb.append("�ݰ���");
	
	System.out.println(sb.toString());
}
}
