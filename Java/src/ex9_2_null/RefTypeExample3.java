package ex9_2_null;
//���� ���� obj�� �ʱ�ȭ ���� �ʾ� �߻��ϴ� ����
public class RefTypeExample3 {

	public static void main(String[] args) {
		Point obj;
		
		//The local variable obj man not have been initialized
		System.out.println(obj.x);

		System.out.println(obj.y);
	}

}
