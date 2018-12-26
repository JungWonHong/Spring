//���̸� ����ϴ� ������ Ŭ����
package ex17_12_notify_wait;

public class PrintThread extends Thread {
	SharedArea sharedArea;

	public void run() {
		if(sharedArea.isReady != true){ //�Ǿ� ����� �ϴ� ���� ���
			/* ������ ��� - ���� ����� ������ ���� ��� üũ�ؾ� �߽��ϴ�.
			while (sharedArea.isReady != true) {
				System.out.println("Calc������~");
			}
			 */
			try {
				synchronized (sharedArea) {
					sharedArea.wait(); //�ٸ� ������� ���� ��ȣ�� ��ٸ��ϴ�.
									   //������ ����� ������ �ٸ� �����忡�� ��ȣ�� �����ϴ�.
				}
			} catch (InterruptedException e) {// wait �޼ҵ尡 �߻��ϴ� �ͼ��� ó��
				System.out.println(e.getMessage());
			}
		}
		// ���� ������ �����͸� ���
		System.out.println("���� ������ ������ = " + sharedArea.result);

	}
}
