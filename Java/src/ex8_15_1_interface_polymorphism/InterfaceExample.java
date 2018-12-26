package ex8_15_1_interface_polymorphism;
//���ົ Ŭ������ �η� CD Ŭ������ ����ϴ� ���α׷�
public class InterfaceExample {

	public static void main(String[] args) {
		Lendable arr0, arr1, arr2;
		
		arr0 = new SeparateVolume("883��", "Ǫ���� ����", "����");
		arr1 = new SeparateVolume("609.2", "����̼���", "���긮ġ");
		arr2 = new AppCDInfo("02-17", "XML�� ���� �ڹ� ���α׷���");
		
		//���� ����� ���� ��¥�� ���ົ 2�ǰ� �η�CD�� ������ ����Դϴ�.
		checkOutAll(arr0, "������", "20161012");
		checkOutAll(arr1, "������", "20161012");
		checkOutAll(arr2, "������", "20161012");
	}
	
	//�ڹ� �����Ϸ��� ������ �� �� ������ Ÿ�Ը� ���� �޼ҵ峪
	//�ʵ��� ���� ���θ� üũ�ϱ� ������
	//Lendable �������̽��� checkOut �޼ҵ尡 �־�� ������ ������ �����ϴ�.
	static void checkOutAll(Lendable arr, String borrower, String date){
		arr.checkOut(borrower, date);
	}

}
