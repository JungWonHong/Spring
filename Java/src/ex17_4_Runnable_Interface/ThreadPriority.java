//Thread에 우선 순위 부여하지 않은 것
package ex17_4_Runnable_Interface;
public class ThreadPriority implements Runnable {
	public void run() {
		for (int i = 1; i < 3; i++) {
			// thread의 이름과 정수 출력
			// 현재 실행 중인 thread의 이름과 정수 출력
	          System.out.println( "현재 실행 중인 스레드의 이름 은 " + 
			  Thread.currentThread().getName() + "이고,"
			  +	"\t number = " + i );
			}
	}//run end

    public static void main(String[] args) {
		ThreadPriority tl = new ThreadPriority();
		// 첫번째 Thread 생성
		//두번째 매개변수에는 Thread의 이름을 정의할 수 있습니다.
		Thread first = new Thread(tl, "first1"); 
		// 두번째 Thread 생성
		Thread second = new Thread(tl, "second1");
		// 세번째 Thread 생성
		Thread third = new Thread(tl, "third1");

		// Thread의 우선순위를 출력하는 부분
		/* 쓰레드는 우선순위(priority)라는 속성(멤버변수)을 가지고 있는데 이 우선순위의 값에 따라 쓰레드가 얻는 실행시간이 달라집니다.
		 * 쓰레드가 수행하는 작업의 중요도에 따라 쓰레드의 우선순위를 서로 다르게 지정하여 특정 쓰레드가 더 많은 작업시간을 갖도록 할 수 있습니다.
		 * 프로그램에서 우선 순위를 지정하지 않으면 우선 순위가 5로 출력됩니다.
		 * public static final int MAX_PRIORITY  =10;  //최대 우선 순위
		   public static final int NORM_PRIORITY =5;  //순위 미지정
		   public static final int MIN_PRIORITY  =1; //최저 순위
		 */
		System.out.println("Thread의 우선순위를 출력하는 부분");
		System.out.println("first priority =\t" + first.getPriority());
		System.out.println("second priority=\t" + second.getPriority());
		System.out.println("third priority =\t" + third.getPriority());

		first.start();
		second.start();
		third.start();
	}
}
