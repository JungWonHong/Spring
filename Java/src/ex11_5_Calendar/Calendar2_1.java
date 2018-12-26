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
			System.out.print(year + "년" + month + "월" + day + "일" + " 오전" + 
		hour + "시" + minute + "분" + second + "초");
		else
			System.out.print(year + "년" + month + "월" + day + "일" + " 오후" + 
		hour + "시" + minute + "분" + second + "초");
 
		switch (today.get(Calendar.DAY_OF_WEEK)) {
		case 1:
			w = Week.SUNDAY;
			System.out.print(" "+ w.value()+"입니다.");
			break;
		case 2:
			w = Week.MONDAY;
			System.out.print(" "+ w.value()+"입니다.");
			break;
		case 3:
			w = Week.TUESDAY;
			System.out.print(" "+ w.value()+"입니다.");
			break;
		case 4:
			w = Week.WEDNESDAY;
			System.out.print(" "+ w.value()+"입니다.");
			break;
		case 5:
			w = Week.THURSDAY;
			System.out.print(" "+ w.value()+"입니다.");
			break;
		case 6:
			w = Week.FRIDAY;
			System.out.print(" "+ w.value()+"입니다.");
			break;
		default:
			w = Week.SATURDAY;
			System.out.print(" "+ w.value()+"입니다.");
			break;
		}

	}

}
