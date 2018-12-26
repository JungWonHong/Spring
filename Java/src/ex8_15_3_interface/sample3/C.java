package ex8_15_3_interface.sample3;

public class C implements I {
	C() {
	}

	public void methodB() {
		System.out.println("method in class C");
	}
	
	//overrides java.lang.Object.toString
	public String toString(){
		return "class C";
	}
}
