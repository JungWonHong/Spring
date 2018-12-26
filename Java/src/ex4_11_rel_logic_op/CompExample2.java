package ex4_11_rel_logic_op;

public class CompExample2 {

	public static void main(String[] args) {
		int a = 10, b = 4;
		boolean test; //true 또는 false 값을 갖는다.
		
		test = a > b;
		System.out.println(a + ">" + b + "=" + test);
		
		test = a < b;
		System.out.println(a + "<" + b + "=" + test);
		
		System.out.println(a + b > a - b);
	}

}
