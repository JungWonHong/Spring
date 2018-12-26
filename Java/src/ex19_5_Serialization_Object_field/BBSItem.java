//직렬화가 불가능한 타입의 필드를 포함하는 직렬화 가능 클래스의 예
//기본형과 직렬화 기능 클래스 타입의 필드는 모두 직렬화 가능합니다.
//Object는 java.io.Serializable 인터페이스를 구현하지 않기 때문에
//직렬화 가능 클래스가 아닙니다.
package ex19_5_Serialization_Object_field;

public class BBSItem implements java.io.Serializable { // 게시물 클래스
	static int itemnum = 0; // 게시물의 수 - 정적 필드는 직렬화 대상이 되지 않습니다.
	String writer; 			// 글쓴이 - 인스턴스 필드는 직렬화 대상이 됩니다.
	transient String passwd;// 패스워드 - transient 키워드 붙은 인스턴스 필드
							// 직렬화 대상이 되지 않습니다.
	String title; 			// 제목 - 인스턴스 필드는 직렬화 대상이 됩니다.
	String content; 		// 내용 - 인스턴스 필드는 직렬화 대상이 됩니다.
	Object attachment;		// 첨부파일 - 직렬화 대상이 아닙니다.

	// 생성자는 직렬화 대상이 되지 않습니다.
	BBSItem(String writer, String passwd, String title, String content) {
		this.writer = writer;
		this.passwd = passwd;
		this.title = title;
		this.content = content;
		itemnum++;
	}
	
	//메소드는 직렬화 대상이 되지 않습니다.
	void modifyContent(String content, String passwd){
		if(!passwd.equals(this.passwd))
			return;
		this.content = content;
	}
	
	void addAttachment(Object attachment){
		this.attachment = attachment;
	}

}
