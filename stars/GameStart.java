package stars;

//다크 템플러 DarkTempler, 리버 River
class DarkTempler {
	final String NAME;
	int hp;
	static int attack = 50;

	public DarkTempler(String name) {
		this.NAME = name;
		this.hp = 100;
	}
}

class River {
	final String NAME;
	int hp;
	static int attack = 70;

	public River(String name) {
		this.NAME = name;
		this.hp = 100;
	}
}

class Zealot {
	final String NAME; // final 은 대문자로한다 (협약) 한번 바뀌면 변하지않는다.
	int hp;
	static int attack = 10;

	public Zealot(String name) {
		this.NAME = name;
		this.hp = 100;
	}
}

class Dragoon {
	final String NAME;
	int hp;
	static int attack = 15;

	public Dragoon(String name) {
		this.NAME = name;
		this.hp = 100;
	}

}

public class GameStart {
	// 질럿이 드라군을 떄리는 함수
	static void attack(Zealot u1, Dragoon u2) {
		u2.hp = u2.hp - u1.attack;
		System.out.println(u2.NAME + "이 공격당하고 있습니다.");
		System.out.println(u2.NAME + "의 체력은" + u2.hp + "입니다");
	}

	static void attack(Zealot u1, Zealot u2) {
		u2.hp = u2.hp - u1.attack;
		System.out.println(u2.NAME + "이 공격당하고 있습니다.");
		System.out.println(u2.NAME + "의 체력은" + u2.hp + "입니다");
	}

	static void attack(Zealot u1, DarkTempler u2) {
		u2.hp = u2.hp - u1.attack;
		System.out.println(u2.NAME + "이 공격당하고 있습니다.");
		System.out.println(u2.NAME + "의 체력은" + u2.hp + "입니다");
	}

	static void attack(Zealot u1, River u2) {
		u2.hp = u2.hp - u1.attack;
		System.out.println(u2.NAME + "이 공격당하고 있습니다.");
		System.out.println(u2.NAME + "의 체력은" + u2.hp + "입니다");
	}

	static void attack(Dragoon u1, Zealot u2) {
		u2.hp = u2.hp - u1.attack;
		System.out.println(u2.NAME + "이 공격당하고 있습니다.");
		System.out.println(u2.NAME + "의 체력은" + u2.hp + "입니다");
	}

	static void attack(Dragoon u1, Dragoon u2) {
		u2.hp = u2.hp - u1.attack;
		System.out.println(u2.NAME + "이 공격당하고 있습니다.");
		System.out.println(u2.NAME + "의 체력은" + u2.hp + "입니다");
	}

	static void attack(Dragoon u1, DarkTempler u2) {
		u2.hp = u2.hp - u1.attack;
		System.out.println(u2.NAME + "이 공격당하고 있습니다.");
		System.out.println(u2.NAME + "의 체력은" + u2.hp + "입니다");
	}

	static void attack(Dragoon u1, River u2) {
		u2.hp = u2.hp - u1.attack;
		System.out.println(u2.NAME + "이 공격당하고 있습니다.");
		System.out.println(u2.NAME + "의 체력은" + u2.hp + "입니다");
	}

	static void attack(DarkTempler u1, River u2) {
		u2.hp = u2.hp - u1.attack;
		System.out.println(u2.NAME + "이 공격당하고 있습니다.");
		System.out.println(u2.NAME + "의 체력은" + u2.hp + "입니다");
	}

	static void attack(DarkTempler u1, Dragoon u2) {
		u2.hp = u2.hp - u1.attack;
		System.out.println(u2.NAME + "이 공격당하고 있습니다.");
		System.out.println(u2.NAME + "의 체력은" + u2.hp + "입니다");
	}

	static void attack(DarkTempler u1, Zealot u2) {
		u2.hp = u2.hp - u1.attack;
		System.out.println(u2.NAME + "이 공격당하고 있습니다.");
		System.out.println(u2.NAME + "의 체력은" + u2.hp + "입니다");
	}

	static void attack(DarkTempler u1, DarkTempler u2) {
		u2.hp = u2.hp - u1.attack;
		System.out.println(u2.NAME + "이 공격당하고 있습니다.");
		System.out.println(u2.NAME + "의 체력은" + u2.hp + "입니다");
	}

	static void attack(River u1, River u2) {
		u2.hp = u2.hp - u1.attack;
		System.out.println(u2.NAME + "이 공격당하고 있습니다.");
		System.out.println(u2.NAME + "의 체력은" + u2.hp + "입니다");
	}

	static void attack(River u1, DarkTempler u2) {
		u2.hp = u2.hp - u1.attack;
		System.out.println(u2.NAME + "이 공격당하고 있습니다.");
		System.out.println(u2.NAME + "의 체력은" + u2.hp + "입니다");
	}

	static void attack(River u1, Dragoon u2) {
		u2.hp = u2.hp - u1.attack;
		System.out.println(u2.NAME + "이 공격당하고 있습니다.");
		System.out.println(u2.NAME + "의 체력은" + u2.hp + "입니다");
	}

	static void attack(River u1, Zealot u2) {
		u2.hp = u2.hp - u1.attack;
		System.out.println(u2.NAME + "이 공격당하고 있습니다.");
		System.out.println(u2.NAME + "의 체력은" + u2.hp + "입니다");
	}

	public static void main(String[] args) {
		// 공격력 업그레이드 하기
		Zealot.attack++;
		// 질럿생성
		Zealot z1 = new Zealot("1번질럿");
		System.out.println(Zealot.attack);
		Zealot z2 = new Zealot("2번질럿");
		System.out.println(Zealot.attack);

		Dragoon d1 = new Dragoon("1번드라군");
		System.out.println(Dragoon.attack);
		Dragoon d2 = new Dragoon("2번드라군");

		DarkTempler t1 = new DarkTempler("1번 다크템플러");
		DarkTempler t2 = new DarkTempler("2번 다크템플러");

		River r1 = new River("1번 리버 ");
		River r2 = new River("1번 리버 ");
		// 공격하기
		attack(z1, d1);
		attack(z1, t1);
		attack(z1, z2);
		attack(z1, r1);

		attack(d1, z1);
		attack(d1, d2);
		attack(d1, r1);
		attack(d1, t1);

		attack(t1, z1);
		attack(t1, d1);
		attack(t1, t2);
		attack(t1, r1);

		attack(r1, z1);
		attack(r1, d1);
		attack(r1, r2);
		attack(r1, t1);

	}

}
