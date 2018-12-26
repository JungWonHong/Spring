package ex7_07_field;

public class Circle3 {
	double radius;
	final double PI = 3.14; //1.밖에서 초기화해줘도되고

	Circle3(double radius) {
		this.radius = radius;
		//PI = 3.14; //2.생성자 안에서 초기화해줘도된다.
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
