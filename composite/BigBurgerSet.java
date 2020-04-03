package composite;


import lombok.Data;

//자바는 다중 상속이 안된다.
//컴포지션 상속으로만들어지는것이아니라 재사용 
@Data
public class BigBurgerSet {
	private BigBurger bigBurger;
	private Coke coke;
	private FrenchFried frenchFried;
	
	public BigBurgerSet() {
		this(
				new BigBurger(),
				new Coke(),
				new FrenchFried()
				);
	}
	
	public BigBurgerSet(BigBurger bigBurger, Coke coke, FrenchFried frenchFried) {
		this.bigBurger = bigBurger;
		this.coke = coke;
		this.frenchFried = frenchFried;
		
	}
	public BigBurgerSet(BigBurger bigBurger) {
		this (bigBurger,null,null);
	}
}
