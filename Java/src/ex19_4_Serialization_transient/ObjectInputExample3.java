package ex19_4_Serialization_transient;

import java.io.*;

public class ObjectInputExample3 {

	public static void main(String[] args) {
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream("output3.dat"));
			BBSItem obj = (BBSItem) in.readObject(); // 객체를 역직렬화

			System.out.println("전체게시물의 수 : " + obj.itemnum); // 게시물의 수
			System.out.println("글쓴이 : " + obj.writer);
			System.out.println("패스워드 : " + obj.passwd); // transient인스턴스
			System.out.println("제목 : " + obj.title);
			System.out.println("내용 : " + obj.content);
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
