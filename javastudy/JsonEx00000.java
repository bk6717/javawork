package javastudy;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

class PersonData {

	private String name;
	private Integer ago;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAgo() {
		return ago;
	}

	public void setAgo(Integer ago) {
		this.ago = ago;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}

public class JsonEx00000 {

	public static void main(String[] args) {
		// 1.다운받은 json 데이터
		String jsonData = "{\"name\":\"코스\",\"ago\":30}\r\n" + "";
		System.out.println(jsonData);

		// 2.json 데이터 => java 오브젝트로 변환
		Gson gson = new Gson();
		PersonData pd = gson.fromJson(jsonData, PersonData.class);
		System.out.println(pd.getAgo());
	}
}
