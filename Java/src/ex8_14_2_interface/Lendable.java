package ex8_14_2_interface;

public interface Lendable {
	public abstract void checkOut(String borrower, String date); // 대출한다.

	public abstract void checkIn(); // 반납한다.
}
