package ex9_2_null;

//���۷��� ������ null �������� ���ؼ� ó���ϴ� ���α׷�
public class RefTypeExample5 {

	public static void main(String[] args) {
		Point obj = null;
		if (obj == null) { // null ���� �񱳽�
			System.out.println("obj ������ ����Ű�� ��ü�� �����ϴ�.");
			return;
		} else {
			System.out.println("obj ������ ����Ű�� ��ü�� �ֽ��ϴ�.");
		}

	}

}
