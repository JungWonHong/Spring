package ex17_14_Thread_state_2;

public class MonitorThread extends Thread {
	Thread thread1;
	Thread thread2;

	MonitorThread(Thread thread1, Thread thread2) {
		this.thread1 = thread1;
		this.thread2 = thread2;
	}

	// ����͸� ��� ������(thread)�� ���¸� 2�ʸ��� �ѹ��� ����մϴ�.
	public void run() {
		while (true) {
			// thread.getState() : �������� ���¸� ���ɴϴ�.
			Thread.State state1 = thread1.getState();
			System.out.println(thread1.getName() + "�� ����: " + state1);
			Thread.State state2 = thread2.getState();
			System.out.println(thread2.getName() + "�� ����: " + state2);

			System.out.println("=========================================");
			// �������� ���°� ���� ������ ��� �ݺ����� ����ϴ�.
			if (state1 == Thread.State.TERMINATED || state2 == Thread.State.TERMINATED) {
				break;
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
