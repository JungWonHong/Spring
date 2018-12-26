package ex10_7_private;

//다른 클래스의 private 메소드를 호출하는 잘못된 프로그램.
public class AccessControlExample1 {

	public static void main(String[] args) {
		Fraction obj = new Fraction(100, 3);
		System.out.println("100/3 = " + obj.getDouble());
		System.out.println("(int)100/3 = " + obj.getInt());
	}

}
