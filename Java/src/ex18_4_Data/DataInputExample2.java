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
