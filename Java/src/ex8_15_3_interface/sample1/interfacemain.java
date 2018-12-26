package ex8_15_3_interface.sample1;
//클래스 A가 사용되기 위해서는 클래스 B가 이미 작성되어 있어야 합니다.
//만약 클래스 B의 메서드 선언부가 변경되면 이를 사용하는 클래스 A도 변경되어야 합니다.
//B클래스가 변경되면 A클래스도 변경되어야 합니다.
public class interfacemain {

	public static void main(String[] args) {
		A a = new A();
		a.methodA(new B()); //B b = new B();
	}

}
