package burger01;

public class LotteriaApp01 {
	public static void main(String[] args) {
		//BigBurgerSet 추가!
		BigBurgerSet01 set1 = new BigBurgerSet01();
		System.out.println();
		//감자튀김 추가!
		FrenchFried01 f1 = new FrenchFried01();
		System.out.println();
		//콜라 추가!
		Coke01 c1 = new Coke01();
		System.out.println();
		//BigBurgerSet 중 빅버거 2000원 할인
		BigBurgerSet01 set2 = new BigBurgerSet01(new BigBurger01(2000,"빅버거할인"));
		//ShBurgerset 중 새우버거 3000원 할인
		ShBurgerset01 set03 = new ShBurgerset01(new ShBurger01(3000,"새우버거 할인"));
			
	}

}
