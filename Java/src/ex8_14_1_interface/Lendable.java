package ex8_14_1_interface;
//대출 가능 인터페이스
public interface Lendable {
	public abstract void checkOut(String borrower, String date); // 대출한다.

	public abstract void checkIn(); // 반납한다.
}
