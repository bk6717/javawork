package dateex;

import java.util.Calendar;

public class CalenderEx {
	
	//2020-03-18:22:11:05
	public static void printCalender(String msg, Calendar cal) {
		int year = cal.get(Calendar.YEAR); //2020
		
		int month = cal.get(Calendar.MONTH)+ 1; // 0 부터 시작하기 때문에 +1해줘야한다
		String mon;
		if(month < 10) {     // month 가 10보다 작으면 앞에 0을 붙인다.
			mon = "0"+month; 
		}else {
			mon = ""+month;
		}
		
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		
		int hour = cal.get(Calendar.HOUR);
		String h = (hour<10) ? "0"+hour :  ""+hour;
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		
		System.out.println(year+"-"+mon+"-"+day+":"+h+":"+min+":"+sec);
	}
	
public static void main(String[] args) {
	Calendar now = Calendar.getInstance();// 날짜는 한번만들어진것을 가져와서 쓰면됨 //싱글톤
	printCalender("현재", now);
	
	Calendar firstDate = Calendar.getInstance();
	firstDate.clear();
	firstDate.set(2016, 11, 25); // 2016년 12월 25일   12월을 표현하기위해 month를 11로 설정

}
}
