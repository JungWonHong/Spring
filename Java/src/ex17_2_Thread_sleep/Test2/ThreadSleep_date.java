package ex17_2_Thread_sleep.Test2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadSleep_date extends Thread {
	public void run() {
		SimpleDateFormat s = new SimpleDateFormat("yyyy��MM��dd�� E���� hh��mm��ss��");
		try {
			while (true) {
				Date d = new Date();
				System.out.println(s.format(d.getTime()));
				Thread.sleep(1000); // 1��
			}
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}

}
