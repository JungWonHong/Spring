//������� �ȳ��Ϳ� - ������ �� ���� ����� �޶��
package ex17_4_Runnable_Interface;

public class ThreadLife implements Runnable {
	public void run() {
		for (int i = 1; i < 3; i++) {
			// ���� ���� ���� thread�� �̸��� ���� ���
			System.out.println("���� ���� ���� �������� �̸���" + 
					Thread.currentThread().getName() + "�̰�," + 
					"\t number = " + i);
		}
	}

}
