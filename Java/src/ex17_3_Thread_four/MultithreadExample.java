//�� ���� ������� ����Ǵ� ��Ƽ������ ���α׷�
//main, thread1, thread2, thread3
package ex17_3_Thread_four;

public class MultithreadExample {

	public static void main(String[] args) {
		//�� ���� �����带 �����ؼ� �����մϴ�.
		Thread thread1 = new DigitThread();
		Thread thread2 = new DigitThread();
		Thread thread3 = new AlphabetThread();
		thread1.start();
		thread2.start();
		thread3.start();
		/*
		 * Thread t = Thread.currenThread();
		 * Thread�� ���� �޼ҵ��� currentThread()�� �ڵ带 �����ϴ� 
		 * ���� �������� ������ ���� �� �ֽ��ϴ�.
		 * setName()�޼ҵ�� �������� �̸��� ������ �� �ְ� 
		 * getName()�޼ҵ�� �������� �̸��� ������ �� �ֽ��ϴ�.
		 * ��) t.setName("�������̸�");
		 * ��) t.getName();
		 */
		System.out.println("������ �̸� : " + Thread.currentThread().getName());
		
	}

}
