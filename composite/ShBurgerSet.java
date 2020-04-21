package composite;

import lombok.Data;

@Data
public class ShBurgerSet {

	private ShBurger shBurger;
	private Coke coke;
	private FrenchFried frenchFried;

	public ShBurgerSet() {
		this(
				new ShBurger(),
				new Coke(),
				new FrenchFried()
				);
	}
		
	public ShBurgerSet(ShBurger shgBurger, Coke coke, FrenchFried frenchFried) {
		this.shBurger = shBurger;
		this.coke = coke;
		this.frenchFried = frenchFried;
}
}

