//순서대로 안나와요 - 실행할 때 마다 결과가 달라요
package ex17_4_Runnable_Interface;

public class ThreadLife implements Runnable {
	public void run() {
		for (int i = 1; i < 3; i++) {
			// 현재 실행 중인 thread의 이름과 정수 출력
			System.out.println("현재 실행 중인 스레드의 이름은" + 
					Thread.currentThread().getName() + "이고," + 
					"\t number = " + i);
		}
	}

}
