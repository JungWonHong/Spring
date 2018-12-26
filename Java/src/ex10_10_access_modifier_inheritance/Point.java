//protected 메소드를 갖는 Point 클래스
package ex10_10_access_modifier_inheritance;

class Point {
	int x, y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	protected int getX() {
		return x;
	}

	protected int getY() {
		return y;
	}
}
