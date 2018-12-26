package ex18_4_Data;
import java.io.*;
public class DataInputStreamError {

	public static void main(String[] args) {
		DataInputStream in = null;
		try{
			in = new DataInputStream(new FileInputStream("output.dat"));
			//public DataInputSTream(InputStream in)
			while(true){
				//�����͸� �дٰ� ���� ���� ������ EOFException �߻�
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
