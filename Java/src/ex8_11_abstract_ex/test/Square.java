package ex8_11_abstract_ex.test;

public class Square extends Area {
	double width;
	double height;

	Square(double width, double height) {
		this.width = width;
		this.height = height;
	}

	double getArea() {
		return width * height;
	}

}
