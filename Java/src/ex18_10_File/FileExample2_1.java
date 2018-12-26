//File  클래스를 디렉토리 생성
//실행 한 번 후 : 새로 만든 디렉토리 이름
//실행 두 번 후 : 이미 있는 디렉토리 이름
package ex18_10_File;
import java.io.*;
public class FileExample2_1 {

	public static void main(String[] args) {
		String dir = "E:\\newDirectory";
		//디렉토리 생성
		File f2 = new File(dir);
		if(!f2.exists()){
			System.out.println("새로 만든 디렉토리 이름 : " + f2.getPath());
			f2.mkdir(); //디렉토리 생성
		}else{
			System.out.println("이미 있는 디렉토리 이름 : " + f2.getPath());
		}

	}

}
