package ex6_1_array;

public class TwoArr01_1 {

	public static void main(String[] args) {
		String name[] = { "��ȣ��", "�̽±�", "���缮", "����", "�̱���" };
		String sub_name[] = { "����", "����", "����" };

		int[][] score = { { 10, 90, 70 },	//0��(1���л�)
						  { 90, 80, 65 },	//1��(2���л�)
						  { 55, 60, 85 },	//2��(3���л�) 
						  { 90, 75, 95 },	//3��(4���л�) 
						  { 60, 30, 80 } 	//4��(5���л�)
						};

		int[] subject = new int[3]; // �������� ����
		int[] student = new int[5]; // �л��� ���� ����
			//	subject[0] = 0, student[0] = 0; 
			//  subject�� student�� �ʱⰪ 0���� ������
		
		System.out.println("===�� ���� ���� ���ϱ�===");
		//���� ���� ����
		for(int i = 0;i<score.length;i++){
			subject[0] += score[i][0];
		}
	}

}
