package ex17_5.daemon_thread;

public class Threadautosave implements Runnable {
	static boolean autoSave = false;

	public void run() {
		while (true) {
			try {
				Thread.sleep(3 * 1000); // 3�ʸ���
			} catch (InterruptedException e) {
			}

			// autoSave�� ���� true�̸� autoSave()�� ȣ���Ѵ�.
			if (autoSave) {
				autoSave();
			}
		}
	}

	public void autoSave() {
		System.out.println("�۾������� �ڵ�����Ǿ����ϴ�.");
	}

}
