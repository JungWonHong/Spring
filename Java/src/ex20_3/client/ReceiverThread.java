package ex20_3.client;

import java.io.*;
import java.net.*;

public class ReceiverThread extends Thread {
	Socket socket;

	ReceiverThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		try {
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));

			// 클라이언트로부터 메시지를 수신해서 모니터로 출력해야 합니다.
			while (true) {
				String str = reader.readLine();
				// 소켓의 연결이 끊어지면 null을 리턴합니다.
				if (str == null)
					break;
				System.out.println("수신>>" + str);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
