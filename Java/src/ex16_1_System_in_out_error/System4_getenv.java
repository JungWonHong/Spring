//ȯ�� ������ �ü���� ���ϴ� ������ �ַ� ���α׷��� ����ȯ���� �����ϴ� �� ����մϴ�.
//ȯ�溯�� path�� ���� �о���� ����
package ex16_1_System_in_out_error;

public class System4_getenv {

	public static void main(String[] args) {
		//getenv() �޼ҵ� : ȯ�� ���� "path"�� �о�ɴϴ�.
		//"path"�� ������ �ٸ� ȯ�� �������� �ü������ �̸��� �ٸ���
		//��� ������ �޶� �ý��� ������Ƽ�� ����մϴ�.
		String str = System.getenv("path");
		System.out.println(str);
	}

}
