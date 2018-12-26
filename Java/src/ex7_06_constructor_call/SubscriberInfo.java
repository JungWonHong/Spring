package ex7_06_constructor_call;

public class SubscriberInfo {
	String name, id, password;
	String phoneNo, address;

	//�Ű� ���� ���� ������ �߰�
	//�ڹ������Ϸ��� Ŭ������ ����� �����ڰ� �ϳ��� ������
	//������ �����ڸ� �߰����� �ʽ��ϴ�.
	SubscriberInfo(){} // �����ڰ� ���ǵǾ������� ����Ʈ�����ڵ� ���� ����������Ѵ�.
	
	SubscriberInfo(String name, String id, String password) {
		this.name = name;
		this.id = id;
		this.password = password;
	}

	SubscriberInfo(String name, String id, String password, String phoneNo, String address) {
//		this.name = name;
//		this.id = id;
//		this.password = password;
		this(name, id, password); //���� �������� �ѹ�������
		//this() : �����ڷ� ���� Ŭ������ �ٸ� �����ڸ� ȣ���� �� ���.
		this.phoneNo = phoneNo;
		this.address = address;
//		this(name, id, password); //������ȣ�⹮�� �ٸ� ��ɹ����� �ڿ� ���� ���� �߸�.
		//Constructor call must be the first statement in a constructor
	}

	void changePassword(String password) {
		this.password = password;
	}

	void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	void setAddress(String address) {
		this.address = address;
	}

}
