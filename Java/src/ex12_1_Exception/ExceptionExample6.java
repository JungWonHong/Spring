//getMessage �޼ҵ��� ��� ���� �����ִ� ���α׷�
package ex12_1_Exception;

public class ExceptionExample6 {

	public static void main(String[] args) {
		int num1 = 2, num2 = 3;
		try {
			int result = num1 - num2;
			// Exception ��ü�� �����մϴ�.
			if (result < 0)
				throw new Exception("�߸��� ����Դϴ�.");
			System.out.println(result);
		} catch (Exception e) {
			// Exception ��ü�� �ִ� ���� �޽����� �����ɴϴ�.
			String str = e.getMessage();
			System.err.println(str);
		}
	}
}
