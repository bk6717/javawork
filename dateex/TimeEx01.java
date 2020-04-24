package dateex;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

//구버전  자바 1.7이하 
//Java.sql.Date 
//java.sql.Time    (X)
//java.sql.Timestamp
//java.util.Calendar  (X)
//java,util.Date

// 신버전 자바 1.8 이상
//java.time.LocalDate
//java.time.LocalDateTime
//java.time.LocalTime

public class TimeEx01 {
	public static void main(String[] args) {
		//Calendar 안씀
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM--dd hh:mm:ss");
		String today = formater.format(cal.getTime());
		System.out.println("cal.getTime() :" + cal.getTime());
		System.out.println("today : "+ today);
	
		//2. java.util.Date 안씀
		//1970.01.01을 기준으로 해서 경과된 밀리 초를 계산한다.
		Date time2 =new Date();
		System.out.println("time2 : " + time2);
		System.out.println("time2.getTime() :" + time2.getTime());
		System.out.println("time2.getDay() :" + time2.getDay());     //@deprecated  컴퓨터가 읽는 주석 .. 더이상사용하지말라는 뜻
		
		//3.Java.sql.Date 안씀.!
		java.sql.Date time3 = new java.sql.Date(100000000);   //괄호에는 롱값으로 되어잇다
		System.out.println("time3 :" + time3);
		
		//4.java.sql.Timestamp  ... 만들어서 쓰면된다.
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		Date d =new Date();
		String timestamp = sf.format(d.getTime());
		Timestamp ts = Timestamp.valueOf("2020-04-24 11:31:05");
		System.out.println("ts : "+ ts);
		
		//!! 5.localDateTime (LocalDate --> Timestamp) :java가 들고있는것. DB가 들고있지 않다. 
		// Java -> db 로 넘길때는 timestamp 를 이용 
		// db -> Java 로 넘길때는 다시 localDate로 바꾸면 된다.
		Timestamp nowDate = Timestamp.valueOf(LocalDateTime.now()); //LocalDateTime 타입을 받을수 있다.(상속이 안되어있다.)
		System.out.println(nowDate);
		
		// LocalDateTime , LocalDate , LocalTime 의 차이점
		System.out.println("LocalDateTime.now() : " + LocalDateTime.now());
		System.out.println("LocalDate.now() : " + LocalDate.now());
		System.out.println("LocalTime.now() : "+LocalTime.now());
		
		//!! TimeStamp --> Localdatetime    DB에서 Java로 
		LocalDateTime idt = nowDate.toLocalDateTime();
		System.out.println("idt : " + idt);
	}	
}
