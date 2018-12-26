//���̸� ����ϴ� ������ Ŭ����
package ex17_13_notifyall_wait;

public class PrintThread extends Thread {
	SharedArea sharedArea;

	public void run() {
		if(sharedArea.isReady != true){ //�Ǿ� ����� �ϴ� ���� ���
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
