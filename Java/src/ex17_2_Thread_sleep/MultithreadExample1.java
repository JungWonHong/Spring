//���ĺ��� ���ڸ� ���ÿ� ����ϴ� ��Ƽ������ ���α׷�
/*
 * JVM�� �����忡 �Ҵ��ϴ� �ð��� ���� ������ �ϵ������ �����̳� �ý��� ȯ�濡
 * ���� �޶� ���� ����� �Ź� �ٸ� ����� ���� �� �ֽ��ϴ�.
 */
package ex17_2_Thread_sleep;

public class MultithreadExample1 {

	public static void main(String[] args) {
		Thread thread = new DigitThread(); // �����带 ����
		thread.start();

		for (char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.print(ch);
			try {
				Thread.sleep(1000);
				// sleep �޼ҵ� : ���� �ð��� ����Ǳ⸦ ��ٸ��� �޼ҵ�.
				// public static void sleep(long millis) throws InterruptedException
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
