package ex20_2.client;

import java.io.*;
import java.net.*;

public class ClientExample2 {

	public static void main(String[] args) {
		System.out.println("����� Ŭ���̾�Ʈ �Դϴ�.~");
		Socket socket = null;
		try {
			socket = new Socket("192.168.20.37", 9000);
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));

			PrintWriter writer = new PrintWriter(socket.getOutputStream());

			// �����͸� �۽��մϴ�.
			// println �޼ҵ� ȣ�� ��� ��Ʈ��ũ�� �۽ŵǴ� ���� �ƴ϶� ���۰� �� �������� ������ٰ�
			// �׷��� ������ println �޼ҵ带 ȣ���� ������ �ٷ� ���ڿ��� �۽ŵǵ��� �Ϸ��� flush
			writer.println("Hello, Server");
			writer.flush();

			// �����͸� �����մϴ�.
			String str = reader.readLine();
			// ���ŵ� �����͸� ����մϴ�.
			System.out.println(str);
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
