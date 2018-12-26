package ex11_5_Calendar;

import java.util.Calendar;

public class Calendar2_1 {

	public static void main(String[] args) {
		Calendar today = Calendar.getInstance();

		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH) + 1;
		int day = today.get(Calendar.DAY_OF_MONTH);
		int am_pm = today.get(Calendar.AM_PM);
		int hour = today.get(Calendar.HOUR);
		int minute = today.get(Calendar.MINUTE);
		int second = today.get(Calendar.SECOND);
		Week w;

		if (am_pm == 0)
			System.out.print(year + "��" + month + "��" + day + "��" + " ����" + 
		hour + "��" + minute + "��" + second + "��");
		else
			System.out.print(year + "��" + month + "��" + day + "��" + " ����" + 
		hour + "��" + minute + "��" + second + "��");
 
		switch (today.get(Calendar.DAY_OF_WEEK)) {
		case 1:
			w = Week.SUNDAY;
			System.out.print(" "+ w.value()+"�Դϴ�.");
			break;
		case 2:
			w = Week.MONDAY;
			System.out.print(" "+ w.value()+"�Դϴ�.");
			break;
		case 3:
			w = Week.TUESDAY;
			System.out.print(" "+ w.value()+"�Դϴ�.");
			break;
		case 4:
			w = Week.WEDNESDAY;
			System.out.print(" "+ w.value()+"�Դϴ�.");
			break;
		case 5:
			w = Week.THURSDAY;
			System.out.print(" "+ w.value()+"�Դϴ�.");
			break;
		case 6:
			w = Week.FRIDAY;
			System.out.print(" "+ w.value()+"�Դϴ�.");
			break;
		default:
			w = Week.SATURDAY;
			System.out.print(" "+ w.value()+"�Դϴ�.");
			break;
		}

	}

}