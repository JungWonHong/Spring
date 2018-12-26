package ex17_4_Runnable_Interface;

public class ThreadPriorityControl {

	public static void main(String[] args) {
		ThreadLife tl = new ThreadLife();
		//ù ��° Thread ����
		Thread first = new Thread(tl, "first1");
		
		//��������(1)�� �����ϴ� �κ�
		first.setPriority(Thread.MIN_PRIORITY);
		System.out.println("first priority = " + first.getPriority());
		
		//�� ��° Thread ����
		Thread second = new Thread(tl, "second1");
		//�ְ����(10)�� �����ϴ� �κ�
		second.setPriority(Thread.MAX_PRIORITY);
		System.out.println("second priority = " + second.getPriority());
		
		//�� ��° Thread ����(�켱������ �������� ���� ���)
		Thread third = new Thread(tl, "third1");
		System.out.println("third priority = " + third.getPriority());
		
		first.start();
		second.start();
		third.start();
	}

}
