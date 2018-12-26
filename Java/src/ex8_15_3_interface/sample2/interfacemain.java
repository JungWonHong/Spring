package ex8_15_3_interface.sample2;

public class interfacemain {

	public static void main(String[] args) {
		A a = new A();
		
		//매개변수를 통해서 인터페이스 I를 구현한 클래스(B와 C)의 인스턴스를 제공 받아야 합니다.
		//동적 바인딩
		//다형성
		a.methodA(new B()); // I i = new B()
		a.methodA(new C()); // I i = new C()
	}

}
