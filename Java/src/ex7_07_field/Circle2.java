package ex7_07_field;
//�ʵ�, �޼ҵ�, �������� ��ġ�� �ٲ� ��������� �����ִ� Ŭ����
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
