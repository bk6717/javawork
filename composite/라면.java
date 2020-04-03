package composite;

public class 라면 {
	
	String item1;
	String item2;
	String item3;
	
	public 라면() {
		this("물","건더기","분말");
	}
	public  라면(String item1,String item3) {
		this(item1,null,item3);
	}
	
	public 라면(String item1, String item2, String item3) {
		this.item1 = item1;
		this.item2 = item2;
		this.item3 = item3;
	}
	
	
 public static void main(String[] args) {
	라면  l1 = new 라면("물","건더기","분말");
	라면  l2 = new 라면("물","라면");
	System.out.println(l2.item3);

}
}
