package report_0331;

public class Calc_score {

	public static void main(String[] args) {
		String name[] = { "강호동", "이승기", "유재석", "하하", "이광수" };
		String sub_name[] = { "국어", "수학", "영어" };

		int[][] score = { { 85, 60, 70 },	//0행(1번학생)
						  { 90, 95, 80 },	//1행(2번학생)
						  { 75, 80, 100 },	//2행(3번학생) 
						  { 80, 70, 95 },	//3행(4번학생) 
						  { 100, 65, 80 } 	//4행(5번학생)
						};

		int[] subject = new int[3]; // 과목총점 저장
		int[] student = new int[5]; // 학생의 총점 저장
			//	subject[0] = 0, student[0] = 0; 
			//  subject와 student의 초기값 0으로 설정됨
		
		System.out.println("===각 과목별 총점 구하기===");
		for (int i = 0; i < subject.length; i++) {
			for (int j = 0; j < score.length; j++)
				subject[i] += score[j][i];

			System.out.println(sub_name[i] + "의 총점 = " + subject[i]);
		}

		System.out.println();

		System.out.println("===학생별 총점 구하기===");
		for (int i = 0; i < student.length; i++) {
			for (int j = 0; j < score[i].length; j++)
				student[i] += score[i][j];

			System.out.println(name[i] + "총점 = " + student[i]);
		}
		
		System.out.println();

		System.out.println("===========  학생별 / 과목별 총점구하기   ===========");
		System.out.print("\t국어\t수학\t영어\t총점\t평균\n");
		for (int i = 0; i < name.length; i++) {
			System.out.print(name[i]);
			
			for (int j = 0; j < score[i].length; j++)
				System.out.print("\t" + score[i][j]);
			
			System.out.print("\t" + student[i] + "\t" + student[i] / sub_name.length);
			
			System.out.println();
		}
		
		System.out.println("=============================================");
		
		System.out.print("총점");
		
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
		// 국어 과목 총점
		for (int i = 0; i < score.length; i++) {
			subject[0] += score[i][0];
		}

		// 수학 과목 총점
		for (int i = 0; i < score.length; i++) {
			subject[1] += score[i][1];
		}

		// 영어 과목 총점
		for (int i = 0; i < score.length; i++) {
			subject[2] += score[i][2];
		}

		for (int i = 0; i < subject.length; i++) {
			System.out.println(sub_name[i] + "의 총점 = " + subject[i]);
		}
		*/
		
		/*
		// 1번학생 총점
		for (int i = 0; i < score[i].length; i++) {
			student[0] += score[0][i];
		}

		// 2번학생 총점
		for (int i = 0; i < score[i].length; i++) {
			student[1] += score[1][i];
		}

		// 3번학생 총점
		for (int i = 0; i < score[i].length; i++) {
			student[2] += score[2][i];
		}

		// 4번학생 총점
		for (int i = 0; i < score[i].length; i++) {
			student[3] += score[3][i];
		}

		// 5번학생 총점
		for (int i = 0; i < score[i].length; i++) {
			student[4] += score[4][i];
		}

		for (int i = 0; i < student.length; i++) {
			System.out.println(name[i] + "총점 = " + student[i]);
		}
		
		
		
		*/
	

}
