package ex7_07_field;
//필드, 메소드, 생성자의 위치는 바뀌어도 상관없음을 보여주는 클래스
public class Circle2 {

	double getArea() {
		double area;
		area = radius * radius * 3.14;
		return area;
	}
	
	Circle2(double radius) {
		this.radius = radius;
	}

	double getArea2(double radius) {
		return 3.14 * radius * radius;
	}

	double getArea3(Circle2 c) {
		return 3.14 * Math.pow(c.radius, 2);
	}
	
	double radius;
}
