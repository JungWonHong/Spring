package ex19_7_serialVersionUID;

import java.io.*;

public class ObjectInputExample2 {

	public static void main(String[] args) {
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream("output10.dat"));
			Rectangle obj = (Rectangle) in.readObject();

			System.out.println("넓이 : " + obj.width);
			System.out.println("높이 : " + obj.height);
		} catch (FileNotFoundException fe) {
			System.out.println("파일이 존재하지 않습니다.");
		} catch (EOFException eofe) {
			System.out.println("끝");
		} catch (IOException ie) {
			System.out.println("파일을 읽을 수 없습니다.");
		} catch (ClassNotFoundException e) {
			System.out.println("해당 클래스가 존재하지 않습니다.");
		} finally {
			try {
				in.close();
			} catch (Exception e) {
			}
		}

	}

}
