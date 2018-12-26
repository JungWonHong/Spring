package report_0526;
import java.io.*;
public class File99danReader {

	public static void main(String[] args) {
		FileReader reader = null;
		try{
			reader = new FileReader("gugudan.txt");
			
			//����� �� �ִ� �� ������ ���
			/*
			 * while(true){
			 * 	int data = reader.read(); //���Ͽ� �ִ� ���� �ϳ��� �о �����ϴ�
			 * 	if (data == -1)
			 * 		break;
			 * 	System.out.print((char)data);
			 * }
			 */
			
			/*
			 * int data;
			 * while((data=reader.read())!=-1){
			 * 	System.out.print((char)data);
			 * }
			 */
			
			int data;
			char arr[] = new char[100];
			while((data=reader.read(arr))!=-1){
				System.out.print(new String(arr, 0, data));
			}
		}catch (FileNotFoundException fe) {
			System.out.println("������ ã�� �� �����ϴ�.");
			//fe.printStackTrace();
		} catch (IOException ie) {
			System.out.println("������ ���� �� �����ϴ�.");
		} catch(NullPointerException np){
			System.out.println("NullPointerException ���� �߻�");
		} finally{
			try{
				reader.close();
			}catch(Exception e){
			}
		}
	}

}
