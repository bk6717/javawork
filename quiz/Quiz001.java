package quiz;

//String Ÿ���� .charAt(index)�� �ش���ġ�� ���ڸ� �ҷ��� ���ִ�.

//������� "������".charAt(0) ��  '��' �̴�

//�Ʒ� �־��� numStr�� charAt�� for���� �̿��Ͽ� �ѱ��ھ� ����غ���

public class Quiz001 {
	public static void main(String[] args) {
		String numStr = "0123456789";
		
		for (int i = 0; i < numStr.length(); i++) {
			System.out.println(numStr.charAt(i));
		}
	}

}