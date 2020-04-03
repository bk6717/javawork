package stars.terran;

import stars.Behavior;

public class Marine extends Terran{
	private String name;
	private int hp;
    static int attack = 5;

	public Marine(String name) {
		this.name = name;
		this.hp = 100;
	}
	@Override
	public void attack(Behavior u) {
		System.out.println("원거리공격");
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
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
