package report_0417;

import java.util.Scanner;

public class IDNmber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("�ֹε�Ϲ�ȣ �Է�(exit=e)>>");
			String IDNum = sc.nextLine();
		
			if(IDNum.equals("e"))
				break;
			
			if (checkNumbers(IDNum)) { //14���� �Էµƴ��� Ȯ��
				String[] tkn = tokenizeIDNumbers(IDNum);
				if(tkn==null){ //7��° ���ڰ� "-"�� �ƴϸ� 
					System.out.println("\"-\"�� �������� �ֹε�Ϲ�ȣ ���ڸ�, ���ڸ��� �Է��ϼ���.");
					continue;  //�ٽ� �Է¹ޱ� ���� �ݺ��� ó������
				}
				
				if(!(checkFrontPart(tkn[0]) && checkBackPart(tkn[1])))
					continue; //��� �����̶� ���� �ƴ� ���� ������ �ݺ��� ó������
					
				checkGender(IDNum); //��� ������ ������ ����,�ܱ��� �Ǻ� �� ���
				
				break;  //�ݺ��� ����������.
			} else 
				continue;  //�Էµ� ���ڿ��� ���̰� 14�� �ƴϸ� �ٽ� �Է¹ޱ� ���� �ݺ��� ó������.
		}
		System.out.println("��");
		sc.close();
	}

	// 1.�ֹε�Ϲ�ȣ�� 14������ �Ǻ��ϴ� �޼���
	static boolean checkNumbers(String IDNum) {
		if (IDNum.length() != 14) {
			System.out.println("�ֹε�Ϲ�ȣ�� 14�ڸ� �Դϴ�.");
			return false;
		} else
			return true;
	}

	// 2.7��°���ڰ� "-"���� �Ǻ��ϴ� �޼���
	static boolean check7thNumbers(String IDNum) {
		if (IDNum.substring(6, 7).equals("-"))
			return true;
		else {
			System.out.println("�ֹε�Ϲ�ȣ�� ���Ŀ� ���� �ʽ��ϴ�.(-��ġ)");
			return false;
		}
	}

	// 3.�ֹε�Ϲ�ȣ�� "-"�� �������� �и�
	static String[] tokenizeIDNumbers(String IDNum){
		if (!check7thNumbers(IDNum))
			return null;

		String[] str_tok = IDNum.split("-");
		return str_tok;
	}

	// 4.3������ �и��� ���ڸ��� �������� �Ǻ��ϴ� �޼���
	static boolean checkFrontPart(String FrontIDNum) {
		for (int i = 0; i < FrontIDNum.length(); i++) {
			if (FrontIDNum.charAt(i) < '0' || FrontIDNum.charAt(i) > '9') {
				System.out.println("���ڸ� �Է��ϼ���.");
				return false;
			}
		}
		return true;
	}

	// 5.3������ �и��� ���ڸ��� �������� �Ǻ��ϴ� �޼���
	static boolean checkBackPart(String BackIDNum) {
		for (int i = 0; i < BackIDNum.length(); i++) {
			if (BackIDNum.charAt(i) < '0' || BackIDNum.charAt(i) > '9') {
				System.out.println("���ڸ� �Է��ϼ���.");
				return false;
			}
		}
		return true;
	}

	// ����,����,�ܱ��� �Ǻ�.
	static void checkGender(String IDNum) {
		String gender = IDNum.substring(7, 8);
		if (gender.equals("1") || gender.equals("3"))
			System.out.println("�����Դϴ�.");
		else if (gender.equals("2") || gender.equals("4"))
			System.out.println("�����Դϴ�.");
		else
			System.out.println("�ܱ����Դϴ�.");
	}
}
