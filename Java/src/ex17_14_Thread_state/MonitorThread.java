package ex17_14_Thread_state;

public class MonitorThread extends Thread {
	Thread thread;

	MonitorThread(Thread thread) {
		this.thread = thread;
	}

	// ����͸� ��� ������(thread)�� ���¸� 2�ʸ��� �ѹ��� ����մϴ�.
	public void run() {
		while (true) {
			// thread.getState() : �������� ���¸� ���ɴϴ�.
			Thread.State state = thread.getState();
			System.out.println(" �������� ����: " + state);

			// �������� ���°� ���� ������ ��� �ݺ����� ����ϴ�.
			if (state == Thread.State.TERMINATED) {
				break;
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
