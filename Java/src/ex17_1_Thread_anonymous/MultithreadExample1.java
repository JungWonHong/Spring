package ex17_1_Thread_anonymous;

public class MultithreadExample1 {

	public static void main(String[] args) {
		//익명의 자식 객체를 생성합니다.
		Thread thread = new Thread(){
			public void run(){
				for(int cnt =0;cnt<10;cnt++)
					System.out.print(cnt);
			}
		};//쓰레드를 생성
		
		// thread를 실행시킵니다.
		thread.start();
		
		for(char ch = 'A';ch<='Z';ch++)
			System.out.print(ch);
	}

}
