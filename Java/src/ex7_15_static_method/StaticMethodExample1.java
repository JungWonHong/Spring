package ex7_15_static_method;
// ���� �޼��� ȣ���ϴ� ���α׷�
public class StaticMethodExample1 {

	public static void main(String[] args) {
		Accumulator obj1 = new Accumulator();
		Accumulator obj2 = new Accumulator();
		obj1.accumulate(10);
		obj2.accumulate(20);
		
		// ���� �޼��� ȣ�⹮
		int grandTotal = Accumulator.getGrandTotal();
		System.out.println("obj1.total = " + obj1.total);
		System.out.println("obj2.total = " + obj2.total);
		System.out.println("�Ѱ� = " + grandTotal);
	}

}
