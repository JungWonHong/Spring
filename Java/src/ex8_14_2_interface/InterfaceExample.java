package ex8_14_2_interface;
//���ົ Ŭ������ �η� CD Ŭ������ ����ϴ� ���α׷�
public class InterfaceExample {

	public static void main(String[] args) {
		SeparateVolume obj1 = new SeparateVolume("863��774��", "����", "��������");
		obj1.checkOut("�迵��", "2017-04-11");
		obj1.checkIn();
		
		AppCDInfo obj2 = new AppCDInfo("2005-7001", "Redhat Fedora");
		obj2.checkOut("�����", "2017-04-11");
		obj2.checkIn();
	}

}
