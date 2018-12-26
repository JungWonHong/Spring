package ex11_5_Calendar;

import java.util.*;

public class Calendar6 {

	public static void main(String[] args) {
		Calendar calendar = new GregorianCalendar();
		TimeZone timeZone = TimeZone.getTimeZone("Europe/London");
		calendar.setTimeZone(timeZone);

		System.out.println("런던의 현재 시간 입니다.");
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int date = calendar.get(Calendar.DATE);
		int amPm = calendar.get(Calendar.AM_PM);
		int hour = calendar.get(Calendar.HOUR);
		int min = calendar.get(Calendar.MINUTE);
		int sec = calendar.get(Calendar.SECOND);

		String sAmPm = (amPm == Calendar.AM) ? "오전" : "오후";

		System.out.printf("%d년 %d월 %d일 %s  %d시 %d분 %d초", year, month, date, sAmPm, hour, min, sec);

	}

}
