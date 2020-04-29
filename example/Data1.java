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
//	private String info = "저장된 정보가 없습니다.";
//	
//	public String getInfo() {
//	try {
//		//1번 주소 객체 만들기 
//		URL url = new URL("https://8oi9s0nnth.apigw.ntruss.com/corona19-masks/v1/stores/json?page=1");
//		
//		//2번 스트림 연결\
//		HttpURLConnection con = (HttpURLConnection)url.openConnection();
//		
//		//3번 버퍼 연결 (문자열)
//		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
//		
//		//4.문자 더하기 
//		StringBuilder sb = new StringBuilder();
//		
//		// 스트링빌더에 버퍼에서 받은 문자열을 한줄씩 추가하기 
//		String input = "";
//		while ((input = br.readLine()) != null){
//			sb.append(input);
//		}
//		
//		//입력이 잘 되었는지 테스트 
//		System.out.println(sb.toString());
//		System.out.println();
//		
//		br.close();
//		con.disconnect();
//		
//		//5.자바 오브젝트로 변환
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
