package ex16_2_System_gc;

public class ResourceUser {
	ResourceUser(){
		System.out.println("�ý��� �ڿ��� �Ҵ� �޽��ϴ�.");
	}
	void use(){
		System.out.println("�ý��� �ڿ��� ����մϴ�.");
	}
	
	//������ �ݷ��ʹ� ��ü�� �����ϱ� ���� finalize() �޼ҵ带 ȣ���մϴ�.
	protected void finalize(){ //ObjecrŬ������ finalize() �������̵�
		System.out.println("�ý��� �ڿ��� �Ҵ��� �����մϴ�.");
	}
}
