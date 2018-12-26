package ex17_2_Thread_sleep;

public class DigitThread extends Thread {
	public void run() {
		for (int cnt = 0; cnt < 10; cnt++) {
			System.out.print(cnt);
			try {
				Thread.sleep(1000); // 1초
			} catch (InterruptedException e) {
				// sleep메소드가 발생시키는 InterruptedException 처리하는 문장
				System.out.println(e.getMessage());
			}
		}
	}

}
