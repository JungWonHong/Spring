package ex9_11;
//Ŭ���� �ȿ� ���� Ÿ���� ������ ��
//���� ��� : ����Ÿ���� ���ϴ� Ŭ���� �̸�.���� Ÿ���̸�.���� ��� �̸�
//��) ClothingInfo.Season.SUMMER
public class NewExample2 {

	public static void main(String[] args) {
		ClothingInfo obj = new ClothingInfo("32919", 
				"���� Ƽ����", "��100%", ClothingInfo.Season.SUMMER);
									//Ŭ������.����Ÿ��.���
		System.out.println("��ǰ�ڵ�: " + obj.code);
		System.out.println("��ǰ��: " + obj.name);
		System.out.println("����: " + obj.material);
		System.out.println("��������: " + obj.season);
	}

}
