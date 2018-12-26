package ex20_1.client;

import java.io.*;
import java.net.*;

public class ClientExample1 {

	public static void main(String[] args) {
		System.out.println("여기는 클라이언트 입니다.~");
		Socket socket = null;
		try {
			// 생성자를 호출하면 이 생성자 안에서 서버 프로그램으로 연결 요청이 전송되고
			// 그 결과 클라이언트 프로그램과 서버 프로그램의 연결이 맺어지게 됩니다.
			socket = new Socket("127.0.0.1", 9000); // 소켓을 생성합니다.

			// 데이터 수신에 사용할 입력 스트림 객체를 리턴하는 메소드
			InputStream in = socket.getInputStream();

			// 데이터 송신에 사용할 출력 스트림 객체를 리턴하는 메소드
			OutputStream out = socket.getOutputStream();

			String str = "Hello, Server";
			out.write(str.getBytes());
			// getBytes 메소드는 문자열을 바이트 배열로 만드는 메소드입니다.
			// 인자로 넘겨준 데이터를 송신합니다.

			byte arr[] = new byte[100];
			in.read(arr); // 데이터를 수신합니다.

			System.out.println(new String(arr)); // 수신된 데이터를 출력합니다.
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				socket.close();
			} catch (Exception e) {
			}
		}
	}

}
