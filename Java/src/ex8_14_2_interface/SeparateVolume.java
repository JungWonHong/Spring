package ex8_14_2_interface;
//대출 가능 인터페이스를 구현하는 단행본 클래스
public class SeparateVolume implements Lendable {
	String requestNo;	// 청구번호
	String bookTitle;	// 제목
	String writer;		// 저자
	String borrower;	// 대출인
	String checkOutDate;// 대출일
	byte state;			// 대출상태

	public SeparateVolume(String requestNo, String bookTitle, String writer) {
		this.requestNo = requestNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}
	
	public void checkOut(String borrower, String date) {// 대출한다
		if (state != 0) // 처음 state 값은 0
			return;
		this.borrower = borrower;
		this.checkOutDate = date;
		this.state = 1; // 대출상태 : state = 1;
		System.out.println("*" + bookTitle + " 이(가) 대출되었습니다.");
		System.out.println("대출인:" + borrower);
		System.out.println("대출일:" + date + "\n");
	}

	public void checkIn() {// 반납한다
		this.borrower = null;
		this.checkOutDate = null;
		this.state = 0; // 반납 상태 : state = 0;
		System.out.println("*" + bookTitle + " 이(가) 반납되었습니다.");
	}
}
