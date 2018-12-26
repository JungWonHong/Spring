package ex10_7_private;

public class AccessControlExample2 {

	public static void main(String[] args) {
		Fraction2 obj = new Fraction2(100, 3);
		System.out.println("100/3 = " + obj.getDouble());
		System.out.println("(int)100/3 = " + obj.getInt());
	}

}
