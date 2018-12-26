package ex4_14;

public class CompAssignmentExample1 {

	public static void main(String[] args) {

		int res = 10, a = 2;
		res += a; // res = res + a;
		System.out.println(res);

		res -= a; // res = res - a;
		System.out.println(res);

		res *= a; // res = res * a;
		System.out.println(res);

		res /= a; // res = res / a;
		System.out.println(res);

		int num = 29;
		num -= 2 + 3 * 4; // num = num -(2 + 3 * 4) 와 똑같은 효과
		System.out.println(num);
	}

}
