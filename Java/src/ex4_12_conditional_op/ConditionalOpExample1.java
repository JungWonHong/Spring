package ex4_12_conditional_op;

//조건연산자 실습
public class ConditionalOpExample1 {

	public static void main(String[] args) {
		int a = 20, b = 30, max;

		max = a > b ? a : b;
		System.out.println("최대값 = " + max);
	}

}
