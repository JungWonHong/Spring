package ex7_0_object;

public class Saram_make {

	public static void main(String[] args) {
		Saram  s   =  new Saram();
	//  Ŭ���� �������� = ������ ������ȣ��	
		s.name = "������";
		s.age = 17;
		s.w = 40;
		s.ki = 160;
		System.out.println(s.name);
		s.eat();
		
		Saram s2 = new Saram();
		s2.name = "�ں���";
		s2.age = 23;
		s2.w = 65;
		s2.ki = 182;
		System.out.println(s2.name);
		s2.eat();

	}

}
