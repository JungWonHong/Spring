package report_0413;

public interface Lendable {
	public enum State {
		STATE_BORROWED("대출 중"), STATE_NORMAL("대출 가능");
		final private String check;

		private State(String check) { //이걸 만들어주면 컴파일러가 원래 있는 생성자에 매개변수를 하나 더 추가해준다.
			this.check = check;
		}

		String value() {
			return check;
		}
	}

	// public abstract 생략가능(알아서 붙여줌)
	void checkOut(String borrower, String date); // 대출한다.

	void checkIn(); // 반납한다.
}
