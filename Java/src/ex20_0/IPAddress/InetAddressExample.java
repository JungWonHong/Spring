package ex20_0.IPAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressExample {

	public static void main(String[] args) {
		try {
			// �ڹٴ� IP �ּҸ� java.net.InetAddress ��ü�� ǥ���մϴ�.
			// getLocalHost() : ���� ��ǻ���� �ּҸ� ��� �ɴϴ�.
			InetAddress local = InetAddress.getLocalHost();
			System.out.println(local);

			// local.getHostAddress() : IP �ּҸ� String ������ ��ȯ�մϴ�.
			System.out.println("�� ��ǻ�� IP �ּ� : " + local.getHostAddress());

			/*
			 * getByName(String host) : ������ �̸����� DNS���� �� �ϳ��� IP�ּҸ� ����
			 * InetAddress�� �����ϰ� �����մϴ�. getAllByName() : DNS�� ��ϵ� ��� IP�ּҸ� ���
			 * �ɴϴ�. (���� Ŭ���̾�Ʈ�� ���� ȸ���� ��� ������ �����ϸ� ���� ���� �ϳ��� ������ �̸��� ���� ���� ��ǻ��
			 * IP�� ����ؼ� ��մϴ�.)
			 */
			InetAddress[] iaArr = InetAddress.getAllByName("www.naver.com");
			for (InetAddress remote : iaArr) {
				System.out.println("www.naver.com IP �ּ� : " + remote.getHostAddress());
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
