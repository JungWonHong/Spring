package ex17_2_Thread_sleep;

public class DigitThread extends Thread {
	public void run() {
		for (int cnt = 0; cnt < 10; cnt++) {
			System.out.print(cnt);
			try {
				Thread.sleep(1000); // 1��
			} catch (InterruptedException e) {
				// sleep�޼ҵ尡 �߻���Ű�� InterruptedException ó���ϴ� ����
				System.out.println(e.getMessage());
			}
		}
	}

}