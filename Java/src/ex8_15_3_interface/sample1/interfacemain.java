package ex8_15_3_interface.sample1;
//Ŭ���� A�� ���Ǳ� ���ؼ��� Ŭ���� B�� �̹� �ۼ��Ǿ� �־�� �մϴ�.
//���� Ŭ���� B�� �޼��� ����ΰ� ����Ǹ� �̸� ����ϴ� Ŭ���� A�� ����Ǿ�� �մϴ�.
//BŬ������ ����Ǹ� AŬ������ ����Ǿ�� �մϴ�.
public class interfacemain {

	public static void main(String[] args) {
		A a = new A();
		a.methodA(new B()); //B b = new B();
	}

}
