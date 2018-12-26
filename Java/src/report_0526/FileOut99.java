package report_0526;
import java.io.*;
public class FileOut99 {

	public static void main(String[] args) {
		DataOutputStream out = null;
		try{
			out = new DataOutputStream(new FileOutputStream("gugudan.txt"));
			for(int i = 2;i<10;i++)
				out.writeUTF("["+i+"´Ü]");
			
			for(int i = 1;i<10;i++){
				for(int j = 2;j<10;j++){
					out.writeInt(j);
					out.writeUTF("*");
					out.writeInt(i);
					out.writeUTF("=");
					out.writeInt(i*j);
				}
				System.out.println();
			}
		}
		catch(IOException ie){
			ie.printStackTrace();
		}
		finally{
			try{
				out.close();
			}
			catch(Exception e){
				
			}
		}

	}

}
