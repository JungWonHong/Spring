//���� �ذ�� - public �̳� protected�� ���δ�.
package ex10_10_access_modifier_inheritance;

class Point3D2 extends Point {
	int z;

	Point3D2(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}
	
	public int getX() { // �������� ���� ��Ģ�� ���� �θ��� ��������� ũ�ų� ����������Ѵ�.
		return x;
	}

	protected int getY() { // �������� ���� ��Ģ�� ���� �θ��� ��������� ũ�ų� ����������Ѵ�.
		return y;
	}
	
	int getZ() {
		return z;
	}
}
