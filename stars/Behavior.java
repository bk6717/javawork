package stars;


//추상클래스와 유사 
// 다른점은 추상 메서드만 존재가능
//동적바인딩의 통로로 사용
public interface Behavior { // 모든유닛의 공통적인것만.
	 void move();
	 void repair();
	 void attack(Behavior u);
	 public String getName();
	 public int getHp();
	 public int setHp(int hp);
}
