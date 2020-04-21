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
			System.out.println("���� ����� : " + z.getSh());
			System.out.println("���� ü���� : " + z.getHp());
		} catch (Exception e) { //������ ����
			//����
			Ultra u = (Ultra) unit;
			System.out.println("���״� ���尡 �����ϴ�.");
			System.out.println("����ü���� : " +u.getHp());
		}finally {   // finally�� ������ ����ȴ�.
			System.out.println("���� ������ ����");
		}
		
	}
	
	public static void main(String[] args) {
	//	check(new Ultra());
		check(new Ultra());
	}
}
