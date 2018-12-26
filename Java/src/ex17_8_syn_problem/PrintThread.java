//계좌 잔액 합계를 출력하는 스레드 클래스
package ex17_8_syn_problem;

public class PrintThread extends Thread {
	SharedArea sharedArea;

	PrintThread(SharedArea area) { // 생성자
		sharedArea = area;
	}

	public void run() {
		for (int cnt = 0; cnt < 3; cnt++) {
			int sum = sharedArea.account1.balance + sharedArea.account2.balance;
			System.out.println("계좌 잔액 합계: " + sum);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
