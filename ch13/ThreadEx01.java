package ch13;

//os는 Runnerble 타입의 heap공간에 run메서드를 호출해야한다는걸 이미 알고있다.
//Runnable 대신에 Thead를 사용해도된다.
class Sub implements Runnable{   // 강제성 부여 (스택의 이름이 정해져있음)
	
		String data = "값 없음";
		
    	@Override
		public void run() {   //스레드는 os(윈도우)가 들고있다. 
    		for (int i = 1; i < 10; i++) {
				System.out.println("서브 쓰레드 :"+i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
    		data = "안녕";
		}
}

public class ThreadEx01 {
	//메인 쓰레드 
	public static void main(String[] args) {
		Thread t1 = new Thread(new Sub());   // Sub 힙에 run 이 뜬다.
		t1.start(); // 런을 내가 때리는게 아니라 os가 한다.
		
	for (int i = 1; i < 6; i++) {
		System.out.println("메인 쓰레드"+i);
	try {
		Thread.sleep(1000); // 1초마다
	} catch (Exception e) {  //Exception으로 통일 (부모클래스) 
		e.printStackTrace();
	}	
	}
}
}
