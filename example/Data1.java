//package example;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//import javax.net.ssl.HttpsURLConnection;
//
//import com.google.gson.Gson;
//
//class Data{
//	private String info = "����� ������ �����ϴ�.";
//	
//	public String getInfo() {
//	try {
//		//1�� �ּ� ��ü ����� 
//		URL url = new URL("https://8oi9s0nnth.apigw.ntruss.com/corona19-masks/v1/stores/json?page=1");
//		
//		//2�� ��Ʈ�� ����\
//		HttpURLConnection con = (HttpURLConnection)url.openConnection();
//		
//		//3�� ���� ���� (���ڿ�)
//		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
//		
//		//4.���� ���ϱ� 
//		StringBuilder sb = new StringBuilder();
//		
//		// ��Ʈ�������� ���ۿ��� ���� ���ڿ��� ���پ� �߰��ϱ� 
//		String input = "";
//		while ((input = br.readLine()) != null){
//			sb.append(input);
//		}
//		
//		//�Է��� �� �Ǿ����� �׽�Ʈ 
//		System.out.println(sb.toString());
//		System.out.println();
//		
//		br.close();
//		con.disconnect();
//		
//		//5.�ڹ� ������Ʈ�� ��ȯ
//		Gson gson = new Gson();
//		Module1 = drugStore = gson.fromJson(sb.toString(),Module1.class);
//		info = drugStore.fetStoreInfos().get(0).getname();
//	}catch (Exception e) {
//		e.printStackTrace();
//	}
//		return info;
//	}
//}
//public class Data1 {
//
//}
