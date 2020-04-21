package chat;

interface StarUnit{
	abstract int getHp();
}

abstract class Protoss implements StarUnit{
	abstract int getSh();
}

abstract class Zerg implements StarUnit{}

class Ultra extends Zerg{
	int Hp = 300;
	@Override
	public int getHp() {
		// TODO Auto-generated method stub
		return Hp;
	}
}

class Zealot extends Protoss{
	int sh = 100; 
	int Hp = 200;@Override
	public int getHp() {
		// TODO Auto-generated method stub
		return Hp;
	}
	@Override
	public int getSh() {
		return sh;
	}
	
}

public class FinallyEx01 {
	
	static void check(StarUnit unit) {
		try {
			Zealot z = (Zealot) unit;
			System.out.println("남은 쉴드는 : " + z.getSh());
			System.out.println("남은 체력은 : " + z.getHp());
		} catch (Exception e) { //오류를 검증
			//저그
			Ultra u = (Ultra) unit;
			System.out.println("저그는 쉴드가 없습니다.");
			System.out.println("남은체력은 : " +u.getHp());
		}finally {   // finally는 무조건 실행된다.
			System.out.println("나는 무조건 실행");
		}
		
	}
	
	public static void main(String[] args) {
	//	check(new Ultra());
		check(new Ultra());
	}
}
