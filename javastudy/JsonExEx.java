package javastudy;

import com.google.gson.Gson;

class cos{
	String name = "�ڽ�";
	int ago = 30;
}

public class JsonExEx {
	
public static void main(String[] args) {
	Gson gson = new Gson();
	String cosJson = gson.toJson(new cos());
	System.out.println(cosJson);
	
}
}
