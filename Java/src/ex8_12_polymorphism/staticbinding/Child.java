package ex8_12_polymorphism.staticbinding;

public class Child extends Parent {
	public String message = "Child";
	
	public void childPrn(){
		System.out.println("���� Ŭ���� : childPrn �޼ҵ�");
	}

	public static void parentPrn(){
		System.out.println("���� Ŭ���� : parentPrn �޼���");
	}
}
