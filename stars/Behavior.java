package stars;


//�߻�Ŭ������ ���� 
// �ٸ����� �߻� �޼��常 ���簡��
//�������ε��� ��η� ���
public interface Behavior { // ��������� �������ΰ͸�.
	 void move();
	 void repair();
	 void attack(Behavior u);
	 public String getName();
	 public int getHp();
	 public int setHp(int hp);
}
