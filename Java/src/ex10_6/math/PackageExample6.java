package ex10_6.math;

//ex10_6.geometry.polygon ��Ű���� ��� Ŭ������ �������̽��� import
import ex10_6.geometry.polygon.*;

public class PackageExample6 {

	public static void main(String[] args) {
		Square obj1 = new Square(7);
		Rectangle obj2 = new Rectangle(5, 10);

		if (obj1.getArea() > obj2.getArea())
			System.out.println("���簢���� ������ �� �н��ϴ�.");
		else
			System.out.println("���簢���� ������ ���簢���� �������� �۰ų� �����ϴ�.");

	}

}
