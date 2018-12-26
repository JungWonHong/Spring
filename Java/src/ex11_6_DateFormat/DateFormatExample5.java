package ex11_6_DateFormat;

import java.text.*;
import java.util.*;

public class DateFormatExample5 {

	public static void main(String[] args) {
		GregorianCalendar calendar = new GregorianCalendar();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy�� MM�� dd�� aa hh�� mm�� ss��");
		
		//�̱�.������ TimeZone��ü�� ������ setTimeZone �޼ҵ� ȣ���Ͽ���.
		dateFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));
		
		String str = dateFormat.format(calendar.getTime());
		System.out.println(str);

	}

}
