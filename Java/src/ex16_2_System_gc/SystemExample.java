//gc�޼ҵ� ��� ��
package ex16_2_System_gc;

public class SystemExample {

	public static void main(String[] args) {
		//ResourceUser��ü ����
		ResourceUser obj = new ResourceUser();
		
		//ResourceUser��ü ���
		obj.use();
		
		//ResourceUser��ü�� ���̻� �ʿ�ġ ���� ���·� ����ϴ�.
		obj = null;
		
		//������ �÷���(garbage collector) - JVM�ȿ� �ʿ� ���� ��ü���� �ڵ����� �����ϴ� ���
		System.gc(); //�������÷��Ͱ� ������ ���� ���� �ϵ��� JVM���� ��û�ϴ� �޼ҵ�
		//������ �ݷ��ʹ� ��ü�� �����ϱ� ���� finalize() �޼ҵ带 ȣ���մϴ�.
	}

}
