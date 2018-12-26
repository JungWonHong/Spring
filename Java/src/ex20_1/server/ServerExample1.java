//서버 프로그램을 먼저 실행하고 클라이언트 프로그램을 실행합니다.
package ex20_1.server;

import java.io.*;
import java.net.*;

public class ServerExample1 {

	public static void main(String[] args) {
		System.out.println("여기는 서버 입니다.~");
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			// 서버 소켓은 연결 요청을 기다리다가, 연결 요청이 오면 연결을 맺고 또 다른 소켓을 생성
			serverSocket = new ServerSocket(9000); // 서버 소켓을 생성

			// 연결 요청이 오면 소켓을 생성합니다.
			// accept 메소드 : 서버 소켓으로 연결 요청이 들어오면 연결을 맺고
			// 클라이언트 소켓을 생성해서 리턴하는 메소드
			socket = serverSocket.accept();

			// 데이터 수신에 사용할 입력 스트림 객체를 리턴하는 메소드
			InputStream in = socket.getInputStream();
			// 데이터 송신에 사용할 출력 스트림 객체를 리턴하는 메소드
			OutputStream out = socket.getOutputStream();

			byte arr[] = new byte[100];
			in.read(arr); // 데이터를 수신합니다.
			System.out.println(new String(arr)); // 수신된 데이터를 출력합니다.

			String str = "Hello, Client";
			out.write(str.getBytes()); // 데이터를 송신합니다.
			// getBytes 메소드는 문자열을 바이트 배열로 만드는 메소드입니다.
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				socket.close(); // 소켓을 닫습니다.
			} catch (Exception ignored) {
			}
			try{
				serverSocket.close(); //서버 소켓을 닫습니다.
			} catch (Exception ignored) {
			}
		}
	}

}
