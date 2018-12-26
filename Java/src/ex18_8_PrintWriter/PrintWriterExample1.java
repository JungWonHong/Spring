//패키지 ex18_2의 FileWriterExample1.java를 참고하여
//PrintWriter 클래스 이용한 프로그램으로 수정해 보기
//PrintWriter 클래스는 데이터를 포맷해서 파일로 출력하는 기능이 있는 클래스입니다.
package ex18_8_PrintWriter;
import java.io.*;
public class PrintWriterExample1 {

	public static void main(String[] args) {
		PrintWriter writer = null;
		try{
			writer = new PrintWriter("print.txt"); //파일을 엽니다.
			
			//String 처리
			String s = "내꺼인 듯 내꺼 아닌 내꺼 같은 너";
			writer.println(s);
			
			//char 배열 처리
			char arr[] = {'내','꺼','인',' ','듯',' ','내','꺼',' ','아','닌',' ','내','꺼',' ','같','은',' ','너'};
			writer.println(arr);
		}
		catch(IOException ie){
			System.out.println("오류 발생");
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
