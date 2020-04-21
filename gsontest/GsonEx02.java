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
		String jsonPerson ="{\"name\":\"홍길동\",\"ago\":25,\"gender\":\"여\",\"addres\":\"서울특별시 양천구 목동\",\"hobby\":[\"농구\",\"도술\"],\"가족관계\":{\"샵\":2,\"아버지\":\"홍판서\",\"어머니\":\"춘섬\"},\"회사\":\"경기 수원시 팔달구 우만동\"}\r\n" + 
				"";
		
		Gson gson = new Gson();
//		People people = Gson.fromJson(.class);
		
	}
}
