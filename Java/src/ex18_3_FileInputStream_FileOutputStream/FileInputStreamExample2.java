package ex18_3_FileInputStream_FileOutputStream;
import java.io.*;
public class FileInputStreamExample2 {

	public static void main(String[] args) {
		if(args.length<1){
			System.out.println("파일명을 Arguments탭에 output1.dat 입력해 주세요.");
			return;
		}
		FileInputStream in = null;
		try{
			in = new FileInputStream(args[0]); //파일을 연다.
			//Run -> Run Configurations에서 매개변수 값으로 output1.dat 입력
			
			while(true){
				int data = in.read();
				
				if(data < 0) //읽어온 데이터가 -1이면 반복을 중단
					break;
				
				System.out.print(data + " ");
			}
		}
		catch(FileNotFoundException fe){
			System.out.println(args[0] + " 파일이 존재하지 않습니다.");
		}
		catch(IOException ie){
			System.out.println(args[0] + " 파일을 읽을 수 없습니다.");
		}
		finally{
			try{
				in.close(); //파일을 닫습니다.
			}
			catch(Exception e){
			}
		}

	}

}
