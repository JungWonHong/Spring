package ex8_17_interface_exception;
//�߻� �޼ҵ忡 throws ���� �߰��� ���� ���� �������̽�
//���� Ŭ�������� throws ���� ����� ���
//�������̽������� throws ���� �ۼ��� �־�� �մϴ�.
public interface Lendable2 {
	abstract void checkOut(String borrower, String date) throws Exception; // ����ó��. �����Ѵ�
	
	abstract void checkIn(); // �ݳ��Ѵ�.
}
