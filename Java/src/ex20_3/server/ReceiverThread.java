package ex20_3.server;

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

			// Ŭ���̾�Ʈ�κ��� �޽����� �����ؼ� ����ͷ� ����ؾ� �մϴ�.
			while (true) {
				String str = reader.readLine();
				// ������ ������ �������� null�� �����մϴ�.
				if (str == null)
					break;
				System.out.println("����>>" + str);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
