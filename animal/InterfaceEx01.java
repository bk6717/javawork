package animal;
//1.변수 : public static final 생략
//2.함수 : public abstract 생략
//3. 인터페이스는 통로의 역할 --> 동적 바인딩
//4. 무조건 추상메서드만 존재가능 = 강제성 부여
//5. new 할 수 없다.
interface 부서{
	int 총무과 = 10;  //public static final  생략 
	int 생산팀 = 20;
	int 인사과 = 30;
	int 행정과 = 40;
}

public class InterfaceEx01{

	public static void main(String[] args) {
		System.out.println(부서.생산팀);
	}

}
