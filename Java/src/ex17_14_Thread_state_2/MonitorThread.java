package ex17_14_Thread_state_2;

public class MonitorThread extends Thread {
	Thread thread1;
	Thread thread2;

	MonitorThread(Thread thread1, Thread thread2) {
		this.thread1 = thread1;
		this.thread2 = thread2;
	}

	// 모니터링 대상 스레드(thread)의 상태를 2초마다 한번씩 출력합니다.
	public void run() {
		while (true) {
			// thread.getState() : 쓰레드의 상태를 얻어옵니다.
			Thread.State state1 = thread1.getState();
			System.out.println(thread1.getName() + "의 상태: " + state1);
			Thread.State state2 = thread2.getState();
			System.out.println(thread2.getName() + "의 상태: " + state2);

			System.out.println("=========================================");
			// 쓰레드의 상태가 종료 상태일 경우 반복문을 벗어납니다.
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
