package ex11_6_DateFormat;

import java.text.*;
import java.util.*;

public class DateFormatExample5 {

	public static void main(String[] args) {
		GregorianCalendar calendar = new GregorianCalendar();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 aa hh시 mm분 ss초");
		
		//미국.뉴욕의 TimeZone객체를 가지고 setTimeZone 메소드 호출하였다.
		dateFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));
		
		String str = dateFormat.format(calendar.getTime());
		System.out.println(str);

	}

}
