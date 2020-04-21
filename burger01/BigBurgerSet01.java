package burger01;

import lombok.Data;

@Data
public class BigBurgerSet01 {
	private BigBurger01 bigBurger01;
	private Coke01 coke01;
	private FrenchFried01 frenchFried01;
	
	public BigBurgerSet01() {
		this(
				new BigBurger01(),
			    new Coke01(),
			    new FrenchFried01() 
		);
	}

	/*
	 * public BigBurgerSet01(BigBurger01 bigBurger01) { this( bigBurger01, new
	 * Coke01(), new FrenchFried01() );
	 */
	//}
	public BigBurgerSet01(BigBurger01 bigBurger01, Coke01 coke01 , FrenchFried01 frenchFried01) {
		this.bigBurger01 = bigBurger01;
		this.coke01 = coke01;
		this.frenchFried01 = frenchFried01;
	}
	public BigBurgerSet01(BigBurger01 bigBurger01) {
		this(bigBurger01,null,null);
	}
}
