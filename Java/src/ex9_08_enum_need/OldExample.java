package ex9_08_enum_need;
//�Ƿ� ���� Ŭ������ ����ϴ� ���α׷�
public class OldExample {

	public static void main(String[] args) {
		
		//ClothingInfo.SUMMER : ClothingInfo Ŭ������ ����� ��� �ʵ带 ���
		ClothingInfo obj = new ClothingInfo("32919", "���� Ƽ����", "��100%", ClothingInfo.SUMMER);
		
		System.out.println("��ǰ�ڵ�: " + obj.code);
		System.out.println("��ǰ��: " + obj.name);
		System.out.println("����: " + obj.material);
		System.out.println("��������: " + obj.season);

	}

}
