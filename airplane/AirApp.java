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
// public static int getTotalCount() { try { // 1.주소 객체 만들기 URL url = new URL(
// "http://openapi.tago.go.kr/openapi/service/DmstcFlightNvgInfoService/getFlightOpratInfoList?serviceKey=Wj92uo%2BkHAPOIr07a0PumpQLFkxxhHicBb8B%2FEqh7kNSugxouyKxSyC%2Bs3gJ1So%2BS9Kel48cd98%2FjM4XGufN7A%3D%3D&numOfRows=50&pageNo=1&depAirportId="
// + FlightInforService.airPortId.get(depAirportId) + "&arrAirportId=" +
// FlightInforService.airPortId.get(arrAirportId) + "&depPlandTime=" +
// depPlandTime + "&_type=json");
// 
// * // 2. 스트림 연결 HttpURLConnection con = (HttpURLConnection)
// * url.openConnection();
// * 
// * // 3. 버퍼 연결 (모두 문자열로 전송) BufferedReader br = new BufferedReader(new
// * InputStreamReader(con.getInputStream(), "UTF-8"));
// * 
// * // tip : 파일에 스트림 연결 //FileWriter f1 =new FileWriter("c:\\utils\\test.html");
// * 
// * // 이미지 같은것을 넣고싶을때 // FileOutputStream f2 = new FileOutputStream()
// * 
// * // 4.문자 더하기 StringBuilder sb = new StringBuilder();
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
// * for (Item item : flighitem) { System.out.println("항공사 : " +
// * item.getAirlineNm()); System.out.println("도착지 : " + item.getArrAirportNm());
// * System.out.println("도착시간 : " + item.getArrPlandTime());
// * System.out.println("출발지 : " + item.getDepAirportNm());
// * System.out.println("출발시간 : " + item.getDepPlandTime());
// * System.out.println("항공기ID : " + item.getVihicleId());
// * System.out.println("이코노미요금 : " + item.getEconomyCharge());
// * System.out.println("프레스티지요금 : " + item.getPrestigeCharge());
// * System.out.println(); }
// * 
// * 
// * } catch (Exception e) { e.printStackTrace(); } return 0;
// * 
// * }
// * 
// * static void airinfo(String depAirportId, String arrAirportId, long
// * depPlandTime) { try { // 1.주소 객체 만들기 URL url = new URL(
// * "http://openapi.tago.go.kr/openapi/service/DmstcFlightNvgInfoService/getFlightOpratInfoList?serviceKey=Wj92uo%2BkHAPOIr07a0PumpQLFkxxhHicBb8B%2FEqh7kNSugxouyKxSyC%2Bs3gJ1So%2BS9Kel48cd98%2FjM4XGufN7A%3D%3D&numOfRows=50&pageNo=1&depAirportId="
// * + FlightInforService.airPortId.get(depAirportId) + "&arrAirportId=" +
// * FlightInforService.airPortId.get(arrAirportId) + "&depPlandTime=" +
// * depPlandTime + "&_type=json");
// * 
// * // 2. 스트림 연결 HttpURLConnection con = (HttpURLConnection)
// * url.openConnection();
// * 
// * // 3. 버퍼 연결 (모두 문자열로 전송) BufferedReader br = new BufferedReader(new
// * InputStreamReader(con.getInputStream(), "UTF-8"));
// * 
// * // tip : 파일에 스트림 연결 //FileWriter f1 =new FileWriter("c:\\utils\\test.html");
// * 
// * // 이미지 같은것을 넣고싶을때 // FileOutputStream f2 = new FileOutputStream()
// * 
// * // 4.문자 더하기 StringBuilder sb = new StringBuilder();
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
// * for (Item item : flighitem) { System.out.println("항공사 : " +
// * item.getAirlineNm()); System.out.println("도착지 : " + item.getArrAirportNm());
// * System.out.println("도착시간 : " + item.getArrPlandTime());
// * System.out.println("출발지 : " + item.getDepAirportNm());
// * System.out.println("출발시간 : " + item.getDepPlandTime());
// * System.out.println("항공기ID : " + item.getVihicleId());
// * System.out.println("이코노미요금 : " + item.getEconomyCharge());
// * System.out.println("프레스티지요금 : " + item.getPrestigeCharge());
// * System.out.println(); }
// * 
// * 
// * } catch (Exception e) { e.printStackTrace(); } } public static void
// * main(String[] args) { FlightInforService.setAirLineId();
// * FlightInforService.setAirPortId();
// * 
// * for (String key : FlightInforService.airPortId.keySet()) {
// * System.out.print(key+" "); } System.out.println();
// * System.out.println("출발지를 입력하세요."); Scanner sc = new Scanner(System.in);
// * String depAirportId = sc.next();
// * 
// * System.out.println("도착지를 입력하세요"); String arrAirportId = sc.next();
// * 
// * System.out.println("출발일자를 입력하세요"); String depPlandTimeTemp = sc.next();
// * 
// * System.out.println("");
// * 
// * long depPlandTime = Long.parseLong(depPlandTimeTemp); // Integer
// * depPlandTimeInteger = Integer.parseInt(depPlandTimeTemp); // double
// * depPlandTimeDouble = Double.parseDouble(depPlandTimeTemp); //
// * 
// * int page =1; //문자로 바꾸고싶을때 String strTemp = depPlandTime + ""; // 기본 자료형은 +
// * 문자열을 붙여서 묵시적 형변환. String strTemp2 = depPlandTimeInteger.toString(); //랩퍼 자료형은
// * .toString을 사용한다. String strTemp3 = depPlandTimeDouble + ""; //Double 은
// * 기본자료형이기때문에 묵시적형변환 int count = 0;
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