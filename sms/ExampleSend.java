package sms;


import java.util.HashMap;
import org.json.simple.JSONObject;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

/**
 * @class ExampleSend
 * @brief This sample code demonstrate how to send sms through CoolSMS Rest API PHP
 */
//Message 
public class ExampleSend {
  public static void main(String[] args) {
    String api_key = "NCSJY0R5HELHF6OY"; //
    String api_secret = "D7PLQPTRL6VFTM2RYMR4JXJE6GYDXZ9S";
    Message coolsms = new Message(api_key, api_secret);

    // 4 params(to, from, type, text) are mandatory. must be filled
    HashMap<String, String> params = new HashMap<String, String>();
    params.put("to", "01067176742");
    params.put("from", "01067176742");
    params.put("type", "LMS");
    params.put("text", "나의 첫번째 메시지 전송 프로그램 테스트");
    params.put("app_version", "test app 1.2"); // application name and version

    try {
      JSONObject obj = (JSONObject) coolsms.send(params); //해시맵에 키밸류를 날림
      System.out.println(obj.toString());
    } catch (CoolsmsException e) {
      System.out.println(e.getMessage());
      System.out.println(e.getCode());
      
    }
  }
}
