package report_0404;

public class Saram {
	String name;
	double w;
	double ki;
	int age;
	String blood;

	Saram() {
	}

	Saram(String name, double w) {
		this.name = name;
		this.w = w;
	}

	Saram(String name, double w, double ki) {
		this.name = name;
		this.w = w;
		this.ki = ki;
	}

	Saram(String name, double w, double ki, int age) {
		this.name = name;
		this.w = w;
		this.ki = ki;
		this.age = age;
	}

	Saram(String name, double w, double ki, int age, String blood) {
		this.name = name;
		this.w = w;
		this.ki = ki;
		this.age = age;
		this.blood = blood;
	}

	public void eat() {
		System.out.println(name + " ���� �Դ´�.");
	}

	public void walk() {
		System.out.println("�ȱ��� �����Դ� " + w + "�Դϴ�.");
	}

	public void sesu() {
		System.out.println(name + " �����Ѵ�.");
	}
}
