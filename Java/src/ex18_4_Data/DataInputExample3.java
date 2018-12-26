package ex18_4_Data;
import java.io.*;
public class DataInputExample3 {

	public static void main(String[] args) {
		DataInputStream in = null;
		try{
			in = new DataInputStream(new FileInputStream("output.dat"));
			//public DataInputSTream(InputStream in)
			
			while(true){
				String strdata = in.readUTF();
				int intdata = in.readInt();
				double dbdata = in.readDouble();
				System.out.print(strdata + intdata + "\n" + dbdata);
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
