package ex7_13_static_field1;

public class StaticFieldExample1 {

	public static void main(String[] args) {
		Accumulator obj1 = new Accumulator();
		Accumulator obj2 = new Accumulator();
		obj1.accumulate(10);
		obj2.accumulate(20);
		System.out.println("obj1.total = " + obj1.total);
		System.out.println("obj1.grandTotal = " + obj1.grandTotal);
		// static 변수라서 객체생성없이 사용하라는 권고문.
		// The static field Accumulator.grandTotal should be accessed in a static way
		System.out.println("obj2.total = " + obj2.total);
		System.out.println("obj2.grandTotal = " + obj2.grandTotal);
		System.out.println("정적 변수 grandTotal = " + Accumulator.grandTotal);

	}

}
