package ex8_15_3_interface.sample2;

public class interfacemain {

	public static void main(String[] args) {
		A a = new A();
		
		//�Ű������� ���ؼ� �������̽� I�� ������ Ŭ����(B�� C)�� �ν��Ͻ��� ���� �޾ƾ� �մϴ�.
		//���� ���ε�
		//������
		a.methodA(new B()); // I i = new B()
		a.methodA(new C()); // I i = new C()
	}

}
