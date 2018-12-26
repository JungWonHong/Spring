package ex17_2_Thread_sleep.Test2;

public class Thread_main {

	public static void main(String[] args) {
		Thread thread = new ThreadSleep_date(); // 쓰레드를 생성
		thread.start();
	}

}
