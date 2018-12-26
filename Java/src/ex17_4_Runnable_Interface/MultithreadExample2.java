package ex17_4_Runnable_Interface;

public class MultithreadExample2 {

	public static void main(String[] args) {
		ThreadLife tl = new ThreadLife();
		
		// 첫 번째 Thread 생성
		Thread first = new Thread(tl, "first");
		//생성자 형식 : Thread(Runnable target, String name)
		//Allocates a new Thread object.
		
		// 두 번째 Thread 생성
		Thread second = new Thread(tl, "second");
		
		// 세 번째 Thread 생성
		Thread third = new Thread(tl, "third");
		
		first.start();
		second.start();
		third.start();
	}

}
