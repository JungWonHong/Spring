package ex8_16_interface_constant;

public interface Lendable {
	final static byte STATE_BORROWED = 1;	// ���� ��
	final static byte STATE_NORMAL = 0;		// ������� ���� ����
	
	//public abstract ��������(�˾Ƽ� �ٿ���)
	void checkOut(String borrower, String date); // �����Ѵ�.
	
	void checkIn(); // �ݳ��Ѵ�.
}
