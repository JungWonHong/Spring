/*
 * CalcThread�� ���� ���� ���� ���� ������ ���⵵ ����
 * PrintThread�� ���� ������ �����͸� �о� ���� �빮��
 * result �ʵ尡 ������ �ִ� �⺻�� 0.0�� ��µ� ���Դϴ�.
 * �ذ�å?
 */
package ex17_6_SharedArea_solution;

public class MultithreadExample4 {

	public static void main(String[] args) {
		CalcThread thread1 = new CalcThread();
		PrintThread thread2 = new PrintThread();
		
		
		//���� ���� ��ü�� �����ؼ� �� ��ü�� �������� �� �������� �ʵ忡 �����մϴ�.
		SharedArea obj = new SharedArea();
		thread1.sharedArea = obj;
		thread2.sharedArea = obj;
		
		thread1.start();
		thread2.start();
	}

}
