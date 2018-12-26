package ex8_15_3_interface.sample1;

public class A {
	A() {
	}

	public void methodA(B b) {
		b.methodB();
	} //A는 B에 의존한다. (직접적인 관계)
}
