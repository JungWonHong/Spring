//exit �޼ҵ��� ��� ��
//exit(0) : ���� ����
//exit(0�̿��� ��) : ������ ����
//�ٸ� ���α׷��� ���� �ڹ� ���α׷��� ȣ��Ǿ��� ��� �� ���α׷��� ���� ���� �� �ֱ� ������
//���α׷��� ���� �����ϸ� ���ڰ��� 0���� �ѱ��
//���α׷��� ���������� �����ϸ� ���ڰ��� 1�� �ѱ��.
package ex16_1_System_in_out_error;

public class System7_exit {

	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("���� �� ���� �Է��ϼ���");
			System.exit(1);
		}
		try {
			int num1 = Integer.parseInt(args[0]);
			int num2 = Integer.parseInt(args[1]);
			int sum = num1 + num2;
			System.out.println("sum = " + sum);
			System.exit(0);
		} catch (NumberFormatException e) {
			System.err.println("�߸��� �����Դϴ�.");
			System.exit(-1);
		}
	}

}
