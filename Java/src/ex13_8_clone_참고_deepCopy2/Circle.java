package ex13_8_clone_참고_deepCopy2;

public class Circle implements Cloneable {
	Point p;
	double r;

	Circle(Point p, double r) {
		this.p = p;
		this.r = r;
	}

	public Circle clone() { // 깊은 복사
		Object obj = null;
		try {
			obj = super.clone(); // 조상의 clone()을 호출
		} catch (CloneNotSupportedException e) {
		}
		Circle c = (Circle)obj;
		c.p = new Point(this.p.x, this.p.y); //참조하는 객체도 복사
		return (Circle) obj;
	}

	public String toString() {
		return "[p=" + p + ", r=" + r + "]";
	}
}
