//������
//1. ��Ŭ�������� ���� ����
//	1) �ش� �ҽ����� Ctrl + F11
//	2) Package Explorer���� �ҽ��� ���� �� ������ ���콺 ��ư Ŭ��
//		-> Run as -> Run Configurations
//		-> ������ ȭ���� Arguments �� ���� ��
//		-> Program Arguments ���ڿ��� ���� �Է��Ѵ�.
//		-> �� �� �̻� ���ÿ��� blank, Enter�� �����Ѵ�.


/*2.cmd ȯ��
 C:\workspace_java\Java_ex\bin �ؿ� ��Ű��
 	ex6_2�ȿ� main_arg1.class �� �ִ� ��� ������ //�̰��� �ִٴ� ���� Ȯ���ϴ� ���� �߿��ϴ�.
 	
ù° : C:\User\User>Java - classpath "C:\workspace_Java\Java_ex\bin" ex6_2.main_arg1 ������ �α��� ����
	C:\User\User>Java - cp "C:\workspace_java\Java_ex\bin" ex6_2.main_arg1 ������ �α��� ����

�Ѥ� : C:\workspace_Java\Java_ex\bin>java ex6_2.main_arg1 ��s���� �α��� ����

��° : ȯ�溯�� ���� classpath���� ";C:\workspace_Java\Java_ex\bin�� ������ �ָ�
	C:\User\User>Java ex6_2.main_arg1 ������ �α��� ����

 */

package ex6_3_method;

public class main_arg1 {

	public static void main(String[] a) {

		System.out.println(a[0]);
		System.out.println(a[1]);
		System.out.println(a[2]);
		
	}

}

