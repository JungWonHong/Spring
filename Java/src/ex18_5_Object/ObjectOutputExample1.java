//ObjectOutputStream 클래스를 이용하여 객체를 파일에 저장하는 예
package ex18_5_Object;
import java.io.*;
import java.util.GregorianCalendar;

public class ObjectOutputExample1 {

	public static void main(String[] args) {
		ObjectOutputStream out = null;
		try{
			//파일을 엽니다.
			/*ObjectOutputStream 클래스는 객체를 스트림으로 만들어서
			   출력하는 기능이 있는 클래스입니다.
			   이 클래스에는 데이터를 파일에 저장하는 기능이 없기 때문에
			  FileOutputStream 클래스와 함께 사용해야 합니다.
			  FileOutputStream 객체를 생성해서
			  ObjectOutputStream클래스의 생성자 파라미터로 넘겨주어야 합니다.
			*/
			out = new ObjectOutputStream(new FileOutputStream("output.dat"));
			
			//객체를 직렬화 하는 부분 : 객체를 스트림으로 만드는 작업
			/*
			  WriteObject 메소드 : 파라미터로 넘겨준 객체를 스트림으로 만들어서 출력하는 메소드
			    파라미터로 넘겨진 객체가 파일에 저장됩니다.
			  GregorianCalendar객체를 생성해서 파일에 씁니다.
			*/
			
			out.writeObject(new GregorianCalendar(2017, 0, 14));
			out.writeObject(new GregorianCalendar(2017, 0, 15));
			out.writeObject(new GregorianCalendar(2017, 0, 16));
		}
		catch (IOException ie) {
			System.out.println("파일을 출력할 수 없습니다.");
		}
		finally {
			try {
				out.close(); //파일을 닫습니다.
			} catch (Exception e) {

			}
		}

	}

}
