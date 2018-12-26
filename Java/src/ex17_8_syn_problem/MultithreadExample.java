/*계좌이체와 잔액 합계 출력을 동시에 하는 멀티스레드 프로그램
 * 
 * - 이몽룡의 계좌에서 인출된 100만원이 성춘향의 계좌로 입금되기 전에
 * 	 printThread로 실행 제어가 넘어가 계좌 잔액 합계 2900000 출력되었습니다.
 * - 문제 해결법
 *   동기화:공유 데이터 사용 중에 그 공유 데이터를 다른 스레드가 사용하지 못하도록
 *        만드는 것을 의미합니다.
 */
package ex17_8_syn_problem;

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
