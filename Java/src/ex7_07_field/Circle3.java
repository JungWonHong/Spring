package ex7_07_field;

public class Circle3 {
	double radius;
	final double PI = 3.14; //1.�ۿ��� �ʱ�ȭ���൵�ǰ�

	Circle3(double radius) {
		this.radius = radius;
		//PI = 3.14; //2.������ �ȿ��� �ʱ�ȭ���൵�ȴ�.
	}

	double getArea() {
		double area;
		area = radius * radius * PI;
		return area;
	}

	double getArea2(double radius) {
		return PI * radius * radius;
	}

	double getArea3(Circle3 c) {
		return PI * Math.pow(c.radius, 2);
	}
}
