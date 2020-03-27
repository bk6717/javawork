package array03;

public class StarEx02 {

	static void printStars(int i) {
		for (int q = 1; q < 5; q++) {
		
			for (int a = 0; a < 4 - i; a++) {
				System.out.print("_");
			}
			for (int b = 0; b < i; b++) {
				System.out.print("*");
			}
		}
	}
	public static void main(String[] args) {
		printStars(1);
		System.out.println();
		printStars(2);
		System.out.println();
		printStars(3);
		System.out.println();
		printStars(4);
		System.out.println();
	}
}
