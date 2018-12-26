package ex11_5_Calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Calendar5 {

	public static void main(String[] args) {
		// Calendar calendar = new GregorianCalendar(2002, 7, 1);
		// Calendar calendar = new GregorianCalendar(2002, 7, 1, 14, 30);
		Calendar calendar = new GregorianCalendar(2002, 7, 1, 14, 30, 15);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int date = calendar.get(Calendar.DATE);
		int week = calendar.get(Calendar.DAY_OF_WEEK);
		String yoil = "";

		switch (week) {
		case 1:
			yoil = Week.SUNDAY.value();
			break;
		case 2:
			yoil = Week.MONDAY.value();
			break;
		case 3:
			yoil = Week.TUESDAY.value();
			break;
		case 4:
			yoil = Week.WEDNESDAY.value();
			break;
		case 5:
			yoil = Week.THURSDAY.value();
			break;
		case 6:
			yoil = Week.FRIDAY.value();
			break;
		case 7:
			yoil = Week.SATURDAY.value();
			break;
		}
		
		int amPm = calendar.get(Calendar.AM_PM);
		int hour = calendar.get(Calendar.HOUR);
		int min = calendar.get(Calendar.MINUTE);
		int sec = calendar.get(Calendar.SECOND);

		String sAmPm = (amPm == Calendar.AM) ? "����" : "����";

		System.out.printf("%d�� %d�� %d�� %s %s  %d�� %d�� %d��", year, month, date, yoil, sAmPm, hour, min, sec);
	}

}
