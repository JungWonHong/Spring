package ex13_8_clone_����_deepCopy1;

public class Circle implements Cloneable {
	Point p;
	double r;

	Circle(Point p, double r) {
		this.p = p;
		this.r = r;
	}

	public Circle clone() { // ���� ����
		Object obj = null;
		try {
			obj = super.clone(); // ������ clone()�� ȣ��
		} catch (CloneNotSupportedException e) {
		}
		return (Circle) obj;
	}

	public String toString() {
		return "[p=" + p + ", r=" + r + "]";
	}
}
