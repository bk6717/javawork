package a;

public class App extends ProtectedData {
	public static void main(String[] args) {
		PublicData p = new PublicData();
		System.out.println(p.num);

		DefaltData d = new DefaltData();
		// System.out.println(d.num); // dafalt�� ���� ��Ű�� �������� ���٤�����

		PrivateData a = new PrivateData();
		// private �� �ڱ�Ŭ���� �ȿ����� ������ �����ϴ�
		// System.out.println(a.num); �ȵ�..

		ProtectedData pr = new ProtectedData();
		App pp = new App();
		System.out.println(pr.num);
		// protected �����ʹ� ���� ��Ű�� �ƴϸ� �ڽ�Ŭ������ ã�� �� �ִ�.
		// �ٸ���Ű������ ã���� �ִ� ������ ����� extends
	}
}
