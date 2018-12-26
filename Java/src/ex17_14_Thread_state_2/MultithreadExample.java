//notify메소드와 wait메소드 사용 예
/*
 * - 스레드 사이에 신호를 직접 주고 받을 수 있습니다.
 *   동기화된 스레드는 동기화 블록에서 다른 스레드에게 제어권을 넘기지 못합니다.
 *   이와 같이 동기화된 블록에서 스레드간의 통신(제어권을 넘김)하기 위해서
 *   wait(), notify(), notifyAll() 메소드를 사용해야 합니다.
 *   이 메소드를 사용할 때는 synchronized 블록에서만 의미가 있습니다.
 */
package ex17_14_Thread_state_2;

public class MultithreadExample {

	public static void main(String[] args) {
		CalcThread thread1 = new CalcThread();
		PrintThread thread2 = new PrintThread();
		thread1.setName("CalcThread");
		thread2.setName("PrintThread");
		//모니터링 스레드 생성
		//CalcThread 모니터링, PrintThread 모니터링
		MonitorThread thread3 = new MonitorThread(thread1, thread2);
		
		SharedArea obj = new SharedArea();
		thread1.sharedArea = obj;
		thread2.sharedArea = obj;
		
		thread1.start();
		thread2.start();
		thread3.start();
	}

}
