package ex10_5.geometry;

public class Circle {
	public int radius;

	public Circle(int radius) {
		this.radius = radius;
	}

	public double getArea() {
		return radius * radius * 3.14;
	}

}
