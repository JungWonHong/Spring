//파이를 출력하는 스레드 클래스
package ex17_14_Thread_state_2;

public class PrintThread extends Thread {
	SharedArea sharedArea;

	public void run() {
		if (sharedArea.isReady != true) { // 피아 계산을 하는 중인 경우
			synchronized (sharedArea) {
				try {
					sharedArea.wait(); // 다른 스레드로 부터 신호를 기다립니다.
				} catch (InterruptedException e) {// wait 메소드가 발생하는 익셉션 처리
					System.out.println(e.getMessage());
				}
			}
		}
		// 공유 영역의 데이터를 출력
		System.out.println(sharedArea.result);

	}
}
