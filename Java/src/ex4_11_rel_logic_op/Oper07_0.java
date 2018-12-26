package ex4_11_rel_logic_op;

public class Oper07_0 {

	public static void main(String[] args) {
		boolean a = false, b = false;
		a = 4 > 3;
		b = 5 > 7;
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		
		if(a&&b)
			System.out.println("a&&b가 참");
		
		if(a||b)
			System.out.println("a||b가 참");
	}

}
