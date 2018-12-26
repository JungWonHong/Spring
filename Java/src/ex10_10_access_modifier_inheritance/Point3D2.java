//에러 해결법 - public 이나 protected를 붙인다.
package ex10_10_access_modifier_inheritance;

class Point3D2 extends Point {
	int z;

	Point3D2(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}
	
	public int getX() { // 접근제어 범위 규칙에 따라 부모의 접근제어보다 크거나 같게해줘야한다.
		return x;
	}

	protected int getY() { // 접근제어 범위 규칙에 따라 부모의 접근제어보다 크거나 같게해줘야한다.
		return y;
	}
	
	int getZ() {
		return z;
	}
}
