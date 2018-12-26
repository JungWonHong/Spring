//DataOutputStream 클래스 사용 예 - 문자열 쓰기
// String 타입의 데이터를 쓰는 메소드 : writeUTF()
// String 타입 외의 다른 객체를 쓰는 기능은 없다.
// 다른 타입의 객체를 쓸려면 ObjectOutputStream 클래스를 사용해야 한다.
package ex18_4_Data;

import java.io.*;

public class DataOutputExample3 {

	public static void main(String[] args) {
		DataOutputStream out = null;
		try{
			//1.open
			out = new DataOutputStream(new FileOutputStream("output.dat"));
			
			//2.write : 파일에 int 타입 데이터를 씁니다.
			//출력 순서가 String -> int -> Double 이라면
			//입력 순서도 String -> int -> Double 이어야 합니다.
			out.writeUTF("즐거운 금요일 입니다.~\n");
			out.writeInt(5);
			out.writeDouble(3.14);
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
