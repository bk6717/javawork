package quiz;

// int타입 나누기 int타입 이면 int 타입이 리턴된다 10/3 -> 3
// int타입 나머지 int타입 이면 int 타입이 리턴된다 10%3 -> 1


// 3600초는 1시간
// 60초는 1분

// 지금부터 34567초 뒤에 퇴근하려고 한다.
// 몇시간 몇분 뒤에 퇴근하는지 출력하세요.

// 출력예시 : "0시간 0분 0초 뒤에 퇴근합니다."

public class Quiz015 {
	public static void main(String[] args) {
		
		int h = 34567 / 3600;
		int h1 = 34567%3600;
		int m = h1/60;
		int s = h1%60;
		 
		System.out.println(h +"시간"+ m +"분"+ s +"초 뒤에 퇴근합니다.");
		
	}
}
