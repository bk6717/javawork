package stars.protoss;

import stars.Behavior;

public class Dragoon extends Protoss{
 private String name;
 private int hp;
 private int sh;
 public static int attack = 15;
 
	public Dragoon(String name) {
		this.name = name;
		this.hp = 100;
		this.sh = 100;
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