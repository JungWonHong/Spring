package ex8_15_1_interface_polymorphism;

public interface Lendable {
	public abstract void checkOut(String borrower, String date); // 대출한다.

	public abstract void checkIn(); // 반납한다.
}
