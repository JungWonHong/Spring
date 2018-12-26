package ex10_6.math;

//ex10_6.geometry.polygon 패키지의 모든 클래스와 인터페이스를 import
import ex10_6.geometry.polygon.*;

public class PackageExample6 {

	public static void main(String[] args) {
		Square obj1 = new Square(7);
		Rectangle obj2 = new Rectangle(5, 10);

		if (obj1.getArea() > obj2.getArea())
			System.out.println("정사각형의 면적이 더 넓습니다.");
		else
			System.out.println("정사각형의 면적은 직사각형의 면적보다 작거나 같습니다.");

	}

}
