//PrintWriter Ŭ������ �����͸� �����ؼ� ���Ϸ� ����ϴ� ����� �ִ� Ŭ�����̴�.
package ex18_8_PrintWriter;
import java.io.*;
import java.util.GregorianCalendar;
public class PrintWriterExample2 {

	public static void main(String[] args) {
		PrintWriter writer = null;
		
		try{
			writer = new PrintWriter("output.txt"); //������ ���ϴ�.
			writer.println("     *** ����ǥ ***      ");
			
			//������ �����ؼ� ����մϴ�.
			writer.printf("%5s : %3d %3d %3d %5.1f %n", "������", 92, 87, 95, 91.3f);
			writer.printf("%5s : %3d %3d %3d %5.1f %n", "������", 100, 90, 88, 92.7f);
			writer.printf("%-5s : %3d %3d %3d %5.1f %n", "�ֹ���", 75, 88, 85, 83.7f);
			writer.printf("�ۼ�����1 : %1$tY�� %1$tm�� %1$td��  %1$tp %1$tH�� %n", new GregorianCalendar());
			writer.printf("�ۼ�����2 : %1$ty�� %1$tm�� %1$td��  %1$tp %1$tI�� %n", new GregorianCalendar());
			writer.printf("�ۼ�����3 : %1$tY�� %1$tB  %1$td��  %1$tA %1$tp " + "%1$tl�� %1$tM�� %1$tS %n",
					new GregorianCalendar());
			writer.printf("�ۼ�����4 : %1$tD %n", new GregorianCalendar());
			writer.printf("�ۼ�����5 : %1$tF %n", new GregorianCalendar());
			
			 /*
			  �⵵ : Y-4�ڸ�, y-2�ڸ�
			    �� : m-(01~12), B-(��:January)
			    �� : d-(1~31), e-(01~31)
			  ���� : A-(Sunday), a-(sun) ;����
			  ���� : A-(�Ͽ���), a-(��)  ; ���ѹα�
			  ����/���� ���� : p
			  ��   : H-(00~23), I(���� �빮��)-(01~12), k-(0~23),
			         l(�� �ҹ���)-(1~12)
			  ��   : M-(00~59)
			  ��  :  S-(00~59)
			  mm/dd/yy ���� : D
			  YYYY-mm-dd ���� : F
			  HH:MM ���� : R
			  HH:MM:SS ���� : T
			 */
		}
		catch(IOException ioe){
			System.out.print("���Ϸ� ����� �� �����ϴ�.");
		}
		finally{
			try{
				System.out.println("����Ϸ�");
				writer.close();
			}
			catch(Exception e){
				
			}
		}

	}

}
