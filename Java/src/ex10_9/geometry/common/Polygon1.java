//protected ������Ҹ� �����ϴ� Ŭ������ ��
package ex10_9.geometry.common;

public class Polygon1 {
	protected int x[]; // �������� X��ǥ
	protected int y[]; // �������� Y��ǥ

	protected Polygon1(int vertexNum) {// ������
		x = new int[vertexNum];
		y = new int[vertexNum];
	}

	// �������� ��ǥ�� �����Ѵ�
	protected void setPoint(int index, int x, int y) {
		this.x[index] = x;
		this.y[index] = y;
	}
}
