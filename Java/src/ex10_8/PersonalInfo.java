//private �����ڸ� �����ϴ� Ŭ������ ��
//ù ��° �����ڴ� private���� ����Ǿ� �ֱ� ������ Ŭ���� �ܺο��� ����� �� ����.
//�� ��° �����ڿ� �� ��° �����ڴ� ���� Ŭ���� ���� ù ��° �����ڸ� ȣ���� �� �ִ�.
package ex10_8;

public class PersonalInfo {
	String name;
	int age;
	char gender; // ��, ��
	String bloodType; // A, B, AB, O

	private PersonalInfo(String name, int age) { //�ʼ��Է»������� ���������� ���.
		this.name = name;
		this.age = age;
	}

	PersonalInfo(String name, int age, char gender) {
		this(name, age); // �Ű����� �ΰ��� ������ ȣ��
		this.gender = gender;
	}

	PersonalInfo(String name, int age, char gender, String bloodType) {
		this(name, age);
		this.gender = gender;
		this.bloodType = bloodType;
	}
}
