package ex18_4_Data;
import java.io.*;
public class DataInputStreamError {

	public static void main(String[] args) {
		DataInputStream in = null;
		try{
			in = new DataInputStream(new FileInputStream("output.dat"));
			//public DataInputSTream(InputStream in)
			while(true){
				//데이터를 읽다가 파일 끝을 만나면 EOFException 발생
				int data = in.readInt();
				if(data<0)
					break;
				System.out.print(data);
			}
			
		}
		catch(FileNotFoundException fe){
			fe.printStackTrace();
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
