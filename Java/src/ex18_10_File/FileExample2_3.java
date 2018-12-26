package ex18_10_File;

import java.io.*;

public class FileExample2_3 {

	public static void main(String[] args) {
		String dir = "E:\\newDirectory\\newFile.txt";
		//파일 삭제
		File f3 = new File(dir);
		if(f3.exists()){
			System.out.println(f3.getPath() + "삭제했습니다.");
			f3.delete(); //파일 삭제
		}else{
			System.out.println(f3.getPath() + "에 삭제하고자 하는 파일이 없습니다.");
		}
		
		//디렉토리 삭제
		File f4 = new File("E:\\newDirectory");
		if(f4.exists()){
			System.out.println(f4.getPath() + "삭제했습니다.");
			f4.delete();
		}else{
			System.out.println(f4.getPath() + "에 삭제하고자 하는 디렉토리가 없습니다.");
		}
	}

}
