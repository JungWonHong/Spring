package report_0526;
import java.io.*;
public class File99danReader {

	public static void main(String[] args) {
		FileReader reader = null;
		try{
			reader = new FileReader("gugudan.txt");
			
			//출력할 수 있는 세 가지의 경우
			/*
			 * while(true){
			 * 	int data = reader.read(); //파일에 있는 문자 하나를 읽어서 리턴하는
			 * 	if (data == -1)
			 * 		break;
			 * 	System.out.print((char)data);
			 * }
			 */
			
			/*
			 * int data;
			 * while((data=reader.read())!=-1){
			 * 	System.out.print((char)data);
			 * }
			 */
			
			int data;
			char arr[] = new char[100];
			while((data=reader.read(arr))!=-1){
				System.out.print(new String(arr, 0, data));
			}
		}catch (FileNotFoundException fe) {
			System.out.println("파일을 찾을 수 없습니다.");
			//fe.printStackTrace();
		} catch (IOException ie) {
			System.out.println("파일을 읽을 수 없습니다.");
		} catch(NullPointerException np){
			System.out.println("NullPointerException 예외 발생");
		} finally{
			try{
				reader.close();
			}catch(Exception e){
			}
		}
	}

}
