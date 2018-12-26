package ex18_4_Data;
import java.io.*;
public class DataInputExample2 {

	public static void main(String[] args) {
		DataInputStream in = null;
		try{
			in = new DataInputStream(new FileInputStream("output.dat"));
			//public DataInputSTream(InputStream in)
			
			while(true){
				String data = in.readUTF();
				System.out.print(data);
			}
			
		}
		catch(FileNotFoundException fe){
			fe.printStackTrace();
		}
		catch(EOFException eofe){ //readInt()�޼ҵ忡 ���� ���Ͽ� ���� �����ϸ� �̰����� �̵�
			System.out.println("��");
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
