package airplane;

import java.util.HashMap;

public class FlightInforService {
	
	//1�� ��ü : ���� �ۿ� ������ �ִ� ��ü
	//1�� ��ü �߿����� ObJect �� �ִ�. 
	// �ڹ� ��ũ��Ʈ������ ���� 1�ް�ü ���� Heap
	// �ڹٿ����� Ŭ������ 1�ް�ü
	public static HashMap<String, String> airLineId = new HashMap<>(); //Util Ŭ���� 
	
	public static HashMap<String, String> airPortId = new HashMap<>();  

	public static void setAirLineId() {
		airLineId.put("�ƽþƳ��װ�", "AAR");
		airLineId.put("����λ�", "ABL");
		airLineId.put("�̽�Ÿ�װ�", "ESR");
		airLineId.put("�����װ�", "JJA");
		airLineId.put("�� ����", "JNA");
		airLineId.put("���� �װ�", "KAL");
		airLineId.put("Ƽ�����װ�", "TWB");
	}
	public static void setAirPortId() {
		airPortId.put("����","NAARKJB");
		airPortId.put("����","NAARKJJ");
		airPortId.put("����","NAARKJK");
		airPortId.put("����","NAARKJY");
		airPortId.put("����","NAARKNW");
		airPortId.put("���","NAARKNY");
		airPortId.put("����","NAARKPC");
		airPortId.put("����","NAARKPK");
		airPortId.put("��õ","NAARKPS");
		airPortId.put("���","NAARKPU");
		airPortId.put("��õ","NAARKSI");
		airPortId.put("����","NAARKSS");
		airPortId.put("����","NAARKTH");
		airPortId.put("�뱸","NAARKTN");
		airPortId.put("û��","NAARKTU");
	}
}
