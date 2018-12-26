package ex8_17_interface_exception;
//���� ���� �������̽��� �����ϴ� ���ົ Ŭ����
public class SeparateVolume2 implements Lendable2 {
	String requestNo;	// û����ȣ
	String bookTitle;	// ����
	String writer;		// ����
	String borrower;	// ������
	String checkOutDate;// ������
	byte state;			// �������

	public SeparateVolume2(String requestNo, String bookTitle, String writer) {
		this.requestNo = requestNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}
	
	//�������̵��Ѱ��� ����ó���� �ϱ� ���ؼ��� �θ��� ����ο��� �Ȱ��� ���������Ѵ�.
	public void checkOut(String borrower, String date) throws Exception {// �����Ѵ�
		if (state != 0) // ó�� state ���� 0
			throw new Exception("*����Ұ�:" + bookTitle);
		this.borrower = borrower;
		this.checkOutDate = date;
		this.state = 1; // ������� : state = 1;
		System.out.println("*" + bookTitle + " ��(��) ����Ǿ����ϴ�.");
		System.out.println("������:" + borrower);
		System.out.println("������:" + date + "\n");
	}

	public void checkIn() {// �ݳ��Ѵ�
		this.borrower = null;
		this.checkOutDate = null;
		this.state = 0; // �ݳ� ���� : state = 0;
		System.out.println("*" + bookTitle + " ��(��) �ݳ��Ǿ����ϴ�.");
	}
}
