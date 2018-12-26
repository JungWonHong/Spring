//파이를 출력하는 스레드 클래스
package ex17_6_SharedArea_solution;

public class PrintThread extends Thread {
	SharedArea sharedArea;

	public void run() {
		while (sharedArea.isReady != true) {
			System.out.println("Calc실행중~");
		}

		// 공유 영역의 데이터를 출력
		System.out.println("공유 영역의 데이터 = " + sharedArea.result);

	}
}
