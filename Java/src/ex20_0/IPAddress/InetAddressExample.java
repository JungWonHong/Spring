package ex20_0.IPAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressExample {

	public static void main(String[] args) {
		try {
			// 자바는 IP 주소를 java.net.InetAddress 객체로 표현합니다.
			// getLocalHost() : 로컬 컴퓨터의 주소를 얻어 옵니다.
			InetAddress local = InetAddress.getLocalHost();
			System.out.println(local);

			// local.getHostAddress() : IP 주소를 String 형으로 반환합니다.
			System.out.println("내 컴퓨터 IP 주소 : " + local.getHostAddress());

			/*
			 * getByName(String host) : 도메인 이름으로 DNS에서 단 하나의 IP주소를 얻어와
			 * InetAddress를 생성하고 리턴합니다. getAllByName() : DNS에 등록된 모든 IP주소를 얻어
			 * 옵니다. (연결 클라이언트가 많은 회사의 경우 서버의 과부하를 막기 위해 하나의 도메인 이름에 여러 개의 컴퓨터
			 * IP를 등록해서 운영합니다.)
			 */
			InetAddress[] iaArr = InetAddress.getAllByName("www.naver.com");
			for (InetAddress remote : iaArr) {
				System.out.println("www.naver.com IP 주소 : " + remote.getHostAddress());
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
