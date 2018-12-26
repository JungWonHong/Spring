package ex4_08_arithmetic_op;

public class Oper01 {

	public static void main(String[] args) {
		
		int a = 10, b = 4, c;
		c = a + b;		// c=14
		System.out.println(a + "+" + b + "=" + c);
		
		c = a - b;		// c=6
		System.out.println(a + "-" + b + "=" + c);
		
		c = a * b;		// c=40
		System.out.println(a + "*" + b + "=" + c);
		
		c = a / b;		// c=2
		System.out.println(a + "/" + b + "=" + c);
		
		c = a % b;		// c=2 (나머지)
		System.out.println(a + "%" + b + "=" + c);

		// a/b = 2.5를 만들어 봅시다.
		System.out.println("-----------------------------------------------");
		System.out.println("a/b = " + a/b);
		System.out.println("(double)(a/b) = " + (double)(a/b));
		System.out.println("(double)a = " + (double)a);
		System.out.println("(double)a/b = " + (double)a/b);
		System.out.println("a/(double)b = " + a/(double)b);
		System.out.println("(double)a/(double)b = " + (double)a/(double)b);
		System.out.println(a + "/" + b + "=" + (double)a/b);
		
		System.out.println("-----------------------------------------------");
		double c2;
		c2 = (double)a / b;
		System.out.println(a + "/" + b + "=" + c2);
	}

}
