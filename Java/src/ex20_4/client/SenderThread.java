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
			//Ű����� �Է¹޴� ���� byte�� �о���δ�. 
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			
			
			//���� ���� ������ ��ȭ���� �۽��մϴ�.
			writer.println(name);
			writer.flush();
			
			//Ű����� �Էµ� �޽����� ������ �۽��մϴ�.
			while (true) {
				// Ű����κ��� ���ڿ��� �Է¹޽��ϴ�.
				String str = reader.readLine();

				// ����ڰ� "bye"��� �Է��ϸ� �ݺ����� ���������ϴ�.
				if (str.equals("bye"))
					break;

				// �Էµ� ���ڿ��� Ŭ���̾�Ʈ�� �۽��մϴ�.
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
