package ex7_18_singleton;

public class Singleton {

	//private : �ܺο��� �����ڸ� ȣ���� �� ������ �����ϴ�.
	private Singleton() {	}

	//�ʵ� s�� �ܺο��� ��� ���մϴ�.
	static private Singleton s = new Singleton();
	
	static Singleton getInstance(){
		System.out.println("����� getInstance�Դϴ�.");
		return s;
	}
}
