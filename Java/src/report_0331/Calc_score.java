package report_0331;

public class Calc_score {

	public static void main(String[] args) {
		String name[] = { "��ȣ��", "�̽±�", "���缮", "����", "�̱���" };
		String sub_name[] = { "����", "����", "����" };

		int[][] score = { { 85, 60, 70 },	//0��(1���л�)
						  { 90, 95, 80 },	//1��(2���л�)
						  { 75, 80, 100 },	//2��(3���л�) 
						  { 80, 70, 95 },	//3��(4���л�) 
						  { 100, 65, 80 } 	//4��(5���л�)
						};

		int[] subject = new int[3]; // �������� ����
		int[] student = new int[5]; // �л��� ���� ����
			//	subject[0] = 0, student[0] = 0; 
			//  subject�� student�� �ʱⰪ 0���� ������
		
		System.out.println("===�� ���� ���� ���ϱ�===");
		for (int i = 0; i < subject.length; i++) {
			for (int j = 0; j < score.length; j++)
				subject[i] += score[j][i];

			System.out.println(sub_name[i] + "�� ���� = " + subject[i]);
		}

		System.out.println();

		System.out.println("===�л��� ���� ���ϱ�===");
		for (int i = 0; i < student.length; i++) {
			for (int j = 0; j < score[i].length; j++)
				student[i] += score[i][j];

			System.out.println(name[i] + "���� = " + student[i]);
		}
		
		System.out.println();

		System.out.println("===========  �л��� / ���� �������ϱ�   ===========");
		System.out.print("\t����\t����\t����\t����\t���\n");
		for (int i = 0; i < name.length; i++) {
			System.out.print(name[i]);
			
			for (int j = 0; j < score[i].length; j++)
				System.out.print("\t" + score[i][j]);
			
			System.out.print("\t" + student[i] + "\t" + student[i] / sub_name.length);
			
			System.out.println();
		}
		
		System.out.println("=============================================");
		
		System.out.print("����");
		
		for (int i = 0; i < subject.length; i++)
			System.out.print("\t" + subject[i]);
		
	}
		/*
		for (int i = 0; i < name.length; i++) {
			for (int j = 0; j < 6; j++) {
				if (j == 0)
					System.out.print(name[i]);
				else if (j >= 1 && j <= 3)
					System.out.print("\t" + score[i][j - 1]);
				else if (j == 4)
					System.out.print("\t" + student[i]);
				else
					System.out.print("\t" + student[i] / sub_name.length);
			}
			System.out.println();
		}*/
		
			
		/*
		// ���� ���� ����
		for (int i = 0; i < score.length; i++) {
			subject[0] += score[i][0];
		}

		// ���� ���� ����
		for (int i = 0; i < score.length; i++) {
			subject[1] += score[i][1];
		}

		// ���� ���� ����
		for (int i = 0; i < score.length; i++) {
			subject[2] += score[i][2];
		}

		for (int i = 0; i < subject.length; i++) {
			System.out.println(sub_name[i] + "�� ���� = " + subject[i]);
		}
		*/
		
		/*
		// 1���л� ����
		for (int i = 0; i < score[i].length; i++) {
			student[0] += score[0][i];
		}

		// 2���л� ����
		for (int i = 0; i < score[i].length; i++) {
			student[1] += score[1][i];
		}

		// 3���л� ����
		for (int i = 0; i < score[i].length; i++) {
			student[2] += score[2][i];
		}

		// 4���л� ����
		for (int i = 0; i < score[i].length; i++) {
			student[3] += score[3][i];
		}

		// 5���л� ����
		for (int i = 0; i < score[i].length; i++) {
			student[4] += score[4][i];
		}

		for (int i = 0; i < student.length; i++) {
			System.out.println(name[i] + "���� = " + student[i]);
		}
		
		
		
		*/
	

}
