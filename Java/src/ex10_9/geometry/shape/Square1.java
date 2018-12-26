//���� Ŭ������ protected ������Ҹ� ����ϴ� ���� Ŭ����
package ex10_9.geometry.shape;

public class Square1 extends ex10_9.geometry.common.Polygon1 {
	public Square1(int x, int y, int sideLength) {
		super(4);			//���� Ŭ������ protected ������ ȣ��
		setPoint(0, x, y);	//���� Ŭ������ protected �޼ҵ� ȣ��
		setPoint(1, x + sideLength, y);
		setPoint(2, x + sideLength, y + sideLength);
		setPoint(3, x, y + sideLength);
	}

	/*
	 * 	.(0,0)		.(10,0)
	 * 	  x,y		  x+10, y	//sideLength = 10�� ���
	 * 	  index=0	  index=1
	 * 
	 * 	.(0,10)		.(10,10)
	 * 	  x,y+10	  x+10,y+10
	 * 	  index=3	  index=2
	 */
	
	public int getX(int index) {
		return x[index];			//���� Ŭ������ protected �ʵ� ���
	}

	public int getY(int index) {
		return y[index];			//���� Ŭ������ protected �ʵ� ���
	}
}
