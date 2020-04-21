package burger01;

import composite.ShBurger;

public class ShBurgerset01 {
	private ShBurger01 shBurger01;
	private Coke01 coke01;
	private FrenchFried01 frenchFried01;
	
	public ShBurgerset01() {
		this(
				new ShBurger01(),
				new Coke01(),
				new FrenchFried01()
				);
	}
	public ShBurgerset01(ShBurger01 shBurger01, Coke01 coke01 , FrenchFried01 frenchFried01) {
		this.shBurger01 = shBurger01;
		this.coke01 = coke01;
		this.frenchFried01 = frenchFried01;
	}
	public ShBurgerset01(ShBurger01 shBurger01) {
		this(shBurger01,null,null);
	}
}
