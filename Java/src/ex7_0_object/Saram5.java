package ex7_0_object;

public class Saram5 {
	//������(�ʵ�)
	String name;
	double w;
	double ki;
	int age;

	// ������ - �ݵ�� Ŭ���� �̸��� �Ȱ��� ���� Ÿ���� ����� �Ѵ�.
	Saram5(String name2, double w2) {
		this.name = name2;   //���� Ŭ�������� �������� this���.
		this.w = w2;
	}
	
	Saram5(double w2, String name2){ //������ �����ε�.(���� �Ű����� ������ �ٲ�)
		this.name = name2;
		this.w=w2;
	}

	public void eat() {
		System.out.println(name + "��(��) ���� �Դ´�.");
	}

	public void walk() {
		System.out.println("�ȱ��� �����Դ� " + w + "�Դϴ�.");
	}

	public void sesu() {
		System.out.println(name + "��(��) �����Ѵ�.");
	}

}
