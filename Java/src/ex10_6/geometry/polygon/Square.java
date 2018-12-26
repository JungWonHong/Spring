package ex10_6.geometry.polygon;

public class Square {
	public int sideLength;

	public Square(int sideLength) {
		this.sideLength = sideLength;
	}

	public double getArea() {
		return sideLength * sideLength;
	}

}
