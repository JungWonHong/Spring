//DataOutputStream 클래스 사용 예
//DataOutputStream 클래스는 기본형 데이터를 바이트 스트림으로 만들어서 출력하는 기능의 클래스입니다.
//이 클래스는 파일에 데이터를 쓰는 기능은 없기 때문에 FileOutputStream 클래스와
//함께 사용해야 기본형 데이터를 파일에 쓸 수 있습니다.
//사용법은 먼저 FileOutputStream 객체를 생성한 후 그 객체를 생성자 파라미터로 넘겨야 합니다.
package ex18_4_Data;

import java.io.*;

public class DataOutputExample1 {

	public static void main(String[] args) {
		DataOutputStream out = null;
		try{
			//1.open
			out = new DataOutputStream(new FileOutputStream("output.dat"));
			//java.io.DataOutputStream.DataOutputStream(OutputStream arg0)	
			//형이 다르기 때문에 보조스트림 사용해야한다 (바이트단위로 읽어들이지만 쓰는건 인트형으로 쓰기때문)
			
			int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
			//2.write : 파일에 int 타입 데이터를 씁니다.
			for(int cnt =0;cnt<arr.length;cnt++)
				out.writeInt(arr[cnt]); //파일에 int 타입 데이터를 씁니다.
		}
		catch(IOException ie){
			System.out.println("파일로 출력할 수 없습니다.");
		}
		finally{
			try{
				//3.close : 파일을 닫습니다.
				out.close();
			}
			catch(Exception e){
				
			}
		}
	}

}
