//FileWriter 클래스를 이용해서 문자 데이터를 파일에 쓰는 프로그램
//매개변수 두 개의 FileWriter 생성자 사용 예
//연속 2번 실행하기
//writer.write("\n"); 문장을 주석 달고 3번 실행하기
//결과 확인은 FileReaderExampl2.java 로 확인
package ex18_2_FileWriter;

import java.io.*;

public class FileWriterExample2 {

	public static void main(String[] args) {
		FileWriter writer = null;
		try{
			//true : 원래 있던 파일 내용을 유지하라고 지시하는 파라미터
			//		-원래 있던 파일 내용 뒤에 추가로 쓴다.
			writer = new FileWriter("output.txt", true);
			
			//public FileWriter(String fileName) throws IOException
			//FileWriter 생성자는 IOException에러를 발생하기 때문에
			//IOException 처리문이 있어야 합니다.
			
			char arr[] = {'너','를',' ','사','랑','해'};
			
			//파일에 반복해서 문자들을 씁니다.
			for(int cnt = 0;cnt<arr.length;cnt++)
				writer.write(arr[cnt]);
			//위 두 문장과 같은 의미
			//writer.write(arr);
			//writer.write("\n");
		}
		catch(IOException ioe){
			System.out.println("파일로 출력할 수 없습니다.");
		}
		finally {
			try{
				writer.close(); //파일을 닫습니다.
			}
			catch(Exception e){
				
			}
		}

	}

}
