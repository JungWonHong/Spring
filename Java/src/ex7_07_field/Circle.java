package ex7_07_field;

public class Circle {
	double radius;

	Circle(double radius) {
		this.radius = radius;
	}

	double getArea() {
		double area;
		area = radius * radius * 3.14;
		return area;
	}

	double getArea2(double radius) {
		return 3.14 * radius * radius;
	}

	double getArea3(Circle c) {
		return 3.14 * Math.pow(c.radius, 2);
	}
}
