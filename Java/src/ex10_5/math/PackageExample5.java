package ex10_5.math;

import ex10_5.geometry.*;
import ex10_5.geometry.polygon.*;

public class PackageExample5 {

	public static void main(String[] args) {
		Circle obj1 = new Circle(5);
		Rectangle obj2 = new Rectangle(8, 9);

		if (obj1.getArea() > obj2.getArea())
			System.out.println("원의 면적이 더 넓습니다.");
		else
			System.out.println("원의 면적은 직사각형의 면적보다 작거나 같습니다.");

	}

}
