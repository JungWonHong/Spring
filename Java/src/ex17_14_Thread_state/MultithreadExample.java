//notify�޼ҵ�� wait�޼ҵ� ��� ��
/*
 * - ������ ���̿� ��ȣ�� ���� �ְ� ���� �� �ֽ��ϴ�.
 *   ����ȭ�� ������� ����ȭ ��Ͽ��� �ٸ� �����忡�� ������� �ѱ��� ���մϴ�.
 *   �̿� ���� ����ȭ�� ��Ͽ��� �����尣�� ���(������� �ѱ�)�ϱ� ���ؼ�
 *   wait(), notify(), notifyAll() �޼ҵ带 ����ؾ� �մϴ�.
 *   �� �޼ҵ带 ����� ���� synchronized ��Ͽ����� �ǹ̰� �ֽ��ϴ�.
 */
package ex17_14_Thread_state;

public class MultithreadExample {

	public static void main(String[] args) {
		CalcThread thread1 = new CalcThread();
		PrintThread thread2 = new PrintThread();
		
		//����͸� ������ ����
		//CalcThread ����͸�
		MonitorThread thread3 = new MonitorThread(thread1);
		
		//����͸� ������ ����
		//PrintThread ����͸�
		//MonitorThread thread3 = new MonitorThread(thread2);
		
		SharedArea obj = new SharedArea();
		thread1.sharedArea = obj;
		thread2.sharedArea = obj;
		
		thread1.start();
		thread2.start();
		thread3.start();
	}

}
