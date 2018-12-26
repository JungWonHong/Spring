//네 개의 스레드로 실행되는 멀티스레드 프로그램
//main, thread1, thread2, thread3
package ex17_3_Thread_four;

public class MultithreadExample {

	public static void main(String[] args) {
		//세 개의 스레드를 생성해서 시작합니다.
		Thread thread1 = new DigitThread();
		Thread thread2 = new DigitThread();
		Thread thread3 = new AlphabetThread();
		thread1.start();
		thread2.start();
		thread3.start();
		/*
		 * Thread t = Thread.currenThread();
		 * Thread의 정적 메소드인 currentThread()로 코드를 실행하는 
		 * 현재 스레드의 참조를 얻을 수 있습니다.
		 * setName()메소드로 스레드의 이름을 변경할 수 있고 
		 * getName()메소드로 스레드의 이름을 가져올 수 있습니다.
		 * 예) t.setName("스레드이름");
		 * 예) t.getName();
		 */
		System.out.println("스레드 이름 : " + Thread.currentThread().getName());
		
	}

}
