//���̸� ����ϴ� ������ Ŭ����
package ex17_6_SharedArea;

public class PrintThread extends Thread {
	SharedArea sharedArea;

	public void run() {
		// ���� ������ �����͸� ���
		System.out.println("���� ������ ������ = " + sharedArea.result);
	}
}
