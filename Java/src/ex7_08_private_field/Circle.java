package ex7_08_private_field;
//private �ʵ带 ���� Ŭ������ ��
public class Circle {
	// ���� ������ private�� Ŭ���� ���ο��� ��밡���ϴ�. - ������ ����
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
