//���� ���α׷��� ���� �����ϰ� Ŭ���̾�Ʈ ���α׷��� �����մϴ�.
package ex20_1.server;

import java.io.*;
import java.net.*;

public class ServerExample1 {

	public static void main(String[] args) {
		System.out.println("����� ���� �Դϴ�.~");
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			// ���� ������ ���� ��û�� ��ٸ��ٰ�, ���� ��û�� ���� ������ �ΰ� �� �ٸ� ������ ����
			serverSocket = new ServerSocket(9000); // ���� ������ ����

			// ���� ��û�� ���� ������ �����մϴ�.
			// accept �޼ҵ� : ���� �������� ���� ��û�� ������ ������ �ΰ�
			// Ŭ���̾�Ʈ ������ �����ؼ� �����ϴ� �޼ҵ�
			socket = serverSocket.accept();

			// ������ ���ſ� ����� �Է� ��Ʈ�� ��ü�� �����ϴ� �޼ҵ�
			InputStream in = socket.getInputStream();
			// ������ �۽ſ� ����� ��� ��Ʈ�� ��ü�� �����ϴ� �޼ҵ�
			OutputStream out = socket.getOutputStream();

			byte arr[] = new byte[100];
			in.read(arr); // �����͸� �����մϴ�.
			System.out.println(new String(arr)); // ���ŵ� �����͸� ����մϴ�.

			String str = "Hello, Client";
			out.write(str.getBytes()); // �����͸� �۽��մϴ�.
			// getBytes �޼ҵ�� ���ڿ��� ����Ʈ �迭�� ����� �޼ҵ��Դϴ�.
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				socket.close(); // ������ �ݽ��ϴ�.
			} catch (Exception ignored) {
			}
			try{
				serverSocket.close(); //���� ������ �ݽ��ϴ�.
			} catch (Exception ignored) {
			}
		}
	}

}
