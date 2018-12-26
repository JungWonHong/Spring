//Runnable인터페이스를 이용한 멀티스레드 프로그램
package ex17_4_Runnable_Interface;

public class SmallLetters implements Runnable {
	public void run() {
		for (char ch = 'a'; ch <= 'z'; ch++)
			System.out.print(ch);
	}

}
