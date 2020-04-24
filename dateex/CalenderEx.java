package dateex;

import java.util.Calendar;

public class CalenderEx {
	
	//2020-03-18:22:11:05
	public static void printCalender(String msg, Calendar cal) {
		int year = cal.get(Calendar.YEAR); //2020
		
		int month = cal.get(Calendar.MONTH)+ 1; // 0 ���� �����ϱ� ������ +1������Ѵ�
		String mon;
		if(month < 10) {     // month �� 10���� ������ �տ� 0�� ���δ�.
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
	Calendar now = Calendar.getInstance();// ��¥�� �ѹ������������ �����ͼ� ����� //�̱���
	printCalender("����", now);
	
	Calendar firstDate = Calendar.getInstance();
	firstDate.clear();
	firstDate.set(2016, 11, 25); // 2016�� 12�� 25��   12���� ǥ���ϱ����� month�� 11�� ����

}
}
