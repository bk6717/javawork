package ch08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

//ĳ������ �����ʰ� ���ڷ� �д�...
//�Ѱ� �̻��� �ް������. 
public class InputEx02 {

	public static void main(String[] args) {
		InputStream in = System.in;
		InputStreamReader reader = new InputStreamReader(in); 
		BufferedReader br1 = new BufferedReader(reader);
		// �� ������  �Ʒ� ���ٷ� ����!
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		String data = "";
		try {
			while((data = br1.readLine()) != null)
				
				System.out.println(data);
		} catch (IOException e) {
			e.printStackTrace();
		}     //�迭�� ���۷��� �ڷ��� (��)
	}
}
