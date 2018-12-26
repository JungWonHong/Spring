package ex20_3.client;

import java.io.*;
import java.net.*;

public class SenderThread extends Thread {
	Socket socket;

	SenderThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter writer = new PrintWriter(socket.getOutputStream());

			while (true) {
				// 키보드로부터 문자열을 입력받습니다.
				String str = reader.readLine();

				// 사용자가 "bye"라고 입력하면 반복문을 빠져나갑니다.
				if (str.equals("bye"))
					break;

				// 입력된 문자열을 클라이언트로 송신합니다.
				writer.println(str);
				writer.flush();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				socket.close();
			} catch (Exception ignored) {
			}
		}
	}
}
