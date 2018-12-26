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
			System.out.println("������ ã�� �� �����ϴ�.");
		}
		catch(IOException ie){
			System.out.println("������ ���� �� �����ϴ�.");
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
