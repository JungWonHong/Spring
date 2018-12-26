//���̸� ����ϴ� ������ Ŭ����
package ex17_14_Thread_state_2;

public class PrintThread extends Thread {
	SharedArea sharedArea;

	public void run() {
		if (sharedArea.isReady != true) { // �Ǿ� ����� �ϴ� ���� ���
			synchronized (sharedArea) {
				try {
					sharedArea.wait(); // �ٸ� ������� ���� ��ȣ�� ��ٸ��ϴ�.
				} catch (InterruptedException e) {// wait �޼ҵ尡 �߻��ϴ� �ͼ��� ó��
					System.out.println(e.getMessage());
				}
			}
		}
		// ���� ������ �����͸� ���
		System.out.println(sharedArea.result);

	}
}
