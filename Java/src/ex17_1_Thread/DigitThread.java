/*
 * -java.lang.Thread 클래스와 이 클래스의 서브 클래스를
 *  Thread(스레드) 클래스라고 합니다.
 * -스레드가 할 일을 run 메소드 안에 작성해야 합니다.
 * -public void run()의 형식으로 작성합니다.
 */
package ex17_1_Thread;

public class DigitThread extends Thread {
	
	// 오버라이딩 - 오버라이딩 안해도 에러는 없다
	// start 메소드에 의해 실행됩니다.
	public void run() {
		for (int cnt = 0; cnt < 10; cnt++)
			System.out.print(cnt);
	}
}
