//PrintWriter 클래스는 데이터를 포맷해서 파일로 출력하는 기능이 있는 클래스이다.
package ex18_8_PrintWriter;
import java.io.*;
import java.util.GregorianCalendar;
public class PrintWriterExample2 {

	public static void main(String[] args) {
		PrintWriter writer = null;
		
		try{
			writer = new PrintWriter("output.txt"); //파일을 엽니다.
			writer.println("     *** 성적표 ***      ");
			
			//데이터 포맷해서 출력합니다.
			writer.printf("%5s : %3d %3d %3d %5.1f %n", "김지영", 92, 87, 95, 91.3f);
			writer.printf("%5s : %3d %3d %3d %5.1f %n", "박현식", 100, 90, 88, 92.7f);
			writer.printf("%-5s : %3d %3d %3d %5.1f %n", "최민재", 75, 88, 85, 83.7f);
			writer.printf("작성일자1 : %1$tY년 %1$tm월 %1$td일  %1$tp %1$tH시 %n", new GregorianCalendar());
			writer.printf("작성일자2 : %1$ty년 %1$tm월 %1$td일  %1$tp %1$tI시 %n", new GregorianCalendar());
			writer.printf("작성일자3 : %1$tY년 %1$tB  %1$td일  %1$tA %1$tp " + "%1$tl시 %1$tM분 %1$tS %n",
					new GregorianCalendar());
			writer.printf("작성일자4 : %1$tD %n", new GregorianCalendar());
			writer.printf("작성일자5 : %1$tF %n", new GregorianCalendar());
			
			 /*
			  년도 : Y-4자리, y-2자리
			    월 : m-(01~12), B-(예:January)
			    일 : d-(1~31), e-(01~31)
			  요일 : A-(Sunday), a-(sun) ;영어
			  요일 : A-(일요일), a-(일)  ; 대한민국
			  오전/오후 구분 : p
			  시   : H-(00~23), I(아이 대문자)-(01~12), k-(0~23),
			         l(엘 소문자)-(1~12)
			  분   : M-(00~59)
			  초  :  S-(00~59)
			  mm/dd/yy 포맷 : D
			  YYYY-mm-dd 포맷 : F
			  HH:MM 포맷 : R
			  HH:MM:SS 포맷 : T
			 */
		}
		catch(IOException ioe){
			System.out.print("파일로 출력할 수 없습니다.");
		}
		finally{
			try{
				System.out.println("저장완료");
				writer.close();
			}
			catch(Exception e){
				
			}
		}

	}

}
