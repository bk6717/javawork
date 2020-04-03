package stars;

import java.util.jar.Attributes.Name;

import stars.protoss.Dragoon;
import stars.protoss.Protoss;
import stars.protoss.Zealot;
import stars.terran.Tank;

public class StartGame {
	
	public static void move(Behavior b) {
		b.move();
		System.out.println();
	}
	public static void repair(Behavior b) {
		b.repair();
	}
	public static void attack(Behavior b1,Behavior b2) {
		b1.attack(b2);
		System.out.println(b1.getName()+"이 " + b2.getName()+"을 공격합니다");
		System.out.println(b2.getName()+"의 현재 체력은" );
	}
	public static void main(String[] args) {
		Protoss.upgrade();
		Zealot z1 = new Zealot("질럿");
		Dragoon d1 = new Dragoon("드라군");
		Tank t1 = new Tank("탱크");
		move(t1);
		move(z1);
		repair(z1);
		attack(z1, d1);
	}
}
