//���ڸ� ����ϴ� ������ Ŭ����
package ex17_3_Thread_four;

public class DigitThread extends Thread {
	public void run() {
		for (int cnt = 0; cnt < 10; cnt++) {
			System.out.print(cnt);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		Thread.currentThread().setName("digit");
		System.out.println("������ �̸� : " + Thread.currentThread().getName());
	}

}
