package composite;

public class LotteriaApp {
	public static void main(String[] args) {
		//BigBurgerSet �߰���!
		BigBurgerSet set1 = new BigBurgerSet();
		System.out.println();
		//burger �߰���
		Burger burger1 = new Burger();
		System.out.println();
		//�ݶ� �߰���.
		Coke coke1 = new Coke();
		System.out.println();
		//bigbIherSet �߰���!! ���� 1000�� ��������
		BigBurgerSet set2 = new BigBurgerSet(
						   new BigBurger(3000 ,"����� ����"), 
						   new Coke(),
						   new FrenchFried()
						   );
		System.out.println(set2.getBigBurger().getPrice());
		System.out.println();
		// 2000 �� ��������
		BigBurgerSet set3 = new BigBurgerSet(
				new BigBurger(2000, "����� ����")
				);	
		System.out.println(set3.getBigBurger().getPrice());
		//������ż�Ʈ �߰�
		
	}
}
