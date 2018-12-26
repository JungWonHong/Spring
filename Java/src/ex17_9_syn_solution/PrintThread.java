//계좌 잔액 합계를 출력하는 스레드 클래스
package ex17_9_syn_solution;

public class PrintThread extends Thread {
	SharedArea sharedArea;

	PrintThread(SharedArea area) { // 생성자
		sharedArea = area;
	}

	public void run() {
		for (int cnt = 0; cnt < 3; cnt++) {
			/*
			 * synchronized 키워드를 사용해서 블록으로 묶은 부분을 동기화 블럭이라고 합니다.
			 */
			// 동기화 시작
			synchronized (sharedArea) {
				int sum = sharedArea.account1.balance + sharedArea.account2.balance;
				System.out.println("계좌 잔액 합계: " + sum);
			}
			// 동기화 끝
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
