package ex6_1_array;

import java.util.Scanner;

public class ArrayTest07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] names = new String[] { "������", "����ġ", "�������", "������", "�̼���", "�Ż��Ӵ�" };
		String input;
		int index = -1;
		
		System.out.println("�˻��� �̸��� �Է��ϼ���?");
		System.out.print("�̸�:");
		input = sc.next();

		for (int i = 0; i < names.length; i++) {
			if (input.equals(names[i])) {
				index = i;
				break;
			}	
		}

		if (index != -1)
			System.out.println(input + "��(��) �迭�� " + index + "�濡�� ã�ҽ��ϴ�.");
		else
			System.out.println(input + "��(��) �迭�濡�� ã�� ���߽��ϴ�.");
		
		sc.close();
	}

}
