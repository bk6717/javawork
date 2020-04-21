package ch06;

class Animal{
	@Override
	public int hashCode() {
		return super.hashCode();   
	}
}

public class ObjectEx01 {
	public static void main(String[] args) { //교제 p.343
		String d1 = "물";
		String d2 = "물";
		
		System.out.println(d1.equals(d2));
		System.out.println(d1 == d2);   
	
		String d3 = new String("물");
		String d4 = new String("물");
		
		System.out.println(d3.equals(d4));
		System.out.println(d3 == d4);
		
		System.out.println(d3.getClass()); //클래스의 경로와 이름을 리턴해준다.
		System.out.println(new ObjectEx01().getClass());
	
		//해쉬코드 -> 해쉬 알고리즘 = 동일한 길이의 숫자로 리턴해준다. > int hashCode
		System.out.println(d3.hashCode());
		System.out.println(d4.hashCode());
		
		//원래 다르게나오지만 스트링만 Java에서 값이 같으면 같은코드가 나오게 바꿨다 
		//같은것인지 다른것인지 알수가있다 (진위여부)
		Animal a1 = new Animal();
		Animal a2 = new Animal();
		System.out.println(a1.hashCode());
		System.out.println(a2.hashCode());
		
		//타입이 같은지 비교 , 공간이다르고 타입은 같다
		System.out.println(a1 instanceof Animal);

	}
}
