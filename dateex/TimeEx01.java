package dateex;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

//������  �ڹ� 1.7���� 
//Java.sql.Date 
//java.sql.Time    (X)
//java.sql.Timestamp
//java.util.Calendar  (X)
//java,util.Date

// �Ź��� �ڹ� 1.8 �̻�
//java.time.LocalDate
//java.time.LocalDateTime
//java.time.LocalTime

public class TimeEx01 {
	public static void main(String[] args) {
		//Calendar �Ⱦ�
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM--dd hh:mm:ss");
		String today = formater.format(cal.getTime());
		System.out.println("cal.getTime() :" + cal.getTime());
		System.out.println("today : "+ today);
	
		//2. java.util.Date �Ⱦ�
		//1970.01.01�� �������� �ؼ� ����� �и� �ʸ� ����Ѵ�.
		Date time2 =new Date();
		System.out.println("time2 : " + time2);
		System.out.println("time2.getTime() :" + time2.getTime());
		System.out.println("time2.getDay() :" + time2.getDay());     //@deprecated  ��ǻ�Ͱ� �д� �ּ� .. ���̻������������ ��
		
		//3.Java.sql.Date �Ⱦ�.!
		java.sql.Date time3 = new java.sql.Date(100000000);   //��ȣ���� �հ����� �Ǿ��մ�
		System.out.println("time3 :" + time3);
		
		//4.java.sql.Timestamp  ... ���� ����ȴ�.
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		Date d =new Date();
		String timestamp = sf.format(d.getTime());
		Timestamp ts = Timestamp.valueOf("2020-04-24 11:31:05");
		System.out.println("ts : "+ ts);
		
		//!! 5.localDateTime (LocalDate --> Timestamp) :java�� ����ִ°�. DB�� ������� �ʴ�. 
		// Java -> db �� �ѱ涧�� timestamp �� �̿� 
		// db -> Java �� �ѱ涧�� �ٽ� localDate�� �ٲٸ� �ȴ�.
		Timestamp nowDate = Timestamp.valueOf(LocalDateTime.now()); //LocalDateTime Ÿ���� ������ �ִ�.(����� �ȵǾ��ִ�.)
		System.out.println(nowDate);
		
		// LocalDateTime , LocalDate , LocalTime �� ������
		System.out.println("LocalDateTime.now() : " + LocalDateTime.now());
		System.out.println("LocalDate.now() : " + LocalDate.now());
		System.out.println("LocalTime.now() : "+LocalTime.now());
		
		//!! TimeStamp --> Localdatetime    DB���� Java�� 
		LocalDateTime idt = nowDate.toLocalDateTime();
		System.out.println("idt : " + idt);
	}	
}
