package ex7_08_private_field;
//private 필드를 갖는 클래스의 예
public class Circle {
	// 접근 제어자 private은 클래스 내부에서 사용가능하다. - 정보의 은닉
	private double radius;

	Circle(double radius) {
		this.radius = radius;
	}

	double getArea() {
		double area;
		area = radius * radius * 3.14;
		return area;
	}

}
