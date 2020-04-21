package ch15;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;



public class NetworkEx01 {
	public static void main(String[] args) {
			// 1.�ּ� ��ü �����
			try {
			URL url = new URL("http://openapi.tago.go.kr/openapi/service/DmstcFlightNvgInfoService/getFlightOpratInfoList?serviceKey=Wj92uo%2BkHAPOIr07a0PumpQLFkxxhHicBb8B%2FEqh7kNSugxouyKxSyC%2Bs3gJ1So%2BS9Kel48cd98%2FjM4XGufN7A%3D%3D&numOfRows=50&pageNo=1&depAirportId=NAARKJJ&arrAirportId=NAARKPC&depPlandTime=20200407&_type=json");

			// 2. ��Ʈ�� ����
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			
			//3. ���� ���� (��� ���ڿ��� ����)
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			
			//tip : ���Ͽ� ��Ʈ�� ����
			
			//�̹��� �������� �ְ������
		    //FileOutputStream f2 = new FileOutputStream()
			
			//4.���� ���ϱ� 
			StringBuilder sb = new StringBuilder();
			
			String input = "";
			while((input = br.readLine()) != null) {
				sb.append(input);
			}
			System.out.println(sb.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
