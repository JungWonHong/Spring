package ex7_07_field;

import java.util.Scanner;

public class FieldExample3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("반지름을 입력하세요>");
		//double input = sc.nextDouble();

		Circle c = new Circle(sc.nextDouble());
		System.out.println("원의 반지름 = " + c.radius);
		System.out.println("원의 넓이 = " + c.getArea());
		
		sc.close();
	}

}
