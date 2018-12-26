package ex19_4_Serialization_transient;

import java.io.*;

public class ObjectOutputExample3 {

	public static void main(String[] args) {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream("output3.dat"));
			BBSItem obj = new BBSItem("최선희", "sunshine", "정모합시다", "이번주 주말 어떠세요?");
			System.out.println("전체게시물의 수 : " + obj.itemnum); // 게시물의 수
			System.out.println("글쓴이 : " + obj.writer);
			System.out.println("패스워드 : " + obj.passwd); // transient인스턴스
			System.out.println("제목 : " + obj.title);
			System.out.println("내용 : " + obj.content);
			out.writeObject(obj); // 객체를 직렬화하는 부분
		} catch (IOException ie) {
			System.out.println("파일로 출력할 수 없습니다.");
		} finally {
			try {
				out.close();
			} catch (Exception e) {
			}
		}

	}

}
