package stars.protoss;

import java.util.jar.Attributes.Name;

import stars.Behavior;

public abstract class Protoss implements Behavior{
	public void move() {
		System.out.println("이동");
	}
	@Override
	public void repair() {
		System.out.println("쉴드 치료");
	}
	public static void upgrade() {
		Zealot.attack ++ ;
		Dragoon.attack ++;
		System.out.println("프로토스 업그레이드 완료");
	}
}
