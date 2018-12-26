package report_0413;

public interface Lendable {
	public enum State {
		STATE_BORROWED("���� ��"), STATE_NORMAL("���� ����");
		final private String check;

		private State(String check) { //�̰� ������ָ� �����Ϸ��� ���� �ִ� �����ڿ� �Ű������� �ϳ� �� �߰����ش�.
			this.check = check;
		}

		String value() {
			return check;
		}
	}

	// public abstract ��������(�˾Ƽ� �ٿ���)
	void checkOut(String borrower, String date); // �����Ѵ�.

	void checkIn(); // �ݳ��Ѵ�.
}