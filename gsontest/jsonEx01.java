package gsontest;

import com.google.gson.Gson;

class Person{
	String �̸�;
	int ����;
	String ����;
	String �ּ�;
	String[] Ư��;
	Family ��������;
	String ȸ��;
}

class Family{
	int ��;
	String �ƹ���;
	String ��Ӵ�;
}
public class jsonEx01 {
public static void main(String[] args) {
	String jsonPerson="{\"�̸�\":\"ȫ�浿\",\"����\":25,\"����\":\"��\",\"�ּ�\":\"����Ư���� ��õ�� ��\",\"Ư��\":[\"��\",\"����\"],\"��������\":{\"��\":2,\"�ƹ���\":\"ȫ�Ǽ�\",\"��Ӵ�\":\"�ἶ\"},\"ȸ��\":\"��� ������ �ȴޱ� �츸��\"}\r\n" + 
			"";
	
	Gson gson = new Gson();
	Person p = gson.fromJson(jsonPerson,Person.class );
	 System.out.println(p.�̸�); 
}
}