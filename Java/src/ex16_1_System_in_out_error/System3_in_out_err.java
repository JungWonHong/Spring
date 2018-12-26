//ǥ�� ��°� ǥ�� ���� ����� ��� �ϴ� ���α׷�
//err�ʵ� ����ϴ� ��
/*
 * err : ǥ�� ���� ��� �ʵ� - ���� �޽����� ����ͷ� ������ ���
 * out�ʵ�� �Ϲ� ������ ��� �뵵�� err�ʵ�� �����޽��� ��� �뵵�� ���
 * �� �ʵ带 ����ؼ� ����� �ڼ��� ���ɴϴ�.
 */
package ex16_1_System_in_out_error;

public class System3_in_out_err {

	public static void main(String[] args) {
		int arr1[] = { 7, 82, 99, 100, -27, 0, 42, -35, 60, 72 };
		int arr2[] = { 7, 0, 3, 0, -1, 2, 11, 5, 0, 9 };
		for (int cnt = 0; cnt < arr1.length; cnt++) {
			try {
				int result = arr1[cnt] / arr2[cnt];
				// �������� �������� ����� out �ʵ带 ���� ����մϴ�.
				System.out.printf("%d / %d = %d %n", arr1[cnt], arr2[cnt], result);
			} catch (java.lang.ArithmeticException e) {
				// ������ �� �߻��� ������ ���� �޽����� err�ʵ带 ���� ����մϴ�.
				System.err.println("�߸��� �����Դϴ�. (index=" + cnt + ")");
			}
		}
		System.out.println("����");
	}

}
