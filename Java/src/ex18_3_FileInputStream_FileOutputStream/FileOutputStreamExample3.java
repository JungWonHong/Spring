package ex18_3_FileInputStream_FileOutputStream;

import java.io.*;

public class FileOutputStreamExample3 {

	public static void main(String[] args) {
		String originalFilename = "Koala.jpg";
		String targetFileName = "E:/koala.jpg";
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			// 채워주세요.
			fis = new FileInputStream(originalFilename);
			fos = new FileOutputStream(targetFileName);
			
			int readCount;
			byte[] readBytes = new byte[128];
			
			while(true){
				readCount = fis.read(readBytes);
				if(readCount < 0)
					break;
				fos.write(readBytes);
				//fos.write(readBytes, 0, readCount);
			}
			fos.flush();
			fos.close();
			fis.close();
			System.out.println("복사가 잘~ 되었습니다.");
		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		/*finally{
			try{
				fis.close();
				fos.close();
			}
			catch(Exception e){
				
			}
		}*/
	}

}
