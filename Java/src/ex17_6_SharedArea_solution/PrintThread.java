//���̸� ����ϴ� ������ Ŭ����
package ex17_6_SharedArea_solution;

public class PrintThread extends Thread {
	SharedArea sharedArea;

	public void run() {
		while (sharedArea.isReady != true) {
			System.out.println("Calc������~");
		}

		// ���� ������ �����͸� ���
		System.out.println("���� ������ ������ = " + sharedArea.result);

	}
}
