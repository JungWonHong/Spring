//알파벳을 출력하는 스레드 클래스
package ex17_3_Thread_four;

public class AlphabetThread extends Thread {
	public void run() {
		for (char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.print(ch);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		Thread.currentThread().setName("알파벳");
		System.out.println("스레드 이름 : " + Thread.currentThread().getName());
	}

}
