//�� Ŭ���̾�Ʈ ���ӿ� ���� �ϳ��� �۵��ϴ� ������ Ŭ����
package ex20_4.server;

import java.io.*;
import java.util.*;
import java.net.*;

public class PerClientThread2 extends Thread {
	// ArrayList ��ü�� ���� �����尡 ���ÿ� ����ϰ� �Ǹ� ������ �߻��� �� �־�
	// �����ϰ� ������ �� �ִ� ����ȭ�� ����Ʈ�� ����ϴ�. 
	//-> ��� �� PrintWriter��ü�� �������ʾҴµ� �ٸ� PrintWriter��ü�� �������� ���� �ǵ����� ���� ���� write�ɼ� �ִ�.
	// ����ȭ�� ����Ʈ�� ����� ���� java.util.Collections Ŭ������
	// synchronizedList�޼��带 �̿��մϴ�.
	static List<PrintWriter> list = Collections.synchronizedList(new ArrayList<PrintWriter>());
	// ��Ƴ��ٰ� ����� ��Ʈ������ �����ֱ� ���ؼ� ����Ʈ�� Ȱ���Ѵ�.

	Socket socket;
	PrintWriter writer;

	PerClientThread2(Socket socket) {
		this.socket = socket;
		try {
			writer = new PrintWriter(socket.getOutputStream()); //�޾ƿ� ��
			list.add(writer);// ����Ʈ�� ������ ��� ��Ʈ���� ����մϴ�.
			//������ ��ο��� �����͸� ��������ϱ� ������ 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void run() {
		String name = null;
		try {
			//Byte�� ���°��� ���ڷ� �ٲٰ� ���۸� ���ؼ� �о���δ�.(�ӵ����)
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			/*
			 * SenderThread.java���� writer.println(name); writer.flush(); �� ����
			 * name�� �Ʒ��� ���忡�� �о�ɴϴ�.
			 */
			// ���ŵ� ù��° ���ڿ��� ��ȭ������ ����ϱ� ���� �����մϴ�.
			name = reader.readLine();
			sendAll("#" + name + "���� �����̽��ϴ�");

			while (true) {
				//�������κ��� ������ �޾ƿ´�.
				String str = reader.readLine();

				// ������ ������ �������� null�� �����մϴ�.
				if (str == null)
					break;

				// ������ �޾ƿ� ���� ��ο��� ��������ϱ� ������  sendAll�� ���� ��� Ŭ���̾�Ʈ���� �۽��Ѵ�.
				// ���ŵ� �޽��� �տ� ��ȭ���� �ٿ��� ��� Ŭ���̾�Ʈ�� �۽��մϴ�.
				sendAll(name + ">" + str);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			list.remove(writer);
			// ����ڰ� ä���� �����ߴٴ� �޽����� ��� Ŭ���̾�Ʈ�� �����ϴ�.
			sendAll("#" + name + "���� �����̽��ϴ�");

			try {
				socket.close();
			} catch (Exception ignored) {
			}
		}
	}
	
	//������ ����� ��� Ŭ���̾�Ʈ�� �Ȱ��� �޽����� �����ϴ�.
	private void sendAll(String str) {
		for(PrintWriter writer : list){
			writer.println(str); 
			writer.flush();
		}
		System.out.println(str); //������ ����մϴ�.
	}

}
