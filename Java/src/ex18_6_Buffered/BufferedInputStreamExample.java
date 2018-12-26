package ex18_6_Buffered;
import java.io.*;
public class BufferedInputStreamExample {

	public static void main(String[] args) {
		BufferedInputStream in = null;
		try{
			in = new BufferedInputStream(new FileInputStream("output.txt"));
			while(true){
				int data = in.read();
				if(data < 0)
					break;
				System.out.print(data + " ");
			}
		}
		catch(FileNotFoundException fe){
			System.out.println("파일을 찾을 수 없습니다.");
		}
		catch(IOException ie){
			System.out.println("파일을 읽을 수 없습니다.");
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
