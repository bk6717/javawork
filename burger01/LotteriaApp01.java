package burger01;

public class LotteriaApp01 {
	public static void main(String[] args) {
		//BigBurgerSet �߰�!
		BigBurgerSet01 set1 = new BigBurgerSet01();
		System.out.println();
		//����Ƣ�� �߰�!
		FrenchFried01 f1 = new FrenchFried01();
		System.out.println();
		//�ݶ� �߰�!
		Coke01 c1 = new Coke01();
		System.out.println();
		//BigBurgerSet �� ����� 2000�� ����
		BigBurgerSet01 set2 = new BigBurgerSet01(new BigBurger01(2000,"���������"));
		//ShBurgerset �� ������� 3000�� ����
		ShBurgerset01 set03 = new ShBurgerset01(new ShBurger01(3000,"������� ����"));
			
	}

}
