package stars.protoss;

import stars.Behavior;

public class Zealot extends Protoss {
	String name;
	private int hp;
	private int sh; // ��ȣ��
	public static int attack = 10;

	public Zealot(String name) {
		this.name = name;
		this.hp = 100;
		this.sh = 100;
	}

	@Override
	public void attack(Behavior u) {
		System.out.println("�ٰŸ� ����");
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getHp() {
		// TODO Auto-generated method stub
		return hp;
	}

	@Override
	public int setHp(int hp) {
		// TODO Auto-generated method stub
		return hp;
	}
}
