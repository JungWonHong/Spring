package ex10_1_package;

public class Circle {
	int radius;

	Circle(int radius) {
		this.radius = radius;
	}

	double getArea() {
		return radius * radius * 3.14;
	}
}