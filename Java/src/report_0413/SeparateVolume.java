package report_0413;

import report_0413.Lendable.State;

class SeparateVolume implements Lendable  {
    String requestNo;      // 청구번호
    String bookTitle;      // 제목
    String writer;         // 저자
    String borrower;       // 대출인
    String checkOutDate;   // 대출일
    State state;            // 대출상태 - 초기화(0)
    SeparateVolume(String requestNo, String bookTitle, String writer) {
        this.requestNo = requestNo;//청구번호
        this.bookTitle = bookTitle;//제목
        this.writer = writer;      //저자
        this.state = State.STATE_NORMAL;
    }
    public void checkOut(String borrower, String date) {
        if (state != State.STATE_NORMAL) //STATE_NORMAL=0(대출되지 않은 상태)-Lendable 인터페이스 상수 필드
            return;
        this.borrower = borrower;
        this.checkOutDate = date;
        this.state = State.STATE_BORROWED; //STATE_BORROWED=1(대출중)-Lendable 인터페이스 상수 필드
        System.out.println("*" + bookTitle + " 이(가) 대출되었습니다.");
        System.out.println("대출인:" + borrower);
        System.out.println("대출일:" + date + "\n");    
    }
    public void checkIn() {
        this.borrower = null;
        this.checkOutDate = null;
        this.state = State.STATE_NORMAL;
        System.out.println("*" + bookTitle + " 이(가) 반납되었습니다.\n");
    }
}
