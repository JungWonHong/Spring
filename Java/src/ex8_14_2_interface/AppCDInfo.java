package ex8_14_2_interface;
//���� ���� �������̽��� �����ϴ� �η� CD Ŭ����
//���߻��
public class AppCDInfo extends CDInfo implements Lendable{
	String borrower;	// ������
	String checkOutDate;// ������
	byte state;			// �������

	AppCDInfo(String registerNo, String title) {
		super(registerNo, title);  //��ӹ���Ŭ����(CDInfo)�� ������
	}

	//public :  �������̽��� �޼ҵ带 ������ �� �ݵ�� ����ؾ� �ϴ� Ű����
	//�����Ѵ�.
	public void checkOut(String borrower, String date) {
		if (state != 0)
			return;

		this.borrower = borrower;
		this.checkOutDate = date;
		this.state = 1;
		System.out.println("*" + title + " CD�� ����Ǿ����ϴ�.");
		System.out.println("������:" + borrower);
		System.out.println("������:" + date + "\n");
	}
	
	//�ݳ��Ѵ�.
	public void checkIn() {
		this.borrower = null;
		this.checkOutDate = null;
		this.state = 0;
		System.out.println("*" + title + " CD�� �ݳ��Ǿ����ϴ�.\n");
	}
}
