package report_0410;

import java.util.Scanner;

public class Problem_no6 {

	public static void main(String[] args) {
		int listcount;	//���� �� ����
		int limit;		//�� �������� ��Ÿ���� ���� ��
		int maxpage;	//�� ������ ��

		Scanner sc = new Scanner(System.in);
		
		System.out.println("�� �������� ��Ÿ�� �� �ִ� ���� �Է��ϼ���.");
		limit = sc.nextInt();
		
		System.out.println("���� �� ������ �Է��ϼ���.");
		listcount = sc.nextInt();
		
		maxpage = (listcount - 1) / limit + 1;
		System.out.println("�� ���������� " + maxpage + "�Դϴ�.");
		
		sc.close();
	}

}
