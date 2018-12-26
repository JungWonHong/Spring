package ex6_3_method;

public class Method_recursive_call {

	static int factorial(int n) {
		int result = 0;
		if (n == 1)
			result = 1;
		else
			result = n * factorial(n - 1); // f(n) = n * f(n-1)

		return result;
	}

	public static void main(String[] args) {
		int result = factorial(4);
		System.out.println(result);
	}

}
