//critical section의 동기화
/*
 * - 멀티스레드 프로그램에서 스레드들이 번갈아 실행되는 스케쥴은 자바 가상 기계에 의해
 *   임의로 정해지는데 이로 인해 적절치 못한 순간에 다른 스레드로 제어가 넘어가서
 *   예기치 못한 문제가 발생할 수 있습니다.
 *   이런 문제는 주로 공유 데이터를 사용하는 부분에서 일어나는데 이런 부분을
 *   critical section(임계 영역)이라고 합니다.
 *   즉, 멀티 스레드 프로그램에서 단 하나으 ㅣ스레드만 실행할 수 있는 코드 영역을
 *   임계 영역이라고 합니다.
 *   이 문제를 일으키지 않도록 하려면 그 부분이 실행되는 동안 다른 스레드가 공유 데이터를
 *   사용할 수 없도록 만들어야 하는데 그렇게 하는 것을 
 *   critical section의 동기화 라고 합니다.
 *   
 * - 임계 영역의 동기화 방법
 * 		1. 동기화 블럭 : 일부분만 임계 영역으로 만들 경우
 * 		  메서드 선언{
 * 			synchronized (동기화할 객체) {
 * 				임계 영역 코딩 // 단 하나의 스레드만 실행됩니다.
 * 			}
 * 		 }
 * 
 *   	2. 동기화 메소드 : 메소드 전체 내용이 임계 영역으로 만들 경우
 *   		synchronized 메소드 선언{
 *   			임계 영역 코딩 // 단 하나의 스레드만 실행됩니다.
 *   		}
 *   
 *   스레드가 객체 내부의 동기화 메소드 또는 블록에 들어가면 즉시 객체에 잠금을 걸어
 *   다른 스레드가 임계 영역 코드를 실행하지 못하도록 합니다.
 */
package ex17_10_syn_format1;

public class MultithreadExample {

	public static void main(String[] args) {
		SharedArea area = new SharedArea();
		area.account1 = new Account("111-111-1111", "이몽룡", 20000000);
		area.account2 = new Account("222-222-2222", "이춘향", 10000000);
		TransferThread thread1 = new TransferThread(area);
		PrintThread thread2 = new PrintThread(area);
		thread1.start();
		thread2.start();
	}

}
