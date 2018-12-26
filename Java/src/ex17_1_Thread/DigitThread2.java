/*
 * -java.lang.Thread Ŭ������ �� Ŭ������ ���� Ŭ������
 *  Thread(������) Ŭ������� �մϴ�.
 * -�����尡 �� ���� run �޼ҵ� �ȿ� �ۼ��ؾ� �մϴ�.
 * -public void run()�� �������� �ۼ��մϴ�.
 */
package ex17_1_Thread;

public class DigitThread2 extends Thread {
	
	/*Thread thread;
	DigitThread2(Thread thread){
		this.thread = thread;
	}*/
	// �������̵� - �������̵� ���ص� ������ ����
	// start �޼ҵ忡 ���� ����˴ϴ�.
	public void run() {
		Thread.State state = this.getState();
		System.out.println("�������� ���� = : " + state);
		for (int cnt = 0; cnt < 10; cnt++)
			System.out.print(cnt);
	}
}
