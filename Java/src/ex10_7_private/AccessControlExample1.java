package ex10_7_private;

//�ٸ� Ŭ������ private �޼ҵ带 ȣ���ϴ� �߸��� ���α׷�.
public class AccessControlExample1 {

	public static void main(String[] args) {
		Fraction obj = new Fraction(100, 3);
		System.out.println("100/3 = " + obj.getDouble());
		System.out.println("(int)100/3 = " + obj.getInt());
	}

}
