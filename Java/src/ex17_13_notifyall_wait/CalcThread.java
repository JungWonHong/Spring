//���̸� ����ϴ� ������ Ŭ����
package ex17_13_notifyall_wait;

public class CalcThread extends Thread {
	SharedArea sharedArea;

	public void run() {
		double total = 0.0;
		// ���̸� ����ϴ� �κ�
		for (int cnt = 1; cnt < 1000000000; cnt += 2)
			if (cnt / 2 % 2 == 0)
				total += 1.0 / cnt;
			else
				total -= 1.0 / cnt;

		// ��� ����� ���� ������ ����
		sharedArea.result = total * 4;
		
		//SharedArea ��ü�� isReady �ʵ� ���� true�� ����
		sharedArea.isReady = true; //���� ��� �����ٴ� �ǹ�
		
		synchronized(sharedArea){
			sharedArea.notifyAll(); //�ٸ� ������� ��ȣ�� ������ �޼ҵ�
			//sharedArea.notify();
		}
	}
}
