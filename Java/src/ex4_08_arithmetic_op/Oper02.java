package ex4_08_arithmetic_op;

import java.io.InputStream;
import java.util.Scanner;

public class Oper02 {

	public static void main(String[] args) {
		InputStream is = System.in;
		
	//	Ŭ������	��ü   ������ ������ȣ��(���ڰ��� �°Ե�����)
		Scanner sc = new Scanner(is);   
	//	Scanner sc = new Scanner(System.in); //���� ���� ���� �� �ѹ����� ����.
		
		System.out.print("������ �Է� �ϼ���?");
		
		int n = sc.nextInt(); //������ �Է�
		
		System.out.println("�Է°��� " + n + "�Դϴ�.");
		
		sc.close(); //�����Ⱚ ����
	}

}
