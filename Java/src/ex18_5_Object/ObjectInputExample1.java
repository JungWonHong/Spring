//ObjectInputStream 클래스를 이용하여 객체를 파일로 부터 읽는 예
//GregorianCalendar는 직렬화 가능한 클래스 :
//	java.io.Serializeble 인터페이스를 구현하는지 여부
package ex18_5_Object;
import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
public class ObjectInputExample1 {

	public static void main(String[] args) {
		ObjectInputStream in = null;
		try{
			//파일을 엽니다.
			//ObjectInputStream 클래스는 스트림 형태로 읽어들인 객체를 프로그램에서
			//사용할 수 있는 객체로 만드는 기능의 클래스입니다.
			//이 클래스를 FileInputStream 클래스와 함께 사용하면 파일에 저장된 객체를
			//프로그램에서 다시 읽어서 사용할 수 있습니다.
			//FileInputStream 객체를 생성해서 ObjectInputStream 생성자 파라미터로
			//넘겨주어야 합니다.
			in = new ObjectInputStream(new FileInputStream("output.dat"));
			while(true){
				//객체를 역질렬화하는 부분 : 스트림을 객체로 만드는 작업
				//readObject 메소드 : 입력된 스트림으로부터 객체를 만들어서 리턴하는 메소드
				//리턴 타입 Object를 원래의 클래스 타입으로 사용하기 위해 캐스트 연산을 해야합니다.
				//readObject()가 Object형이므로 GregorianCalendar 타입으로 형 변환 합니다.
				GregorianCalendar calendar = (GregorianCalendar)in.readObject();
				int year = calendar.get(Calendar.YEAR);
				int month = calendar.get(Calendar.MONTH) + 1;
				int date = calendar.get(Calendar.DATE);
				System.out.println(year + " / " + month + " / " + date);
			}
		}
		catch(FileNotFoundException fe){
			System.out.println("파일이 존재하지 않습니다.");
		}
		catch(EOFException eofe){ //파일로부터 더이상 읽을 객체가 없을 때 발생하는 예외 처리
			System.out.println("끝");
		}
		catch(IOException ie){
			System.out.println();
		}
		catch(ClassNotFoundException cnfe){
			System.out.println("해당 클래스가 존재하지 않습니다.");
		}
		finally{
			try{
				in.close();
			}
			catch(Exception e){
				
			}
		}
	}

}
