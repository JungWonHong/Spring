package ex8_15_3_interface.sample3;

public class B implements I {
	B() {
	}

	public void methodB() {
		System.out.println("method in class B");
	}
	
	//overrides java.lang.Object.toString
	//�ֻ��� Ŭ���� Object�� toString()�� �������̵�.
	public String toString(){
		return "class B";
	}
}
