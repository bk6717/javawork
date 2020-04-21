//
// package airplane;
// 
// import java.io.BufferedReader; import java.io.FileWriter; import
// java.io.InputStreamReader; import java.net.HttpURLConnection; import
// java.net.URL; import java.util.ArrayList; import java.util.List; import
// java.util.Scanner;
// 
// import org.omg.CORBA.PUBLIC_MEMBER;
// 
// import com.google.gson.Gson;
//// 
// public class AirApp {
// 
// public static int getTotalCount() { try { // 1.�ּ� ��ü ����� URL url = new URL(
// "http://openapi.tago.go.kr/openapi/service/DmstcFlightNvgInfoService/getFlightOpratInfoList?serviceKey=Wj92uo%2BkHAPOIr07a0PumpQLFkxxhHicBb8B%2FEqh7kNSugxouyKxSyC%2Bs3gJ1So%2BS9Kel48cd98%2FjM4XGufN7A%3D%3D&numOfRows=50&pageNo=1&depAirportId="
// + FlightInforService.airPortId.get(depAirportId) + "&arrAirportId=" +
// FlightInforService.airPortId.get(arrAirportId) + "&depPlandTime=" +
// depPlandTime + "&_type=json");
// 
// * // 2. ��Ʈ�� ���� HttpURLConnection con = (HttpURLConnection)
// * url.openConnection();
// * 
// * // 3. ���� ���� (��� ���ڿ��� ����) BufferedReader br = new BufferedReader(new
// * InputStreamReader(con.getInputStream(), "UTF-8"));
// * 
// * // tip : ���Ͽ� ��Ʈ�� ���� //FileWriter f1 =new FileWriter("c:\\utils\\test.html");
// * 
// * // �̹��� �������� �ְ������ // FileOutputStream f2 = new FileOutputStream()
// * 
// * // 4.���� ���ϱ� StringBuilder sb = new StringBuilder();
// * 
// * String input = "";
// * 
// * while ((input = br.readLine()) != null) { sb.append(input); }
// * System.out.println(sb.toString());
// * 
// * Gson gson = new Gson(); Gsonair gs = gson.fromJson(sb.toString(),
// * Gsonair.class);
// * 
// * 
// * List<Item> flighitem = gs.getResponse().getBody().getItems().getItem();
// * 
// * for (Item item : flighitem) { System.out.println("�װ��� : " +
// * item.getAirlineNm()); System.out.println("������ : " + item.getArrAirportNm());
// * System.out.println("�����ð� : " + item.getArrPlandTime());
// * System.out.println("����� : " + item.getDepAirportNm());
// * System.out.println("��߽ð� : " + item.getDepPlandTime());
// * System.out.println("�װ���ID : " + item.getVihicleId());
// * System.out.println("���ڳ�̿�� : " + item.getEconomyCharge());
// * System.out.println("������Ƽ����� : " + item.getPrestigeCharge());
// * System.out.println(); }
// * 
// * 
// * } catch (Exception e) { e.printStackTrace(); } return 0;
// * 
// * }
// * 
// * static void airinfo(String depAirportId, String arrAirportId, long
// * depPlandTime) { try { // 1.�ּ� ��ü ����� URL url = new URL(
// * "http://openapi.tago.go.kr/openapi/service/DmstcFlightNvgInfoService/getFlightOpratInfoList?serviceKey=Wj92uo%2BkHAPOIr07a0PumpQLFkxxhHicBb8B%2FEqh7kNSugxouyKxSyC%2Bs3gJ1So%2BS9Kel48cd98%2FjM4XGufN7A%3D%3D&numOfRows=50&pageNo=1&depAirportId="
// * + FlightInforService.airPortId.get(depAirportId) + "&arrAirportId=" +
// * FlightInforService.airPortId.get(arrAirportId) + "&depPlandTime=" +
// * depPlandTime + "&_type=json");
// * 
// * // 2. ��Ʈ�� ���� HttpURLConnection con = (HttpURLConnection)
// * url.openConnection();
// * 
// * // 3. ���� ���� (��� ���ڿ��� ����) BufferedReader br = new BufferedReader(new
// * InputStreamReader(con.getInputStream(), "UTF-8"));
// * 
// * // tip : ���Ͽ� ��Ʈ�� ���� //FileWriter f1 =new FileWriter("c:\\utils\\test.html");
// * 
// * // �̹��� �������� �ְ������ // FileOutputStream f2 = new FileOutputStream()
// * 
// * // 4.���� ���ϱ� StringBuilder sb = new StringBuilder();
// * 
// * String input = "";
// * 
// * while ((input = br.readLine()) != null) { sb.append(input); }
// * System.out.println(sb.toString());
// * 
// * Gson gson = new Gson();
// * 
// * Gsonair gs = gson.fromJson(sb.toString(), Gsonair.class);
// * 
// * List<Item> flighitem = gs.getResponse().getBody().getItems().getItem();
// * 
// * for (Item item : flighitem) { System.out.println("�װ��� : " +
// * item.getAirlineNm()); System.out.println("������ : " + item.getArrAirportNm());
// * System.out.println("�����ð� : " + item.getArrPlandTime());
// * System.out.println("����� : " + item.getDepAirportNm());
// * System.out.println("��߽ð� : " + item.getDepPlandTime());
// * System.out.println("�װ���ID : " + item.getVihicleId());
// * System.out.println("���ڳ�̿�� : " + item.getEconomyCharge());
// * System.out.println("������Ƽ����� : " + item.getPrestigeCharge());
// * System.out.println(); }
// * 
// * 
// * } catch (Exception e) { e.printStackTrace(); } } public static void
// * main(String[] args) { FlightInforService.setAirLineId();
// * FlightInforService.setAirPortId();
// * 
// * for (String key : FlightInforService.airPortId.keySet()) {
// * System.out.print(key+" "); } System.out.println();
// * System.out.println("������� �Է��ϼ���."); Scanner sc = new Scanner(System.in);
// * String depAirportId = sc.next();
// * 
// * System.out.println("�������� �Է��ϼ���"); String arrAirportId = sc.next();
// * 
// * System.out.println("������ڸ� �Է��ϼ���"); String depPlandTimeTemp = sc.next();
// * 
// * System.out.println("");
// * 
// * long depPlandTime = Long.parseLong(depPlandTimeTemp); // Integer
// * depPlandTimeInteger = Integer.parseInt(depPlandTimeTemp); // double
// * depPlandTimeDouble = Double.parseDouble(depPlandTimeTemp); //
// * 
// * int page =1; //���ڷ� �ٲٰ������ String strTemp = depPlandTime + ""; // �⺻ �ڷ����� +
// * ���ڿ��� �ٿ��� ������ ����ȯ. String strTemp2 = depPlandTimeInteger.toString(); //���� �ڷ�����
// * .toString�� ����Ѵ�. String strTemp3 = depPlandTimeDouble + ""; //Double ��
// * �⺻�ڷ����̱⶧���� ����������ȯ int count = 0;
// * 
// * int totalCount = getTotalCount(depAirportId, arrAirportId ,
// * depPlandTimeTemp,page); if(totalCount % 50 == 0) { count = totalCount / 50;
// * }else { count = totalCount / 50 +1; } ArrayList<Flightlnfo> flightInfos = new
// * ArrayList<>();
// * 
// * for (int i=0; i<count ; i++) { FlightInfo flightInfo =
// * getFlightInfo(depAirportId, arrAirportId , depPlandTimeTemp,page); page ++;
// * flightInfos.add(flightIn); } // airinfo(depAirportId, arrAirportId , 20200411
// * , page);
// * 
// * } }
// * 
// */