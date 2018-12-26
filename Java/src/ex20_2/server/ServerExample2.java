package ex20_2.server;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class ServerExample2 {

	public static void main(String[] args) {
		System.out.println("����� �����Դϴ�.~");
		ServerSocket serverSocket = null;
		Socket socket = null;
		try{
			serverSocket = new ServerSocket(9000);
			socket = serverSocket.accept();
			
			//InputStreamReaderŬ���� : ����Ʈ ��Ʈ���� ���� ��Ʈ������ �ٲپ��ִ� Ŭ����
			//��Ŭ������ �����ڿ� �������κ��� ���� InputStream��ü�� �Ѱ��ָ� ��Ʈ��ũ��
			//���ŵ� �����͸� ���� ��Ʈ�� ���·� ���� �� �ִ� InputStreamRedaer��ü�� �����˴ϴ�.
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			
			//PrintWriter Ŭ������ �̿��Ͽ� ���� ��Ʈ���� ����Ʈ ��Ʈ������ �ٲپ ����ϱ� ����
			//�� Ŭ������ �����ڿ� OutputStream Ÿ���� ��ü�� �Ķ���ͷ� �Ѱ��־�� �մϴ�.
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			
			//�����͸� �����մϴ�.
			String str = reader.readLine();
			
			//�����͸� ����մϴ�.
			System.out.println(str);
			
			//�����͸� �۽��մϴ�.
			writer.println("Hello, Client");
			//PrintWriter Ŭ������ println�޼ҵ�� ���ڿ��� ����ϸ� �� ���ڿ��� �޼ҵ� ȣ�� ���
			//��Ʈ��ũ�� �۽ŵǴ� ���� �ƴ϶� ���۰� �� �� ������ ������ٰ� �Ѳ����� �۽ŵ˴ϴ�.
			//�׷��� println �޼ҵ带 ȣ���� ������ �ٷ� ���ڿ��� �۽ŵǵ��� �Ϸ��� flush�޼ҵ带 ȣ���մϴ�.
			writer.flush();
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
