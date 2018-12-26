package ex8_15_3_interface.sample1;

public class B {
	B() {
	}

	// 이 부분이 변경되면 클래스 A의 methodA() 몸체도 변경되어야 합니다.
	public void methodB() {
		System.out.println("methodB");
	}
}
