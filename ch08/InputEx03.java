package ch08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputEx03 {
	public static void main(String[] args) {

		InputStream in = System.in; // Ű���忡 ����� byte ��Ʈ��
		
		InputStreamReader reader = new InputStreamReader(in);

		BufferedReader br = new BufferedReader(reader);

		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));

		String data = "";
		try {
			while((data = br2.readLine()) != null) { // ���ۿ� �ƹ��͵� ������ ����ȴ�.���ǹ�
				
				System.out.println(data); // �ʱ�ȭ ������ ������ ������ ����.
				// ���۸� ��ﶧ readLine
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}