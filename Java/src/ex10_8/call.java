package ex10_8;

public class call {

	public static void main(String[] args) {
		//PersonalInfo p1 = new PersonalInfo("Ƽ�Ĵ�", 21);
		PersonalInfo p2 = new PersonalInfo("Ƽ�Ĵ�", 21, '��');
		print(p2);
		PersonalInfo p3 = new PersonalInfo("Ƽ�Ĵ�", 21, '��', "A");
		print(p3);
	}

	static void print(PersonalInfo obj) {
		System.out.println("�̸� : " + obj.name);
		System.out.println("���� : " + obj.age);
		System.out.println("���� : " + obj.gender);
		System.out.println("������ : " + obj.bloodType);
	}
}
