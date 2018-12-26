package ex8_15_3_interface.sample3;

public class B implements I {
	B() {
	}

	public void methodB() {
		System.out.println("method in class B");
	}
	
	//overrides java.lang.Object.toString
	//최상위 클래스 Object의 toString()을 오버라이딩.
	public String toString(){
		return "class B";
	}
}
