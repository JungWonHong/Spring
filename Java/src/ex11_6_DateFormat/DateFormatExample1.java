package ex11_6_DateFormat;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatExample1 {

	public static void main(String[] args) {
		SimpleDateFormat sd1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sd2 = new SimpleDateFormat("yyyy년MM월dd일");
		
		//현재 시스템 날짜와 시간 구하는 방법
		//1. 클래스 Date 이용하는 방법 - 현재 시스템 날짜와 시간 구합니다.
		Date d = new Date();
		System.out.println("Date 사용 : " + d);
		//System.out.println("Date 사용 : " + new Date()); //위 두문장과 같은 의미
		
		System.out.println(sd1.format(d)); // yyyy-MM-dd 형태로 출력
		System.out.println(sd2.format(d)); // yyyy년MM월dd일 형태로 출력
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 a h시 m분 s초 E요일");
		//E : 국가가 한국이라 한국어로 출력. 국가 설정을 영어로 하면 영어로 출력
		
		//System클래스를 ㅣ용해서 시스템의 밀리초 구하기
		//(국제표준시각(UTC, GMT) 1970/1/1/0/0/0 으로부터 경과한 시각)
		System.out.println(System.currentTimeMillis() + "밀리초");
		
		//2. 클래스 Timestamp 이용하는 방법 - 현재 시스템 날짜와 시간 구한다.
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		System.out.println("Timestamp사용 : " + ts); //날짜, 시간 정보
		
		//위 두 문장과 일치 - 레퍼런스 변수없이 출력가능
		//System.out.println(new Timestamp(System.currentTimeMillis());
		
		/*
		 * java.lang.Object
		 * 		java.util.Date
		 * 			java.sql.Timestamp
		 * 
		 * String java.text.DateFormat.format(Date date)
		 */

		System.out.println(sdf.format(ts));//업캐스팅  : Date형이 들어갈 곳에 Timestamp형이 들어감
	}

}
