//���̸� ����ϴ� ������ Ŭ����
package ex17_13_notifyall_wait;

public class LuxuryPrintThread extends Thread {
	SharedArea sharedArea;

	public void run() {
		if (sharedArea.isReady != true) { // �Ǿ� ����� �ϴ� ���� ���
			synchronized (sharedArea) {
				try {
					sharedArea.wait(); // ��ȣ�� ��ٸ��ϴ�.
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		// ���� ������ �����͸� ���
		System.out.println("*** �� = " + sharedArea.result + " ***");
	}
}
