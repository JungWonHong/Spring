//unchecked exception�� ������ �޼ҵ�
//throws ���� ��� try~catch ������ ���� ó�� ����
//������ 0���� ������ ���� �����Ǿ� ArithmeticException �߻��մϴ�.
package ex12_1_Exception;

public class ExceptionExample4 {

	public static void main(String[] args) {
		try{
			int result = divide(3,0);
			System.out.println(result);
		} catch(ArithmeticException e){
			System.err.println("���� �߻�");
		}

	}

	static int divide(int a, int b) {
		int result = a / b;
		return result;
	}
}
