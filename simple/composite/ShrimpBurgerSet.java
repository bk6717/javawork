package simple.composite;

import lombok.Data;

@Data
public class ShrimpBurgerSet {

	// ��������(�߿�) - ����� �ƴ� ����� ���� Ŭ������ �������� ��
	private ShrimpBurger shrimpBurger;
	private Coke coke;
	private FrenchFried frenchFried;
	
	public ShrimpBurgerSet() {
		this(new ShrimpBurger(), new Coke(), new FrenchFried());
	}
	
	public ShrimpBurgerSet(ShrimpBurger shrimpBurger) {
		this(shrimpBurger, new Coke(), new FrenchFried());
	}
	
	public ShrimpBurgerSet(Coke coke) {
		this(new ShrimpBurger(), coke, new FrenchFried());
	}
	
	public ShrimpBurgerSet(FrenchFried frenchFried) {
		this(new ShrimpBurger(), new Coke(), frenchFried);
	}
	
	public ShrimpBurgerSet(ShrimpBurger shrimpBurger, Coke coke) {
		this(shrimpBurger, coke, new FrenchFried());
	}
	
	public ShrimpBurgerSet(ShrimpBurger shrimpBurger, FrenchFried frenchFried) {
		this(shrimpBurger, new Coke(), frenchFried);
	}
	
	public ShrimpBurgerSet(Coke coke, FrenchFried frenchFried) {
		this(new ShrimpBurger(), coke, frenchFried);
	}
	
	
	// �����ڰ� ���� ���� ���� ����
	public ShrimpBurgerSet(ShrimpBurger shrimpBurger, Coke coke, FrenchFried frenchFried) {
		this.shrimpBurger = shrimpBurger;
		this.coke = coke;
		this.frenchFried = frenchFried;
	}
	
	public static void main(String[] args) {
		System.out.println(new ShrimpBurgerSet().getShrimpBurger());
	}
}