package quiz;

//���ڿ� �޼��� split�� � ���ڿ��� ���ڸ� �������� ����� �迭�� �����

//"����and����".split("and") �� ����ϸ� �迭 {"����","����"}�� �����ȴ�

//	�Ʒ��� ���ڿ��� split�� �̿��Ͽ� "������ġ"�� ����غ���

public class Quiz007 {
	
	public static void main(String[] args) {
		String a = "�Ƶ�����:�Ե�����:����ŷ:��������:������ġ";	
		String b []  = a.split(":");
		
		String b1 = b[0];  	//�Ƶ�����
		String b2 = b[1];	//�Ե�����
		String b3 = b[2];	//����ŷ
		String b4 = b[3];	//��������
		String b5 = b[4];	//������ġ
		
		
		System.out.println(b5);
		
		
	}
}