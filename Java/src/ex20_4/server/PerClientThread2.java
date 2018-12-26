//각 클라이언트 접속에 대해 하나씩 작동하는 스레드 클래스
package ex20_4.server;

import java.io.*;
import java.util.*;
import java.net.*;

public class PerClientThread2 extends Thread {
	// ArrayList 객체를 여러 스레드가 동시에 사용하게 되면 문제가 발생할 수 있어
	// 안전하게 공유할 수 있는 동기화된 리스트로 만듭니다. 
	//-> 어느 한 PrintWriter객체가 끝나지않았는데 다른 PrintWriter객체의 생성으로 인해 의도하지 않은 것이 write될수 있다.
	// 동기화된 리스트로 만들기 위해 java.util.Collections 클래스의
	// synchronizedList메서드를 이용합니다.
	static List<PrintWriter> list = Collections.synchronizedList(new ArrayList<PrintWriter>());
	// 모아놨다가 연결된 스트림으로 보내주기 위해서 리스트를 활용한다.

	Socket socket;
	PrintWriter writer;

	PerClientThread2(Socket socket) {
		this.socket = socket;
		try {
			writer = new PrintWriter(socket.getOutputStream()); //받아온 것
			list.add(writer);// 리스트에 소켓의 출력 스트림을 등록합니다.
			//서버는 모두에게 데이터를 보여줘야하기 때문에 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void run() {
		String name = null;
		try {
			//Byte로 들어온것을 문자로 바꾸고 버퍼를 통해서 읽어들인다.(속도향상)
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			/*
			 * SenderThread.java에서 writer.println(name); writer.flush(); 로 보낸
			 * name을 아래의 문장에서 읽어옵니다.
			 */
			// 수신된 첫번째 문자열을 대화명으로 사용하기 위해 저장합니다.
			name = reader.readLine();
			sendAll("#" + name + "님이 들어오셨습니다");

			while (true) {
				//누군가로부터 정보를 받아온다.
				String str = reader.readLine();

				// 소켓의 연결이 끊어지면 null을 리턴합니다.
				if (str == null)
					break;

				// 서버는 받아온 것을 모두에게 보여줘야하기 때문에  sendAll을 통해 모든 클라이언트에게 송신한다.
				// 수신된 메시지 앞에 대화명을 붙여서 모든 클라이언트로 송신합니다.
				sendAll(name + ">" + str);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			list.remove(writer);
			// 사용자가 채팅을 종료했다는 메시지를 모든 클라이언트로 보냅니다.
			sendAll("#" + name + "님이 나가셨습니다");

			try {
				socket.close();
			} catch (Exception ignored) {
			}
		}
	}
	
	//서버에 연결된 모든 클라이언트로 똑같은 메시지를 보냅니다.
	private void sendAll(String str) {
		for(PrintWriter writer : list){
			writer.println(str); 
			writer.flush();
		}
		System.out.println(str); //서버에 출력합니다.
	}

}
