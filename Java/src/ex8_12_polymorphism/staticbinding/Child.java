package ex8_12_polymorphism.staticbinding;

public class Child extends Parent {
	public String message = "Child";
	
	public void childPrn(){
		System.out.println("서브 클래스 : childPrn 메소드");
	}

	public static void parentPrn(){
		System.out.println("서브 클래스 : parentPrn 메서드");
	}
}
