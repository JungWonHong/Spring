package ex8_11_abstract_ex.test;

public class Circle extends Area {
	double radius;

	Circle(double radius) {
		this.radius = radius;
	}

	double getArea() {
		return radius * radius * 3.14;
	}

}
