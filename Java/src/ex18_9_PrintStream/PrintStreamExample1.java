//PrintStream Ŭ���� ��� ��
package ex18_9_PrintStream;

import java.util.GregorianCalendar;

public class PrintStreamExample1 {

	public static void main(String[] args) {
		System.out.println("     *** ����ǥ ***      ");

		// ������ �����ؼ� ����մϴ�.
		System.out.printf("%5s : %3d %3d %3d %5.1f %n", "������", 92, 87, 95, 91.3f);
		System.out.printf("%5s : %3d %3d %3d %5.1f %n", "������", 100, 90, 88, 92.7f);
		System.out.printf("%-5s : %3d %3d %3d %5.1f %n", "�ֹ���", 75, 88, 85, 83.7f);
		System.out.printf("�ۼ�����1 : %1$tY�� %1$tm�� %1$td��  %1$tp %1$tH�� %n", new GregorianCalendar());
		System.out.printf("�ۼ�����2 : %1$ty�� %1$tm�� %1$td��  %1$tp %1$tI�� %n", new GregorianCalendar());
		System.out.printf("�ۼ�����3 : %1$tY�� %1$tB  %1$td��  %1$tA %1$tp " + "%1$tl�� %1$tM�� %1$tS %n", 
				new GregorianCalendar());
		System.out.printf("�ۼ�����4 : %1$tD %n", new GregorianCalendar());
		System.out.printf("�ۼ�����5 : %1$tF %n", new GregorianCalendar());

	}

}
