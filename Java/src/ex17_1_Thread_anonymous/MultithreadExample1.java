package ex17_1_Thread_anonymous;

public class MultithreadExample1 {

	public static void main(String[] args) {
		//�͸��� �ڽ� ��ü�� �����մϴ�.
		Thread thread = new Thread(){
			public void run(){
				for(int cnt =0;cnt<10;cnt++)
					System.out.print(cnt);
			}
		};//�����带 ����
		
		// thread�� �����ŵ�ϴ�.
		thread.start();
		
		for(char ch = 'A';ch<='Z';ch++)
			System.out.print(ch);
	}

}
