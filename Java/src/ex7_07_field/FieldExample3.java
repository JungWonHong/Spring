package ex7_07_field;

import java.util.Scanner;

public class FieldExample3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("�������� �Է��ϼ���>");
		//double input = sc.nextDouble();

		Circle c = new Circle(sc.nextDouble());
		System.out.println("���� ������ = " + c.radius);
		System.out.println("���� ���� = " + c.getArea());
		
		sc.close();
	}

}
