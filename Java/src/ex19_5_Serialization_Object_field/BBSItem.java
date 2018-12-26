//����ȭ�� �Ұ����� Ÿ���� �ʵ带 �����ϴ� ����ȭ ���� Ŭ������ ��
//�⺻���� ����ȭ ��� Ŭ���� Ÿ���� �ʵ�� ��� ����ȭ �����մϴ�.
//Object�� java.io.Serializable �������̽��� �������� �ʱ� ������
//����ȭ ���� Ŭ������ �ƴմϴ�.
package ex19_5_Serialization_Object_field;

public class BBSItem implements java.io.Serializable { // �Խù� Ŭ����
	static int itemnum = 0; // �Խù��� �� - ���� �ʵ�� ����ȭ ����� ���� �ʽ��ϴ�.
	String writer; 			// �۾��� - �ν��Ͻ� �ʵ�� ����ȭ ����� �˴ϴ�.
	transient String passwd;// �н����� - transient Ű���� ���� �ν��Ͻ� �ʵ�
							// ����ȭ ����� ���� �ʽ��ϴ�.
	String title; 			// ���� - �ν��Ͻ� �ʵ�� ����ȭ ����� �˴ϴ�.
	String content; 		// ���� - �ν��Ͻ� �ʵ�� ����ȭ ����� �˴ϴ�.
	Object attachment;		// ÷������ - ����ȭ ����� �ƴմϴ�.

	// �����ڴ� ����ȭ ����� ���� �ʽ��ϴ�.
	BBSItem(String writer, String passwd, String title, String content) {
		this.writer = writer;
		this.passwd = passwd;
		this.title = title;
		this.content = content;
		itemnum++;
	}
	
	//�޼ҵ�� ����ȭ ����� ���� �ʽ��ϴ�.
	void modifyContent(String content, String passwd){
		if(!passwd.equals(this.passwd))
			return;
		this.content = content;
	}
	
	void addAttachment(Object attachment){
		this.attachment = attachment;
	}

}
