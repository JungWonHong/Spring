//transient 키워드 : 직렬화에서 제외 시킬 필드를 표시하는 키워드
//실행 순서 : ObjectOutputExample3.java -> ObjectInputExample3
package ex19_4_Serialization_transient;

public class BBSItem implements java.io.Serializable { // 게시물 클래스
	static int itemnum = 0; // 게시물의 수 - 정적 필드는 직렬화 대상이 되지 않습니다.
	String writer; 			// 글쓴이 - 인스턴스 필드는 직렬화 대상이 됩니다.
	transient String passwd;// 패스워드 - transient 키워드 붙은 인스턴스 필드
							// 직렬화 대상이 되지 않습니다.
	String title; 			// 제목 - 인스턴스 필드는 직렬화 대상이 됩니다.
	String content; 		// 내용 - 인스턴스 필드는 직렬화 대상이 됩니다.

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

}
