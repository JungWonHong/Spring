package ex9_02_null;
//obj������ null�̶�� �������� �ֱ� ������ ������ ������ ������
//����� ���� �߻�(��Ÿ�� �����߻�) - �ƹ� �����͵� ����Ű�� �ʱ⶧��
public class RefTypeExample4 {

	public static void main(String[] args) {
		Point obj = null;
		//obj = new Point(10,20);
		System.out.println(obj.x);
		System.out.println(obj.y);
		//java.lang.NullPointerException
	}

}
