//DataInputStream 클래스 사용 예
//DataOutputStream 클래스를 이용하여 파일에 저장했던 데이터를 프로그램으로
//다시 읽어오기 위해서는 DataInputStream 클래스를 이용해야 합니다.
//하지만 이 클래스는 파일에 데이터를 읽는 기능은 없기 때문에
//FileInputStream 클래스와 함께 사용해야 합니다.
package ex18_4_Data;
import java.io.*;
public class DataInputExample1 {

	public static void main(String[] args) {
		DataInputStream in = null;
		try{
			in = new DataInputStream(new FileInputStream("output.dat"));
			//public DataInputSTream(InputStream in)
			
			//파일로부터 정수를 읽어서 출력한다.
			while(true){
				//데이터를 읽다가 파일 끝을 만나면 EOFException 발생
				int data = in.readInt();
				System.out.print(data + " ");
			}
			
		}
		catch(FileNotFoundException fe){
			fe.printStackTrace();
		}
		catch(EOFException eofe){ //readInt()메소드에 의해 파일에 끝에 도달하면 이곳으로 이동
			System.out.println("끝");
		}
		catch(IOException ie){
			ie.printStackTrace();
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
