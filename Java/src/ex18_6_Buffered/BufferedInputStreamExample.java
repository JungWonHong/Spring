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
			System.out.println("������ ã�� �� �����ϴ�.");
		}
		catch(IOException ie){
			System.out.println("������ ���� �� �����ϴ�.");
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
