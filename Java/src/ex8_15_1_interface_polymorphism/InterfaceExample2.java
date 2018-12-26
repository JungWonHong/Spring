package ex8_15_1_interface_polymorphism;
//���ົ Ŭ������ �η� CD Ŭ������ ����ϴ� ���α׷�
public class InterfaceExample2 {

	public static void main(String[] args) {
		Lendable[] arr = new Lendable[3];
		
		arr[0] = new SeparateVolume("883��", "Ǫ���� ����", "����");
		arr[1] = new SeparateVolume("609.2", "����̼���", "���긮ġ");
		arr[2] = new AppCDInfo("02-17", "XML�� ���� �ڹ� ���α׷���");
		
		checkOutAll(arr, "������", "20161012");
		// �迭�� �����ּҸ� �Ѱ��ش�.
	}
	
	//�ڹ� �����Ϸ��� ������ �� �� ������ Ÿ�Ը� ���� �޼ҵ峪
	//�ʵ��� ���� ���θ� üũ�ϱ� ������
	//Lendable �������̽��� checkOut �޼ҵ尡 �־�� ������ ������ �����ϴ�.
	static void checkOutAll(Lendable[] arr, String borrower, String date) {
		for (int i = 0; i < arr.length; i++)
			arr[i].checkOut(borrower, date);
	}

}
