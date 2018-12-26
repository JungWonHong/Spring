package ex19_5_Serialization_Object_field;

import java.io.*;

public class ObjectOutputExample4 {

	public static void main(String[] args) {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream("output4.dat"));
			BBSItem obj = new BBSItem("이석영", "moonlight", "자료 파일입니다.", "첨부 파일을 참고하십시오.");
			obj.addAttachment(new Object());
			
			System.out.println("전체게시물의 수 : " + obj.itemnum); // 게시물의 수
			System.out.println("글쓴이 : " + obj.writer);
			System.out.println("패스워드 : " + obj.passwd); // transient인스턴스
			System.out.println("제목 : " + obj.title);
			System.out.println("내용 : " + obj.content);
			System.out.println("첨부 : " + obj.attachment);
			
			out.writeObject(obj); // writeObject 메소드가 IOException 발생
			//직렬화 대상 필드 중에 하나라도 직렬화 할 수 없는 타입의 필드가 있으면 익셉션 발생해서
			//객체 전체가 직렬화 되지 않게 됩니다.
		} catch (IOException ie) {
			System.out.println("파일로 출력할 수 없습니다.");
			ie.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (Exception e) {
			}
		}

	}

}
