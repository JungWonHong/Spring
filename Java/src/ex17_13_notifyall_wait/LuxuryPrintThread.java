//파이를 출력하는 스레드 클래스
package ex17_13_notifyall_wait;

public class LuxuryPrintThread extends Thread {
	SharedArea sharedArea;

	public void run() {
		if (sharedArea.isReady != true) { // 피아 계산을 하는 중인 경우
			synchronized (sharedArea) {
				try {
					sharedArea.wait(); // 신호를 기다립니다.
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		// 공유 영역의 데이터를 출력
		System.out.println("*** π = " + sharedArea.result + " ***");
	}
}
