//SimpleDateFormat 클래스를 사용하여 날짜와 시간을 포맷하는 프로그램
//SimpleDateFormat 클래스의 format()메소드의 매개변수로 Date형 필요
//Calendar의 getTime() 메소드를 이용해서  Date형 리턴값 얻음
//Calendar -> Date 형
package ex11_6_DateFormat;

import java.text.*;//SimpleDateFormat 클래스가 속하는 패키지
import java.util.*;

public class DateFormatExample2 {

	public static void main(String[] args) {
		GregorianCalendar calendar = new GregorianCalendar();

		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY년 MM월 dd일 aa HH시 mm분 ss초");

		SimpleDateFormat dateFormat2 = new SimpleDateFormat("YYYY년 M월 d일 a h시 m분 s초");

		SimpleDateFormat dateFormat3 = new SimpleDateFormat("YYYY년 M월 d일 E a h시 m분 s초");
		
		//calendar.getTime() : calendar객체가 가지고 있는 날짜와 시간과 똑같은
		//Date 객체를 만들어서 리턴하는 메서드입니다.
		System.out.println(calendar.getTime());
		System.out.println(new Date());
		System.out.println(calendar.getTimeInMillis());
		
		//calendar.getTime()의 리턴형은 Date형
		String str = dateFormat.format(calendar.getTime());
		System.out.println(str);
		
		String str2 = dateFormat2.format(calendar.getTime());
		System.out.println(str2);
		
		String str3 = dateFormat3.format(calendar.getTime());
		System.out.println(str3);
	}

}
