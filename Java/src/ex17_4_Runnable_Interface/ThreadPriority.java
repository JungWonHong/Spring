//Thread�� �켱 ���� �ο����� ���� ��
package ex17_4_Runnable_Interface;
public class ThreadPriority implements Runnable {
	public void run() {
		for (int i = 1; i < 3; i++) {
			// thread�� �̸��� ���� ���
			// ���� ���� ���� thread�� �̸��� ���� ���
	          System.out.println( "���� ���� ���� �������� �̸� �� " + 
			  Thread.currentThread().getName() + "�̰�,"
			  +	"\t number = " + i );
			}
	}//run end

    public static void main(String[] args) {
		ThreadPriority tl = new ThreadPriority();
		// ù��° Thread ����
		//�ι�° �Ű��������� Thread�� �̸��� ������ �� �ֽ��ϴ�.
		Thread first = new Thread(tl, "first1"); 
		// �ι�° Thread ����
		Thread second = new Thread(tl, "second1");
		// ����° Thread ����
		Thread third = new Thread(tl, "third1");

		// Thread�� �켱������ ����ϴ� �κ�
		/* ������� �켱����(priority)��� �Ӽ�(�������)�� ������ �ִµ� �� �켱������ ���� ���� �����尡 ��� ����ð��� �޶����ϴ�.
		 * �����尡 �����ϴ� �۾��� �߿䵵�� ���� �������� �켱������ ���� �ٸ��� �����Ͽ� Ư�� �����尡 �� ���� �۾��ð��� ������ �� �� �ֽ��ϴ�.
		 * ���α׷����� �켱 ������ �������� ������ �켱 ������ 5�� ��µ˴ϴ�.
		 * public static final int MAX_PRIORITY  =10;  //�ִ� �켱 ����
		   public static final int NORM_PRIORITY =5;  //���� ������
		   public static final int MIN_PRIORITY  =1; //���� ����
		 */
		System.out.println("Thread�� �켱������ ����ϴ� �κ�");
		System.out.println("first priority =\t" + first.getPriority());
		System.out.println("second priority=\t" + second.getPriority());
		System.out.println("third priority =\t" + third.getPriority());

		first.start();
		second.start();
		third.start();
	}
}
