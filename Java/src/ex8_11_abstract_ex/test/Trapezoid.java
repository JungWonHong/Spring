package ex8_11_abstract_ex.test;

public class Trapezoid {
	double height;
	double top;
	double bottom;

	Trapezoid(double top, double bottom, double height) {
		this.top = top;
		this.bottom = bottom;
		this.height = height;
	}

	double getArea() {
		return ((top + bottom) * height) / 2;
	}
}
