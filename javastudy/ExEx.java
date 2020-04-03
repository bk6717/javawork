package javastudy;

import lombok.Getter;

//담배를 상속받아서 카멜, 필라멘트, 던힐, 말보로 클래스를 생성하라

//카멜은 5000원 , 필라멘트는 4000원, 던힐은 3000원, 말보로는 3500원이다.

//담배 이름과 가격은 private 다

//메인에서 sysout을 이용해서 담배 4종류를 출력하라  예시) 카멜은 5000원 입니다.



abstract class 담배 {
	abstract String getName();
	abstract int getPrice();
}

class 카멜 extends 담배{
	private String name = "카멜";
	private int price = 5000;
	@Override
	String getName() {
		
		return name ;
	}
	@Override
	int getPrice() {
		// TODO Auto-generated method stub
		return price;
	}
}

class 필라멘트 extends 담배{
	private String name = "필라멘트";
	private int price = 4000;
	@Override
	String getName() {
		// TODO Auto-generated method stub
		return name ;
	}
	@Override
	int getPrice() {
		// TODO Auto-generated method stub
		return price;
	}
}

class 던힐 extends 담배{
	private String name = "던힐";
	private int price = 3000;
	@Override
	String getName() {
		// TODO Auto-generated method stub
		return name ;
	}
	@Override
	int getPrice() {
		// TODO Auto-generated method stub
		return price;
	}
}

class 말보로 extends 담배{
	private String name = "말보로";
	private int price = 3500;
	@Override
	String getName() {
		// TODO Auto-generated method stub
		return name ;
	}
	@Override
	int getPrice() {
		// TODO Auto-generated method stub
		return price;
	}
}
//메인에서 sysout을 이용해서 담배 4종류를 출력하라  예시) 카멜은 5000원 입니다.
public class ExEx {

	public static void main(String[] args) {
		담배 a = new 카멜();
		담배 b = new 필라멘트();
		담배 c= new 던힐();
		담배 d = new 말보로();
		
		System.out.println(a.getName() + "은" + a.getPrice()+"입니다.");
		System.out.println(b.getName() + "은" + b.getPrice()+"입니다.");
		System.out.println(c.getName() + "은" + c.getPrice()+"입니다.");
		System.out.println(d.getName() + "은" + d.getPrice()+"입니다.");

	}

}
