package ex18_3_FileInputStream_FileOutputStream;
import java.io.*;
public class FileInputStreamExample1_1 {

	public static void main(String[] args) {
		FileInputStream in = null;
		try{
			in = new FileInputStream("output1.dat");
			
			while (true){
				int data = in.read();
				if(data == -1)
					break;
				
				byte ch = (byte)data;
				System.out.print(ch);
			}
		}catch (FileNotFoundException fe) {
			System.out.println("파일을 찾을 수 없습니다.");
			// fe.printStackTrace();
		} 
		catch (IOException ie) {
			System.out.println("파일을 읽을 수 없습니다.");
		} 
		catch (NullPointerException ne) {// Exception - RuntimeException
			System.out.println("NullPointerException 예외 발생");
		} 
		finally { // 파일을 닫는 명령문을 에러와 상관없이 처리하기 위해 finally 블록에
			try {
				in.close(); // 파일을 닫는 명령문
			} 
			catch (Exception e) { //close메소드가 발생하는 예외 처리
								  //IOException과 NullPointerException
			}
		}

	}

}
