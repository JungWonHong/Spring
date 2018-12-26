//클라이언트 프로그램
package ex20_4.client;
import java.net.*;
public class ClientExample {
	public static void main(String[] args){
		//args 파라미터로 대화명을 입력 받습니다.
		if(args.length != 1){
			System.out.println("대화명을 입력하세요");
			return;
		}
		try{
			//서버와 연결을 맺습니다.
			Socket socket = new Socket("127.0.0.1", 9002);
			
			//메시지 송신 스레드 생성
			Thread thread1 = new SenderThread(socket, args[0]);
			
			//메시지 수신 스레드 생성
			Thread thread2 = new ReceiverThread(socket);
			
			//스레드 시작
			thread1.start();
			thread2.start();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
