package a;

public class App extends ProtectedData {
	public static void main(String[] args) {
		PublicData p = new PublicData();
		System.out.println(p.num);

		DefaltData d = new DefaltData();
		// System.out.println(d.num); // dafalt는 같은 패키지 내에서만 접근ㄱ나으

		PrivateData a = new PrivateData();
		// private 는 자기클래스 안에서만 접근이 가능하다
		// System.out.println(a.num); 안됨..

		ProtectedData pr = new ProtectedData();
		App pp = new App();
		System.out.println(pr.num);
		// protected 데이터는 같은 패키지 아니면 자식클래스만 찾을 수 있다.
		// 다른패키지에서 찾을수 있는 유일한 방법은 extends
	}
}
