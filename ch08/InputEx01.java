package ch08;

import java.io.IOException;
import java.io.InputStream;
//steam �� byte --> ���� �帧
//���� �带�� ���������� ��ŵθ� ���� �帣�� �ʴ´�.
//���� �带�� ���������� ���� ���� �帥�� (��� ����)
//�� = ����Ʈ
public class InputEx01 {
	
	public static void main(String[] args) {
	InputStream in = System.in; //Ű���忡 ����� byte ��Ʈ�� 
	try {
		int data = in.read();
		System.out.println((char)data);
	} catch (IOException e) {  
	// ������ �߻������� �������� �����,� ������ �߻��ߴ��� ������ش�.
		System.out.println("IO ������ �߻�");
		e.getMessage();
		// ������� �߻��ߴ��� �����ش�.
		e.printStackTrace(); 
		// �� ������ ���ؼ� ������� �߻��ߴ��� �ΰ����ΰͱ��� �����ش�
	}  
	}

}
