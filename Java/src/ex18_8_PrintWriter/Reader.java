package ex18_8_PrintWriter;
import java.io.*;
public class Reader {

	public static void main(String[] args) {
		FileReader reader = null;
		try{
			reader = new FileReader("print.txt");
			while(true){
				int data = reader.read();
				
				if(data < 0)
					break;
				
				char pt = (char)data;
				System.out.print(pt);
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
				reader.close();
			}
			catch(Exception e){
				
			}
		}

	}

}
