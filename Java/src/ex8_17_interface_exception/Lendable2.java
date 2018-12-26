package ex8_17_interface_exception;
//추상 메소드에 throws 절을 추가한 대출 가능 인터페이스
//구현 클래스에서 throws 절을 사용할 경우
//인터페이스에서도 throws 절을 작성해 주어야 합니다.
public interface Lendable2 {
	abstract void checkOut(String borrower, String date) throws Exception; // 예외처리. 대출한다
	
	abstract void checkIn(); // 반납한다.
}
