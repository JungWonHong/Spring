package ex7_05_default_contructor;

public class ConstrExample3 {

	public static void main(String[] args) {
		SubscriberInfo obj;
		obj = new SubscriberInfo(); 
		//The constructor SubscriberInfo() is undefined
		obj.name = "�̿���԰��";
		obj.address = "���ﱸû�԰��";
		obj.id = "SsapGoSu";
		obj.password = "ssapssapgosu";
		obj.phoneNo = "112";
		printSubscriberInfo(obj);
	}

	static void printSubscriberInfo(SubscriberInfo obj) {
		System.out.println("�̸�:" + obj.name);
		System.out.println("���̵�:" + obj.id);
		System.out.println("�н�����:" + obj.password);
		System.out.println("��ȭ��ȣ:" + obj.phoneNo);
		System.out.println("�ּ�:" + obj.address);
		System.out.println();
	}
}
