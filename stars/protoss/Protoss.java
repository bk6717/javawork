package stars.protoss;

import java.util.jar.Attributes.Name;

import stars.Behavior;

public abstract class Protoss implements Behavior{
	public void move() {
		System.out.println("�̵�");
	}
	@Override
	public void repair() {
		System.out.println("���� ġ��");
	}
	public static void upgrade() {
		Zealot.attack ++ ;
		Dragoon.attack ++;
		System.out.println("�����佺 ���׷��̵� �Ϸ�");
	}
}
