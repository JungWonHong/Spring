package ex13_7;

public class Circle2 {
	int radius; // ������

	Circle2(int radius) {
		this.radius = radius;
	}

	//obj�� ObjectŸ���̹Ƿ� radius�� �����ϱ� ���ؼ� Circle2Ÿ������ ����ȯ�� �ʿ�
	public boolean equals(Object obj) {
		//obj�� Circle2�� ����ȯ �������� üũ
		if (obj != null && obj instanceof Circle2){
			return radius == ((Circle2) obj).radius; //radius���� ������ true �ٸ��� false���� ����
			//Circle2 circle = (Circle2)obj;
			//return radius == circle.radius;
		}
		else
			return false;
	}
}
