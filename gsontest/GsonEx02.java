package gsontest;

import com.google.gson.Gson;


import java.util.HashMap;
import java.util.Map;

 class PersonData {

private String name;
private Integer age;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public Integer getAge() {
return age;
}

public void setAge(Integer age) {
this.age = age;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}

public class GsonEx02 {
	public static void main(String[] args) {
		String jsonPerson ="{\"name\":\"ȫ�浿\",\"ago\":25,\"gender\":\"��\",\"addres\":\"����Ư���� ��õ�� ��\",\"hobby\":[\"��\",\"����\"],\"��������\":{\"��\":2,\"�ƹ���\":\"ȫ�Ǽ�\",\"��Ӵ�\":\"�ἶ\"},\"ȸ��\":\"��� ������ �ȴޱ� �츸��\"}\r\n" + 
				"";
		
		Gson gson = new Gson();
//		People people = Gson.fromJson(.class);
		
	}
}
