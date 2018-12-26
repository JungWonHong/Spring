package ex17_4_Runnable_Interface;

public class MultithreadExample2 {

	public static void main(String[] args) {
		ThreadLife tl = new ThreadLife();
		
		// ù ��° Thread ����
		Thread first = new Thread(tl, "first");
		//������ ���� : Thread(Runnable target, String name)
		//Allocates a new Thread object.
		
		// �� ��° Thread ����
		Thread second = new Thread(tl, "second");
		
		// �� ��° Thread ����
		Thread third = new Thread(tl, "third");
		
		first.start();
		second.start();
		third.start();
	}

}
