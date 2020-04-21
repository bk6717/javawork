package ch13;

//os�� Runnerble Ÿ���� heap������ run�޼��带 ȣ���ؾ��Ѵٴ°� �̹� �˰��ִ�.
//Runnable ��ſ� Thead�� ����ص��ȴ�.
class Sub implements Runnable{   // ������ �ο� (������ �̸��� ����������)
	
		String data = "�� ����";
		
    	@Override
		public void run() {   //������� os(������)�� ����ִ�. 
    		for (int i = 1; i < 10; i++) {
				System.out.println("���� ������ :"+i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
    		data = "�ȳ�";
		}
}

public class ThreadEx01 {
	//���� ������ 
	public static void main(String[] args) {
		Thread t1 = new Thread(new Sub());   // Sub ���� run �� ���.
		t1.start(); // ���� ���� �����°� �ƴ϶� os�� �Ѵ�.
		
	for (int i = 1; i < 6; i++) {
		System.out.println("���� ������"+i);
	try {
		Thread.sleep(1000); // 1�ʸ���
	} catch (Exception e) {  //Exception���� ���� (�θ�Ŭ����) 
		e.printStackTrace();
	}	
	}
}
}
