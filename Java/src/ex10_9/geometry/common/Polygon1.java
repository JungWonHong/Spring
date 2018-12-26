//protected 구성요소를 포함하는 클래스의 예
package ex10_9.geometry.common;

public class Polygon1 {
	protected int x[]; // 꼭지점의 X좌표
	protected int y[]; // 꼭지점의 Y좌표

	protected Polygon1(int vertexNum) {// 생성자
		x = new int[vertexNum];
		y = new int[vertexNum];
	}

	// 꼭지점의 좌표를 설정한다
	protected void setPoint(int index, int x, int y) {
		this.x[index] = x;
		this.y[index] = y;
	}
}
