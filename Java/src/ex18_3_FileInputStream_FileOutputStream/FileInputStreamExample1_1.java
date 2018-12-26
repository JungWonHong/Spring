package ex18_3_FileInputStream_FileOutputStream;
import java.io.*;
public class FileInputStreamExample1_1 {

	public static void main(String[] args) {
		FileInputStream in = null;
		try{
			in = new FileInputStream("output1.dat");
			
			while (true){
				int data = in.read();
				if(data == -1)
					break;
				
				byte ch = (byte)data;
				System.out.print(ch);
			}
		}catch (FileNotFoundException fe) {
			System.out.println("������ ã�� �� �����ϴ�.");
			// fe.printStackTrace();
		} 
		catch (IOException ie) {
			System.out.println("������ ���� �� �����ϴ�.");
		} 
		catch (NullPointerException ne) {// Exception - RuntimeException
			System.out.println("NullPointerException ���� �߻�");
		} 
		finally { // ������ �ݴ� ��ɹ��� ������ ������� ó���ϱ� ���� finally ��Ͽ�
			try {
				in.close(); // ������ �ݴ� ��ɹ�
			} 
			catch (Exception e) { //close�޼ҵ尡 �߻��ϴ� ���� ó��
								  //IOException�� NullPointerException
			}
		}

	}

}
