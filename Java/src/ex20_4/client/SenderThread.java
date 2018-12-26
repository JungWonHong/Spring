package ex20_4.client;

import java.io.*;
import java.net.*;

public class SenderThread extends Thread {
	Socket socket;
	String name;
	
	SenderThread(Socket socket, String name) {
		this.socket = socket;
		this.name = name;
	}

	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			//키보드로 입력받는 것을 byte로 읽어들인다. 
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			
			
			//제일 먼저 서버로 대화명을 송신합니다.
			writer.println(name);
			writer.flush();
			
			//키보드로 입력된 메시지를 서버로 송신합니다.
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
