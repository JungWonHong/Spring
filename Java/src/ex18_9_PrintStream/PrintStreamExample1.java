//PrintStream 클래스 사용 예
package ex18_9_PrintStream;

import java.util.GregorianCalendar;

public class PrintStreamExample1 {

	public static void main(String[] args) {
		System.out.println("     *** 성적표 ***      ");

		// 데이터 포맷해서 출력합니다.
		System.out.printf("%5s : %3d %3d %3d %5.1f %n", "김지영", 92, 87, 95, 91.3f);
		System.out.printf("%5s : %3d %3d %3d %5.1f %n", "박현식", 100, 90, 88, 92.7f);
		System.out.printf("%-5s : %3d %3d %3d %5.1f %n", "최민재", 75, 88, 85, 83.7f);
		System.out.printf("작성일자1 : %1$tY년 %1$tm월 %1$td일  %1$tp %1$tH시 %n", new GregorianCalendar());
		System.out.printf("작성일자2 : %1$ty년 %1$tm월 %1$td일  %1$tp %1$tI시 %n", new GregorianCalendar());
		System.out.printf("작성일자3 : %1$tY년 %1$tB  %1$td일  %1$tA %1$tp " + "%1$tl시 %1$tM분 %1$tS %n", 
				new GregorianCalendar());
		System.out.printf("작성일자4 : %1$tD %n", new GregorianCalendar());
		System.out.printf("작성일자5 : %1$tF %n", new GregorianCalendar());

	}

}
