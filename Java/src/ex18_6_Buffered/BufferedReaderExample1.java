//�Ѳ����� ���� ���ڸ� �д� read �޼ҵ� ��
package ex18_6_Buffered;

import java.io.*;

public class BufferedReaderExample1 {

	public static void main(String[] args) {
		BufferedReader reader = null;
		char arr[] = new char[64]; //���Ͽ� �ִ� ���ڸ� ���� char�迭
		try {
			reader = new BufferedReader(new FileReader("output.txt"));
			int num = reader.read(arr);
			System.out.println(new String(arr, 0, num));
		} catch (FileNotFoundException fe) {
			System.out.println("������ ã�� �� �����ϴ�.");
			//fe.printStackTrace();
		} catch (IOException ie) {
			System.out.println("������ ���� �� �����ϴ�.");
		} catch (NullPointerException ne){
			System.out.println("NullPointerException �߻�");
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
