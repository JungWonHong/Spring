package ex6_2_method_intro;

public class MethodExample2_1 {

	static int add(int num1, int num2) {
		int sum;
		sum = num1 + num2;
		return sum;
	}

	public static void main(String[] args) {
		int result;
		result = add(3, 4);
		System.out.println(result);
	}

}
