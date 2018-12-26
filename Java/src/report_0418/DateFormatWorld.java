package report_0418;

import java.util.*;
import java.text.*;

public class DateFormatWorld {

	public static void main(String[] args) {
		GregorianCalendar calendar = new GregorianCalendar();
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy/MM/dd (E) a hh:mm");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy/MM/dd (E) a hh:mm");
		SimpleDateFormat dateFormat3 = new SimpleDateFormat("yyyy/MM/dd (E) a hh:mm");

		dateFormat1.setTimeZone(TimeZone.getTimeZone("America/New_York"));
		dateFormat2.setTimeZone(TimeZone.getTimeZone("Asia/Hong_Kong"));
		dateFormat3.setTimeZone(TimeZone.getTimeZone("Europe/Paris"));

		String str1 = dateFormat1.format(calendar.getTime());
		String str2 = dateFormat2.format(calendar.getTime());
		String str3 = dateFormat3.format(calendar.getTime());
		System.out.print("����  " + str1 + "\n");
		System.out.print("ȫ��  " + str2 + "\n");
		System.out.print("�ĸ�  " + str3 + "\n");

	}

}
