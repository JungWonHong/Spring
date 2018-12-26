package ex10_6.geometry.polygon;

public class Rectangle {
	public int width, height;

	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public double getArea() {
		return width * height;
	}

}
